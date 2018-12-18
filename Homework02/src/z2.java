import java.util.Scanner;

public class z2 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max_1 = -1000000000, max_2 = -1000000000, number;
        for(int i = 0;i < n; i++) {
            number = in.nextInt();
            if (max_1 < number) {
                max_2 = max_1;
                max_1 = number;
            }
            else
            {
                if( max_2 < number)
                    max_2 = number;
            }
        }
        System.out.println(max_1 + " " + max_2);
    }
}