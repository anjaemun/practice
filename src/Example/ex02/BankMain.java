package Example.ex02;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int sel;
        while (run) {
            System.out.println("============================================================");
            System.out.println("1.계좌 등록 2.잔액 조회 3.입금 4.출금 5.거래 내역 6.계좌 이체 0.종료");
            System.out.println("============================================================");
            System.out.print("업무 선택 > ");
            sel = sc.nextInt();
            if (sel == 1) {
                bankService.save();
            } else if (sel == 2) {
                bankService.balanceCheck();
            } else if (sel == 3) {
                bankService.deposit();
            } else if (sel == 4) {
                bankService.withdraw();
            } else if (sel == 5) {
                bankService.details();
            } else if (sel == 6) {

            } else if (sel == 0) {
                run = false;
            }
        }
    }
}
