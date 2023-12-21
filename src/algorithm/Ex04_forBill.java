package algorithm;

import java.util.Scanner;

public class Ex04_forBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int sum = 0;
        int X = sc.nextInt();
        int N = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        while (run) {
            sum = sum + (a*b);
            if (sum == X){
                System.out.println("yes");
            }else {
                System.out.println("No");
            }


            run = false;
        }

    }
}
