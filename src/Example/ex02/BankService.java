package Example.ex02;

import java.util.List;
import java.util.Scanner;

public class BankService {
    Scanner sc = new Scanner(System.in);
    BankRepository bankRepository = new BankRepository();

    public void save() {
        System.out.print("성명 > ");
        String clientName = sc.next();
        System.out.print("계좌 번호 > ");
        String accountNumber = sc.next();
        System.out.print("비밀 번호 > ");
        String clientPassword = sc.next();

        ClientDTO clientDTO = new ClientDTO(clientName, accountNumber, clientPassword);
        boolean save = bankRepository.save(clientDTO);
        if (save) {
            System.out.println("등록 완료");
        } else {
            System.out.println("등록 실패");
        }
    }

    public void balanceCheck() {
        System.out.print("계좌 번호 > ");
        String accountNumber = sc.next();
        ClientDTO clientDTO = bankRepository.balanceCheck(accountNumber);
        if (clientDTO != null) {
            System.out.println(clientDTO.getBalance());
        } else {
            System.out.println("계좌가 존재하지 않습니다.");
        }
    }

    public void deposit() {
        System.out.print("계좌 번호 > ");
        String accountNumber = sc.next();
        System.out.print("입금액 > ");
        long deposit = sc.nextLong();
        ClientDTO clientDTO = bankRepository.deposit(accountNumber, deposit);
        if (clientDTO != null) {
            System.out.println("입금 완료");
            System.out.println("잔액 : " + clientDTO.getBalance());
        } else {
            System.out.println("입금 실패");
        }

    }

    public void withdraw() {
        System.out.print("계좌 번호 > ");
        String accountNumber = sc.next();
        ClientDTO accountCheck = bankRepository.accountCheck(accountNumber);
        if (accountCheck != null) {
            System.out.print("비밀 번호 > ");
            String clientPassword = sc.next();
            System.out.print("출금액 > ");
            long withdraw = sc.nextLong();
            boolean result = bankRepository.withdraw(accountNumber, clientPassword, withdraw);
            if (result) {
                System.out.println("출금 완료");
            } else {
                System.out.println("입력 정보가 올바르지 않습니다.");
            }
        } else {
            System.out.println("존재하지 않은 계좌입니다.");
        }

    }

    public void details() {
        boolean run = true;
        System.out.print("계좌 번호 > ");
        String accountNumber = sc.next();
        ClientDTO accountCheck = bankRepository.accountCheck(accountNumber);
        if (accountCheck != null) {
            while (run) {
                System.out.println("=====================================");
                System.out.println("1.전체 내역 2.입금 내역 3.출금 내역 4.종료");
                System.out.println("=====================================");
                int sel = sc.nextInt();
                List<AccountDTO> accountDTOList = bankRepository.allDetails(accountNumber);
                if (!accountDTOList.isEmpty()) {
                    if (sel == 1) {
                        for (AccountDTO accountDTO : accountDTOList) {
                            System.out.println("accountDTO = " + accountDTO);
                        }
                    } else if (sel == 2) {
                        for (AccountDTO accountDTO : accountDTOList) {
                            if (accountDTO.getDeposit() > 0) {
                                System.out.println("accountDTO = " + accountDTO);
                            }
                        }
                    } else if (sel == 3) {
                        for (AccountDTO accountDTO : accountDTOList) {
                            if (accountDTO.getWithdraw() > 0) {
                                System.out.println("accountDTO = " + accountDTO);
                            }
                        }
                    } else if (sel == 4) {
                        run = false;
                    } else {
                        System.out.println("없는 항목입니다.");
                    }
                }
            }
        } else {
            System.out.println("존재하지 않는 계좌입니다.");
        }
    }

}
