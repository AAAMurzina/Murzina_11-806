import java.util.Scanner;

public class Z2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char c = 0;
        String s = sc.next();
        char[] a = s.toCharArray();
        int m = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                a[m] =  c;
                a[j+1] = a[j];
                a[1] = c;
            }
        }
        for (int i = 0; i <m; i++) {
            System.out.println(a[i]);
        }
    }
}