#include <iostream>
#include <vector>
#include <algorithm>
#include <functional>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m, k;
    cin >> n >> m >> k;
    vector<int> a(n), b(m);
    for (int i =0; i < n; i++) {
        int c;
        cin >> c;
        a[i]=c;
    }
    int cnt = 0;
    for (int i = 0; i < m; i++) {
        int c;
        cin >> c;
        b[i]=c;
    }
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());

    int i = 0, j = 0;
    while (i < n && j < m){
        if (a[i]>b[j]+k) {
            j++;
        } else if (a[i]<b[j]-k) {
            i++;
        } else {
            i++;
            j++;
            cnt++;
        }
    }

    cout << cnt;
    return 0;
}