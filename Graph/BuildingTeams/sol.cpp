#include <iostream>
#include <vector>   
#include <queue>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> adj(n+1);
    vector<int> color(n+1, 0);
    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        adj[x].push_back(y);
        adj[y].push_back(x);
    }
    for (int i = 1; i <= n; i++) {
        if (color[i]==0) {
            color[i]=1;
            queue<int> q;
            q.push(i);
            while (!q.empty()) {
                int a = q.front();
                q.pop();
                for (int b : adj[a]) {
                    if (color[b]==0) {
                        color[b]=-color[a];
                        q.push(b);
                    } else if (color[a]==color[b]) {
                        cout << "IMPOSSIBLE" << endl;
                        return 0;
                    }
                }
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        if (color[i]>0) {
            cout << color[i] << " ";
        } else {
            cout << 2 << " ";
        }
    }
    cout << endl;
    return 0;
}