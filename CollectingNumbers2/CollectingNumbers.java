package CollectingNumbers2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;


public class CollectingNumbers {
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
        int n = fs.nextInt(), q = fs.nextInt();
        int[] ind = new int[n+1];
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int x = fs.nextInt();
            ind[x]=i;
            arr[i]=x;
        }
        int rounds = 1;
        for (int i = 1; i < n; i++) {
            if (ind[i] > ind[i+1]) {
                rounds++;
            }
        }
        int[] pairs = new int[4];
        while (q > 0) {
            int x = fs.nextInt(), y = fs.nextInt();

            int x1 = arr[x], x2 = arr[y];
            
            int cnt = 0;
            if (x1 > 1) pairs[cnt++] = x1-1;
            if (x1 < n) pairs[cnt++] = x1;
            if (x2 > 1) pairs[cnt++] = x2-1;
            if (x2 < n) pairs[cnt++] = x2;

            Arrays.sort(pairs, 0, cnt);
            
            int uni = 0;
            for (int i = 0; i < cnt; i++) {
                if (i==0 || pairs[i] != pairs[i-1]) {
                    pairs[uni++] = pairs[i];
                }
            }

            for (int i = 0; i < uni; i++) {
                int p = pairs[i];
                if (ind[p] > ind[p+1]) rounds--;
            }
            
            arr[x] = x2;
            arr[y] = x1;

            ind[x1] = y;
            ind[x2] = x;

            for (int i = 0; i < uni; i++) {
                int p = pairs[i];
                if (ind[p] > ind[p+1]) rounds++;
            }

            q--;
            out.println(rounds);
        }
        out.flush();
    }
}
