package book_practice.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRepository {
    private static List<BookDTO> bookDTOList = new ArrayList<>();


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
            if (bookTitle.equals(bookDTOList.get(i).getBookTitle())) {
                System.out.println("bookDTOList = " + bookDTOList.get(i));
                result = true;
            }
        }
        return result;
    }

    public boolean modifyPrice(Long id, int bookPrice) {
        boolean result = false;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if (id.equals(bookDTOList.get(i).getId())) {
                bookDTOList.get(i).setBookPrice(bookPrice);
                result = true;
            }
        }
        return result;
    }

    public boolean delete(Long id) {
        boolean result = false;
        for (int i = 0; i < bookDTOList.size(); i++) {
            if (id.equals(bookDTOList.get(i).getId())) {
                bookDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }

    public List<BookDTO> search(String bookTitle) {
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(int i = 0; i < bookDTOList.size(); i++){
            if((bookDTOList.get(i).getBookTitle().contains(bookTitle))){
                BookDTO bookDTO = bookDTOList.get(i);
                bookDTOS.add(bookDTO);
            }
        }
        return bookDTOS;
    }
}
