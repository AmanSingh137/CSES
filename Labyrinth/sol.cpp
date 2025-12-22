#include <iostream>
#include <climits>
#include <vector>
#include <queue>
#include <utility>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;
    vector<string> vec;
    for (int i = 0; i < n; i++) {
        string t;
        cin >> t;
        vec.push_back(t);
    }
    vector<vector<int>> vis (n, vector<int>(m, 0));
    queue<pair<int, int>> st;
    int l1 = -1, l2=-1;
    for (int i = 0; i < n; i++) {
        int fl=0;
        for (int j = 0; j < m; j++) {
            if (vec[i][j]=='A') {
                vis[i][j]=1;
                st.push({i,j});
                l1=i;
                l2=j;
                fl=1;
                break;
            }
        }
        if (fl) break;
    }
    string results;
    vector<vector<pair<int, int>>> parent(n, vector<pair<int,int>> (m, {-1, -1}));
    vector<vector<char>> dir (n, vector<char>(m));
    int k1=-1, k2=-1;
    while(!st.empty()) {
        auto p = st.front();
        st.pop();
        int x = p.first;
        int y = p.second;
        if (vec[x][y]=='B') {
            k1=x;
            k2=y;
            break;
        }
        int a[] = {0, 0, -1, 1};
        int b[] = {-1, 1, 0, 0};
        char c[] = {'L', 'R', 'U', 'D'};
        for (int i = 0; i < 4; i++) {
            if (x+a[i] < 0 || y+b[i] < 0 || x+a[i]>=n || y+b[i]>=m) continue;
            if (vis[x+a[i]][y+b[i]]==1 || vec[x+a[i]][y+b[i]]=='#') continue;
            else if (vec[x+a[i]][y+b[i]]=='.' || vec[x+a[i]][y+b[i]]=='B') {
                vis[x+a[i]][y+b[i]]=1;
                st.push({x+a[i], y+b[i]});
                parent[x+a[i]][y+b[i]]={x,y};
                dir[x+a[i]][y+b[i]]=c[i];
            }
        }
    }
    if (k1==-1) {
        cout << "NO" << endl;
        return 0;
    }

    while (!(l1==k1 && l2==k2)) {
        results.push_back(dir[k1][k2]);
        auto p = parent[k1][k2];
        k1 = p.first;
        k2 = p.second;
    }
    reverse(results.begin(), results.end());
    cout << "YES" << endl << results.size() << endl << results << endl;
    return 0;
}


