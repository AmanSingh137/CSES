#include <iostream>
#include <unordered_map>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, x;
    cin >> n >> x;
    vector<int> vec(n), rec(n);
    int tl = 0;
    for (int i = 0; i < n; i++) {
        int k;
        cin >> k;
        vec[i]=k;
        rec[i]=k;
        if (k < x) {
            tl++;
        }
    }
    if (tl < 2) {
        cout << "IMPOSSIBLE";
        return 0;
    }
    
    sort(vec.begin(), vec.end());

    int l = 0, r = n-1, in1 = -1, in2 = -1;
    while (l < r) {
        if (vec[l]+vec[r]==x) {
            in1 = l;
            in2 = r;
            break;
        }
        else if (vec[l]+vec[r]>x) {
            r--;
        } else {
            l++;
        }
    }

    if (in1 == -1 || in2 == -1) {
        cout << "IMPOSSIBLE";
    } else {
        int an1 = -1, an2 =-1;
        for (int i = 0; i < n; i++) {
            if (rec[i]==vec[in1]) {
                an1 = i+1;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (rec[i]==vec[in2] && (i+1 != an1)) {
                an2 = i+1;
                break;
            }
        }
        cout << an1 << " " << an2;
    }
    
    return 0;
}