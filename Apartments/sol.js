const fs = require('fs');

const input = fs.readFileSync(0, 'utf-8').trim().split(/\s+/);
let idx = 0;
const next = () => input[idx++];

const n = Number(next());
const m = Number(next());
const k = Number(next());

let a = [];
for (let i = 0; i < n; i++) {
    a.push(Number(next()));
}

let b = [];
for (let i = 0; i < m; i++) {    
    b.push(Number(next()));
}

a.sort((x, y) => x - y);
b.sort((x, y) => x - y);

let i = 0, j = 0, ans = 0;

while (i < n && j < m) {
    if (b[j] < a[i] - k) {
        j++;
    } else if (b[j] > a[i] + k) {
        i++;
    } else {
        ans++;
        i++;
        j++;
    }
}

console.log(ans);
