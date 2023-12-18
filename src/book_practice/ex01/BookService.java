package book_practice.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {
    BookRepository bookRepository = new BookRepository();
    Scanner sc = new Scanner(System.in);
    List<BookDTO> bookDTOList = new ArrayList<>();

    public void save() {
        System.out.print("제목 > ");
        String bookTitle = sc.next();
        System.out.print("저자 > ");
        String bookAuthor = sc.next();
        System.out.print("가격 > ");
        int bookPrice = sc.nextInt();
        System.out.print("출판사 > ");
        String bookPublisher = sc.next();
        BookDTO bookDTO = new BookDTO(bookTitle, bookAuthor, bookPrice, bookPublisher);
        boolean result = bookRepository.save(bookDTO);
        if (result) {
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }
    }

    public void list() {
        List<BookDTO> bookDTOList1 = bookRepository.list();
        for (int i = 0; i < bookDTOList1.size(); i++) {
            System.out.println(bookDTOList1.get(i));
        }

    }

    public void findById() {
        System.out.print("찾을 id > ");
        Long id = sc.nextLong();
        boolean result = bookRepository.findById(id);
        for (BookDTO bookDTO : bookDTOList) {
            if (result) {
                System.out.println("bookDTO = " + bookDTO);
            } else {
                System.out.println("존재하지 않습니다.");
            }
        }
    }

    public void findByTitle() {
        System.out.print("찾을 도서명 > ");
        String bookTitle = sc.next();
        boolean result = bookRepository.findByTitle(bookTitle);
        for (BookDTO bookDTO : bookDTOList) {
            if (result) {
                System.out.println("bookDTO = " + bookDTO);
            } else {
                System.out.println("존재하지 않습니다.");
            }
        }
    }

    public void modifyPrice() {
        System.out.print("변경할 id >");
        Long id = sc.nextLong();
        boolean bookDTO = bookRepository.findById(id);
        if (bookDTO) {
            System.out.print("변경할 가격 > ");
            int bookPrice = sc.nextInt();
            bookRepository.modifyPrice(id, bookPrice);
            if (bookPrice != 0) {
                System.out.println("변경 성공");
            } else {
                System.out.println("변경 실패");
            }
        }
    }

    public void delete() {
        System.out.print("삭제할 도서 id > ");
        Long id = sc.nextLong();
        boolean bookDTO = bookRepository.delete(id);
        if (bookDTO) {
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }
    }

    public void search() {
        System.out.print("검색할 도서명 > ");
        String bookTitle = sc.next();
        List<BookDTO> bookDTOList = bookRepository.search(bookTitle);
        if (!bookDTOList.isEmpty()) {
            for (BookDTO bookDTO1 : bookDTOList) {
                System.out.println("bookDTO1 = " + bookDTO1);
            }
        } else {
            System.out.println("결과가 존재하지 않습니다.");
        }
    }
}

