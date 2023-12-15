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
        for(int i = 0; i < bookDTOList1.size(); i++){
            System.out.println(bookDTOList1.get(i));
        }

    }

}
