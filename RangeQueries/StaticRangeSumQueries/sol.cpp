#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    vector<long long> v(n);
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        if (i==0) v[i]=x;
        else v[i]=v[i-1]+x;
    }

    while (m--) {
        int a, b;
        cin >> a >> b;
        if (a==1) {
            cout << v[b-1] << endl;
        } else {
            cout << v[b-1] - v[a-2] << endl;
        }
    }
    return 0;
}