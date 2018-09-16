import java.util.Scanner;

public class z1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int max = 0;
        for (int i = 0; i<a; i++) {
            int b = sc.nextInt();
            if (b>0 && b>max) {
                max = b;
            }
            if (b<0 && -b>max) {
                max = b;
            }
        }
        System.out.println(max);
    }
}