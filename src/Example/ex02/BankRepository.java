package Example.ex02;

import java.util.ArrayList;
import java.util.List;

public class BankRepository {
    List<ClientDTO> clientDTOList = new ArrayList<>();
    List<AccountDTO> accountDTOList = new ArrayList<>();

    public boolean save(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }

    public ClientDTO balanceCheck(String accountNumber) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                return clientDTO;
            }
        }
        return null;
    }

    public ClientDTO deposit(String accountNumber, long deposit) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                long balance = clientDTO.getBalance();
                balance += deposit;
                clientDTO.setBalance(balance);

                AccountDTO accountDTO = new AccountDTO(accountNumber, deposit, 0);
                accountDTOList.add(accountDTO);

                return clientDTO;
            }
        }
        return null;
    }

    public ClientDTO accountCheck(String accountNumber) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                return clientDTO;
            }
        }
        return null;
    }

    public boolean withdraw(String accountNumber, String clientPassword, long withdraw) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                if (clientPassword.equals(clientDTO.getClientPassword())) {
                    if (clientDTO.getBalance() >= withdraw) {
                        long balance = clientDTO.getBalance();
                        balance += withdraw;
                        clientDTO.setBalance(balance);

                        AccountDTO accountDTO = new AccountDTO(accountNumber, 0, withdraw);
                        accountDTOList.add(accountDTO);

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<AccountDTO> allDetails(String accountNumber) {
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for (AccountDTO accountDTO : accountDTOList) {
            if (accountNumber.equals(accountDTO.getAccountNumber())) {
                accountDTOS.add(accountDTO);
            }
        }
        return accountDTOS;
    }

}
