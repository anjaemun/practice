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
}
