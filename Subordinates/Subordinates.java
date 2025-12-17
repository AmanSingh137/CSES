package Subordinates;

import java.io.*;
// import java.util.*;

public class Subordinates {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();
        if (n == -1) return;

        int[] parent = new int[n + 1];
        int[] childrenCount = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            parent[i] = fs.nextInt();
            childrenCount[parent[i]]++;
        }

        int[] queue = new int[n];
        int head = 0, tail = 0;
        for (int i = 1; i <= n; i++) {
            if (childrenCount[i] == 0) {
                queue[tail++] = i;
            }
        }

        int[] ans = new int[n + 1];
        
        while (head < tail) {
            int curr = queue[head++];
            if (curr == 1) continue; 
            
            int p = parent[curr];
            ans[p] += (1 + ans[curr]);
            
            childrenCount[p]--;
            if (childrenCount[p] == 0) {
                queue[tail++] = p;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(i == n ? "" : " "); 
        }
        out.println(sb);
        out.flush();
        out.close();
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c = read();
            while (c >= 0 && c <= 32) c = read();
            if (c == -1) return -1;
            int res = 0;
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res;
        }
    }
}