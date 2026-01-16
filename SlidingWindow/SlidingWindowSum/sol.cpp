#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    vector<long long> arr(n), dummy (n);
    int x, a, b, c;
    cin >> x >> a >> b >> c;
    arr[0]=x;
    dummy[0] = arr[0];
    for (int i = 1; i < n; i++) {
        arr[i] = (arr[i-1]*a + b) % c;
        dummy[i] = dummy[i-1] + arr[i];
    }
    int l = 0, r = k-1;
    vector<long long> result;
    while (r < n) {
        long long temp;
        if (l==0) temp = dummy[r];
        else {
            temp = dummy[r]-dummy[l-1];
        }
        result.push_back(temp);
        r++;
        l++;
    }
    long long ans = 0;
    int m = result.size();
    for (int i = 0; i < m; i++) {
        ans = ans ^ result[i];
    }
    cout << ans << endl;
    return 0;
}