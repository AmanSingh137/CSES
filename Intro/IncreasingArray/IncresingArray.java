package Intro.IncreasingArray;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class IncresingArray {
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
        int[] arr = new int[n];

        for (int i =0; i < n; i++) {
            arr[i] = fs.nextInt();
        }
        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i-1]) {
                ans += (arr[i-1] - arr[i]);
                arr[i]=arr[i-1];
            }
        }
        out.print(ans);
        out.flush();
    }
}
