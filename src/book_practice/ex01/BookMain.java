package book_practice.ex01;

import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("1.등록 2.목록 3.id로 조회 4.제목 조회 5.가격 수정 6.삭제 7.도서 검색 0.종료 ");
            System.out.println("-------------------------------------------------------------------");
            System.out.print("항목 입력 > ");
            int sel = sc.nextInt();
            if (sel == 1) {
                bookService.save();
            } else if (sel == 2) {
                bookService.list();
            } else if (sel == 3) {
                bookService.findById();
            } else if (sel == 4) {
                bookService.findByTitle();
            } else if (sel == 5) {
                bookService.modifyPrice();
            } else if (sel == 6) {
                bookService.delete();
            } else if (sel == 7) {
                bookService.search();
            } else {
                run = false;
            }


        }


    }
}
