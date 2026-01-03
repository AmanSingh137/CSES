package Intro.Permutations;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Permutations {
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
    public static void main (String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        if (n%2==0) {
            int k = 2, j = -1;
            for (int i =0; i < n; i++) {
                arr.add(k);
                k += 2;
                if (k > n) {
                    j = i++;
                    break;
                }
            }
            k = 1;
            for (int i = j+1; i < n; i++) {
                arr.add(k);
                k += 2;
                if (k > n) {
                    break;
                }
            }
            int m = arr.size();
            if (m<n) {
                out.print("NO SOLUTION");
            } else {
                int fl = 1;
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < n-1; i++) {
                    if (Math.abs(arr.get(i) - arr.get(i+1)) == 1) {
                        out.print("NO SOLUTION");
                        fl = 0;
                        break;
                    }
                    res.append(arr.get(i));
                    res.append(" ");
                }
                if (fl==1) {
                    res.append(arr.get(n-1));
                    out.print(res);
                }
            }
        } else {
            int k = n, j = -1;
            for (int i = 0; i < n; i++) {
                arr.add(k);
                k -= 2;
                if (k <= 0) {
                    j = i++;
                    break;
                }
            }
            k = n-1;
            for (int i = j+1; i < n; i++) {
                arr.add(k);
                k-=2;
                if (k <= 0) {
                    break;
                }
            }
            int m = arr.size();
            if (m<n) {
                out.print("NO SOLUTION");
            } else {
                int fl = 1;
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < n-1; i++) {
                    if (Math.abs(arr.get(i) - arr.get(i+1)) == 1) {
                        out.print("NO SOLUTION");
                        fl = 0;
                        break;
                    }
                    res.append(arr.get(i));
                    res.append(" ");
                }
                if (fl==1) {
                    res.append(arr.get(n-1));
                    out.print(res);
                }
            }
        }

        out.flush();
    }
}
