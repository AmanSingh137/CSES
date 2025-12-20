package TreeMatching;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class TreeMatching {
    static int n;
    static int[] to, head, next;
    static int ec = 0;
    static boolean[] mat;
    static int ms = 0;
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ')
                if (c == -1)
                    return -1;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = c - '0';
            while ((c = read()) > ' ')
                val = val * 10 + (c - '0');
            return val * sign;
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ')
                if (c == -1)
                    return -1;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = c - '0';
            while ((c = read()) > ' ')
                val = val * 10 + (c - '0');
            return val * sign;
        }
        String nextString() throws IOException {
            int c;
            while ((c = read()) <= ' ')
                if (c == -1)
                    return null;

            StringBuilder sb = new StringBuilder();
            sb.append((char) c);

            while ((c = read()) > ' ')
                sb.append((char) c);

            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> {
            try {
                solve();
            } catch (Exception e) {}
        }, "solver", 1 << 28); 
        thread.start();
    }
    public static void makeConnection(int a, int b) {
        to[ec]=b;
        next[ec]=head[a];
        head[a]=ec++;
    }
    public static void solve() throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        n = fs.nextInt();
        if (n == 1) {
            out.print(0);
            out.flush();
            return;
        } 
        head = new int[n+1];
        Arrays.fill(head, -1);
        to = new int[2*n];
        next = new int[2*n];
        ec=0;
        for (int i = 0; i < n-1; i++) {
            int x, y;
            x = fs.nextInt();
            y = fs.nextInt();
            makeConnection(x, y);
            makeConnection(y, x);
        }
        mat = new boolean[n+1];
        dfs(1, -1);
        out.print(ms);
        out.flush();
    }
    static void dfs(int u, int p) {
        for (int i = head[u]; i != -1; i = next[i]) {
            int v = to[i];
            if (v != p) {
                dfs(v, u);
                if (!mat[v] && !mat[u]) {
                    mat[u]=true;
                    mat[v]=true;
                    ms++;
                }
            }
        }
    }
}
