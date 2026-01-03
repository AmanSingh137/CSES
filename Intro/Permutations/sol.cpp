#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;
    if (n==4) {
        cout << "2 4 1 3" << endl;
        return 0;
    }
    vector<int> arr(n);
    int k = n, j = -1;
    for (int i = 0; i < n; i++) {
        arr[i]=k;
        k -= 2;
        if (k <= 0) {
            j = i++;
            break;
        }
    }
    k = n-1;
    for (int i = j+1; i < n; i++) {
        arr[i] = k;
        k -= 2;
        if (k <= 0) break;
    } 
    for (int i = 0; i < n-1; i++) {
        if (arr[i]==0 || abs (arr[i]-arr[i+1]) == 1) {
            cout << "NO SOLUTION" << endl;
            return 0;
        }
    }
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}