package Apartments;

import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        int k = Integer.parseInt(first[2]);

        String[] arrStr = br.readLine().split(" ");
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(arrStr[i]));
        }
        String[] brrStr = br.readLine().split(" ");
        ArrayList<Integer> b = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            b.add(Integer.parseInt(brrStr[j]));
        }


        Collections.sort(a);
        Collections.sort(b);

        int i = 0, j = 0, ans =0;
        while (i < n && j < m) {
            if (a.get(i) < b.get(j)-k) {
                i++;
            } else if (a.get(i)>b.get(j)+k) {
                j++;
            } else {
                i++;
                j++;
                ans++;
            }
        }
        out.print(ans);
        out.flush();
    }
}