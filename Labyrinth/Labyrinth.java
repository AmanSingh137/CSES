package Labyrinth;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Labyrinth {
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
    public static StringBuilder ans = new StringBuilder();
    public static boolean reachable (int[][] vis, char[][] a, int i, int j, int n, int m, StringBuilder s) {
        if (i < 0 || j < 0 || i >= n || j >= m) return false;
        if (a[i][j]=='#') return false;
        if (vis[i][j]==1) return false;
        if (a[i][j]=='B') {
            ans = s;
            return true;
        }
        vis[i][j]=1;
        
        return reachable(vis, a, i, j-1, n, m, (new StringBuilder()).append('L')) || 
        reachable(vis, a, i, j+1, n, m, (new StringBuilder()).append('R')) ||
        reachable(vis, a, i-1, j, n, m, (new StringBuilder()).append('U')) ||
        reachable(vis, a, i+1, j, n, m, (new StringBuilder()).append('D'));
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt(), m = fs.nextInt();

        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(fs.nextString());
        }

        char[][] a = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j]=arr.get(i).charAt(j);
            }
        }
        int[][] vis = new int[n][m];
        boolean check = false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]==0 && a[i][j]=='A') {
                    check = reachable(vis, a, i, j, n, m, new StringBuilder());
                    if (check) {
                        out.println("YES");
                        out.println(ans.length());
                        out.println(ans);
                        out.flush();
                        return;
                    }
                }
            }
        }
        out.print("NO");
        out.flush();
    }
}
