package Graph.MessageRoute;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class MessageRoute {
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

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();
        int m = fs.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = fs.nextInt();
            int y = fs.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int[] vis = new int[n+1];
        vis[1]=1;
        ArrayList<Integer> parent = new ArrayList<>();
        for (int i = 0; i <= n; i++) parent.add(0);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        int fl = 0;
        while (!dq.isEmpty()) {
            int a = dq.getFirst();
            dq.removeFirst();
            if (a==n) {
                fl = 1;
                break;
            }
            for (int node : adj.get(a)) {
                if (vis[node]==1) continue;
                else {
                    dq.addLast(node);
                    vis[node]=1;
                    parent.set(node, a);
                }
            }
        }
        if (fl==0) {
            out.print("IMPOSSIBLE");
        } else {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(n);
            int k = n;
            while (parent.get(k) != 1) {
                k = parent.get(k);
                ans.add(k);
            }
            ans.add(1);
            Collections.reverse(ans);
            StringBuilder res = new StringBuilder();
            for (int a : ans) {
                res.append(a);
                res.append(" ");
            }
            out.println(ans.size());
            out.print(res);
        }

        out.flush();
    }
}
