package algorithm;

import java.util.Scanner;

public class Ex01_time {
    public static void main(String[] args) {
        int A,B,C; // 시, 분, 소요시간
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        int min = 60 * A + B;   // 시 -> 분
        min = min + C;

        int hour = (min / 60) % 24;
        int minute = min % 60;

        System.out.println(hour + " " + minute);
    }
}
