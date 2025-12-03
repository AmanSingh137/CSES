#include <iostream>
#include <functional>
#include <algorithm>
#include <set>
using namespace std;

int main() {
    int n, x;
    cin >> n >> x;
    multiset<int> mpp;
    for (int i = 0; i < n; i++)
    {
        int k;
        cin >> k;
        mpp.insert(k);
    }
    int cnt = 0;
     while (!mpp.empty()) {
        auto it = prev(mpp.end());
        int w = *it;
        mpp.erase(it);
        auto it2 = mpp.upper_bound(x - w);
        if (it2 != mpp.begin()) {
            --it2;
            if (*it2 <= x - w) {
                mpp.erase(it2);
            }
        }

        cnt++;
    }
    cout << cnt;
    return 0;
}