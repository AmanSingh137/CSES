#include <iostream>
#include <vector>
#include <set>
#include <functional>
#include <climits>
#include <algorithm>
using namespace std;

static bool cmp(vector<int>& a, vector<int>& b) {
    if (a[1]==b[1]) return a[0] < b[0];
    return a[1] < b[1];
}


int main() {
    int n;
    cin >> n;
    vector<vector<int>> vec(n, vector<int> (2, 0));
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        vec[i][0]=x;
        vec[i][1]=y;
    }
    sort(vec.begin(), vec.end(), cmp);
    int et = 0, ans =0;
    for (int i = 0; i < n; i++) {
        if (vec[i][0] >= et) {
            ans++;
            et=vec[i][1];
        }
    }
    cout << ans;
    return 0;
}