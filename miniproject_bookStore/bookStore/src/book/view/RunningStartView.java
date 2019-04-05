package book.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import book.model.dto.BookDTO;
import bookstore.controller.BookStoreController;

public class RunningStartView {

	public static void main(String[] args) {

		System.out.println("***** 환영합니다. *****");

		System.out.println("1. 대출불가한 도서목록 테이블 - 1 입력");
		System.out.println("2. 대출가능한 도서목록 테이블 - 2 입력");
		System.out.println("3. 새로운 도서 정보 입력 - 3 입력");
		System.out.println("4. 기존의 도서 정보 삭제 - 4 입력");
		System.out.println("5. 도서 정보 수정 - 5 입력");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int printFirst;
		try {
			printFirst = Integer.parseInt(in.readLine());

			switch (printFirst) {
			case 1:
				BookStoreController.getAllBooksNoCanBorrow();
				break;
			case 2:
				BookStoreController.getAllBooksCanBorrow();
				break;
			case 3:
				BookStoreController.insertBook(new BookDTO(10020, "토지", "진민재", "김영선", 2018, "4층", 116, 0));
				break;
			case 4:
				BookStoreController.deleteBook(10007);// 이번호만 실행됨
				BookStoreController.getAlldeleteBooks();
				break;
			case 5:
				BookStoreController.updateBook(10002, "3층");
				break;
			default:
				System.out.println("종료합니다.");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("잘못된 입력입니다. 다시 실행하여 처음화면으로 돌아가세요.");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
