package Graph.BuildingRoads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BuildingRoads {
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
    public static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        if (vis[node]==1) return;
        vis[node]=1;
        for (int i : adj.get(node)) {
            dfs(i, vis, adj);
        }
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n, m;
        n = fs.nextInt();
        m = fs.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = fs.nextInt();
            y = fs.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int[] vis = new int[n+1];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (vis[i]==0) {
                ans.add(i);
                dfs(i, vis, adj);
            }
        }
        StringBuilder an = new StringBuilder();
        int k = ans.size();
        out.println(k - 1);
        for (int i = 1; i < k; i++) {
            an.append(ans.get(i-1) + " " + ans.get(i) + "\n");
        }
        out.print(an);
        out.flush();
    }
}
