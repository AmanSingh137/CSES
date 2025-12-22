#include <iostream>
#include <climits>
#include <vector>
#include <queue>
#include <utility>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    vector<string> vec;
    vector<string> results;
    for (int i = 0; i < n; i++) {
        string t;
        cin >> t;
        vec.push_back(t);
    }
    vector<vector<int>> vis (n, vector<int>(m, 0));
    queue<pair<pair<int, int>, string>> st;
    for (int i = 0; i < n; i++) {
        int fl=0;
        for (int j = 0; j < m; j++) {
            if (vec[i][j]=='A') {
                st.push({{i,j}, ""});
                fl=1;
                break;
            }
        }
        if (fl) break;
    }
    while(!st.empty()) {
        auto p = st.front();
        st.pop();
        int x = p.first.first;
        int y = p.first.second;
        string cur = p.second;
        if (vec[x][y]=='B') {
            results.push_back(cur);
            break;
        }
        if (vis[x][y]==1) continue;
        vis[x][y]=1;
        int a[] = {0, 0, -1, 1};
        int b[] = {-1, 1, 0, 0};
        char c[] = {'L', 'R', 'U', 'D'};
        for (int i = 0; i < 4; i++) {
            if (x+a[i] < 0 || y+b[i] < 0 || x+a[i]>=n || y+b[i]>=m) continue;
            else if (vec[x+a[i]][y+b[i]]=='.' || vec[x+a[i]][y+b[i]]=='B') {
                st.push({{x+a[i], y+b[i]}, cur+c[i]});
            }
        }
    }
    if(results.size()==0) {
        cout << "NO" << endl;
        return 0;
    }
    
    cout << "YES" << endl << results[0].size() << endl << results[0] << endl;
    return 0;
}


