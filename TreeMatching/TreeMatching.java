package TreeMatching;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TreeMatching {
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
    public static int solve(ArrayList<ArrayList<Integer>> arr, int i, int[] vis){
        if (i >= arr.size()) return 0;
        
        int x = arr.get(i).get(0), y = arr.get(i).get(1);
        if (vis[x]==1 || vis[y]==1) return solve(arr, i+1, vis);
        int ans = solve(arr, i+1, vis);
        if (vis[x]==0 && vis[y]==0) {
            vis[x]=1;
            vis[y]=1;
            ans = Math.max(ans, 1+solve(arr, i+1, vis));
            vis[x]=0;
            vis[y]=0;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = fs.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            int x, y;
            x = fs.nextInt();
            y = fs.nextInt();
            arr.add(new ArrayList<>());
            arr.get(i).add(x);
            arr.get(i).add(y);
        }
        int[] vis = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i]=-1;
        }
        int result = solve(arr, 0, vis);
        out.print(result);
        out.flush();
    }
}
