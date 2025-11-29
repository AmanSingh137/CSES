#include <iostream>
#include <set>
#include <functional>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    multiset<int> tickets;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        tickets.insert(x);
    }

    while (m--) {
        int x;
        cin >> x;

        auto it = tickets.upper_bound(x);

        if (it == tickets.begin()) {
            cout << -1 << "\n";
        } else {
            --it;
            cout << *it << "\n";
            tickets.erase(it);
        }
    }

    return 0;
}
