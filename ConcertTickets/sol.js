const fs = require('fs');

const input = fs.readFileSync(0, 'utf8').trim().split(/\s+/);
let idx = 0;
const next = () => Number(input[idx++]);

let n = next();
let m = next();

let a = [];
let parent= new Array(n);

for (let i = 0; i < n; i++) a.push(next());
for (let i = 0; i < n; i++) parent[i]=i;

a.sort((x, y) => x - y);

function findParent(x) {
    if (x < 0) return -1;
    if (parent[x]===x) return x;
    return parent[x] = findParent(parent[x]);
}

function upperBound(a, val) {
    let l = 0, r = a.length;
    while (l < r) {
        let mid = (l+r) >> 1;
        if (a[mid]<=val) l = mid+1;
        else r= mid;
    }
    return l;
}
let ans = '';
while (m--) {
    let val = Number(next());
    let j = upperBound(a, val);
    if (j===0) {
        ans += '-1\n';
    } else {
        let idx = findParent(j-1);
        if (idx===-1 || a[idx] > val) {
            ans += '-1\n';
        } else {
            let p = a[idx];
            ans += p.toString();
            ans += '\n';
            parent[idx]=findParent(idx-1);
        }
    }
}

console.log(ans);


// adding comment for fixing git, ignore please