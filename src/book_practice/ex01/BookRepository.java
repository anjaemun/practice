package book_practice.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRepository {
    private static List<BookDTO> bookDTOList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public boolean save(BookDTO bookDTO) {
        return bookDTOList.add(bookDTO);
    }


    public List<BookDTO> list() {
        return bookDTOList;
    }

    public boolean findById(Long id) {
        boolean result = false;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if (id.equals(bookDTOList.get(i).getId())) {
                System.out.println("bookDTOList = " + bookDTOList.get(i));
                result = true;
            }
        }
        return result;
    }

    public boolean findByTitle(String bookTitle) {
        boolean result = false;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if(bookTitle.equals(bookDTOList.get(i).getBookTitle())){
                System.out.println("bookDTOList = " + bookDTOList.get(i));
                result = true;
            }
        }
        return result;
    }
}
