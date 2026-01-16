#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>
#include <unordered_map>
using namespace std;

bool verify(vector<int>& v, int a, int b) {
    int l = 0, r = v.size()-1;
    while (l < r) {
        int mid = (l+r)/ 2;
        if (v[mid] >= a && v[mid] <= b) {
            return true;
        } else if (v[mid] > b) {
            r = mid-1;
        } else l = mid+1;
    }
    return false;
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<int> v(n), d(n), c(n);
    unordered_map<int, vector<int>> mpp;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        d[i]=x;
        mpp[x].push_back(i);
        if (i==0) v[i]=x;
        else v[i]= min(v[i-1], x);
    }
    for (int i = n-1; i >= 0; i--) {
        if (i==n-1) c[i]=d[i];
        else c[i]=min(c[i+1], d[i]);
    }
    while (m--) {
        int a, b;
        cin >> a >> b;
        
    }
    return 0;
}