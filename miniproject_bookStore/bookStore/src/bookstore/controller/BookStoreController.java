package bookstore.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import book.model.BookDAO;
import book.model.dto.BookDTO;
import book.view.RunningEndView;

public class BookStoreController {
	public static void getAllBooks() {
		ArrayList<BookDTO> allBookList = null;
		try {
			allBookList = BookDAO.getAllBooks();
			if (allBookList.size() != 0) {
				RunningEndView.projectListView(allBookList);
			} else {
				RunningEndView.successMsg("모든 도서 검색에 실패하였습니다.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("모든 도서 검색시 에러 발생");
		}
	}

	public static void getAlldeleteBooks() {
		ArrayList<BookDTO> allBookList = null;
		try {
			allBookList = BookDAO.getAlldeleteBooks();
			if (allBookList.size() != 0) {
				RunningEndView.projectListView(allBookList);
			} else {
				RunningEndView.successMsg("삭제 도서 목록 검색에 실패하였습니다.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("삭제 도서 목록 검색시 에러 발생");
		}
	}

	public static void getAllBooksCanBorrow() {
		ArrayList<BookDTO> allBookCanBorrowList = null;
		try {
			allBookCanBorrowList = BookDAO.getBookStatus(1);
			if (allBookCanBorrowList.size() != 0) {
				RunningEndView.projectListView(allBookCanBorrowList);
			} else {
				RunningEndView.successMsg("모든 도서 검색에 실패하였습니다.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("모든 도서 검색시 에러 발생");
		}
	}

	public static void getAllBooksNoCanBorrow() {
		ArrayList<BookDTO> allBookNoCanBorrowList = null;
		try {
			allBookNoCanBorrowList = BookDAO.getBookStatus(0);
			if (allBookNoCanBorrowList.size() != 0) {
				RunningEndView.projectListView(allBookNoCanBorrowList);
			} else {
				RunningEndView.successMsg("모든 도서 검색에 실패하였습니다.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("모든 도서 검색시 에러 발생");
		}
	}

	public static void insertBook(BookDTO bookDto) {
		boolean result;
		try {
			result = BookDAO.addBook(bookDto);
			if (result != false) {
				RunningEndView.successMsg("입력에 성공했습니다.");
			} else {
				RunningEndView.successMsg("입력에 실패하였습니다.");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			RunningEndView.showError("입력시 오류 발생");
		}
	}

	public static void deleteBook(int i) {
		boolean result;
		try {
			result = BookDAO.deleteBook(i);
			if (result != false) {
				RunningEndView.successMsg("정상적으로 삭제되었습니다.");
			} else {
				RunningEndView.successMsg("삭제에 실패하였습니다.");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			RunningEndView.showError("삭제시 오류 발생");
		}
	}

	public static void updateBook(int i, String s) {
		boolean result;
		try {
			result = BookDAO.updateBook(i, s);
			if (result != false) {
				RunningEndView.successMsg("정상적으로 변경되었습니다.");
			} else {
				RunningEndView.successMsg("변경에 실패하였습니다.");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			RunningEndView.showError("변경시 오류 발생");
		}
	}
}
