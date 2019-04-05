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
				RunningEndView.successMsg("��� ���� �˻��� �����Ͽ����ϴ�.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� ���� �˻��� ���� �߻�");
		}
	}

	public static void getAlldeleteBooks() {
		ArrayList<BookDTO> allBookList = null;
		try {
			allBookList = BookDAO.getAlldeleteBooks();
			if (allBookList.size() != 0) {
				RunningEndView.projectListView(allBookList);
			} else {
				RunningEndView.successMsg("���� ���� ��� �˻��� �����Ͽ����ϴ�.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("���� ���� ��� �˻��� ���� �߻�");
		}
	}

	public static void getAllBooksCanBorrow() {
		ArrayList<BookDTO> allBookCanBorrowList = null;
		try {
			allBookCanBorrowList = BookDAO.getBookStatus(1);
			if (allBookCanBorrowList.size() != 0) {
				RunningEndView.projectListView(allBookCanBorrowList);
			} else {
				RunningEndView.successMsg("��� ���� �˻��� �����Ͽ����ϴ�.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� ���� �˻��� ���� �߻�");
		}
	}

	public static void getAllBooksNoCanBorrow() {
		ArrayList<BookDTO> allBookNoCanBorrowList = null;
		try {
			allBookNoCanBorrowList = BookDAO.getBookStatus(0);
			if (allBookNoCanBorrowList.size() != 0) {
				RunningEndView.projectListView(allBookNoCanBorrowList);
			} else {
				RunningEndView.successMsg("��� ���� �˻��� �����Ͽ����ϴ�.");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� ���� �˻��� ���� �߻�");
		}
	}

	public static void insertBook(BookDTO bookDto) {
		boolean result;
		try {
			result = BookDAO.addBook(bookDto);
			if (result != false) {
				RunningEndView.successMsg("�Է¿� �����߽��ϴ�.");
			} else {
				RunningEndView.successMsg("�Է¿� �����Ͽ����ϴ�.");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			RunningEndView.showError("�Է½� ���� �߻�");
		}
	}

	public static void deleteBook(int i) {
		boolean result;
		try {
			result = BookDAO.deleteBook(i);
			if (result != false) {
				RunningEndView.successMsg("���������� �����Ǿ����ϴ�.");
			} else {
				RunningEndView.successMsg("������ �����Ͽ����ϴ�.");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			RunningEndView.showError("������ ���� �߻�");
		}
	}

	public static void updateBook(int i, String s) {
		boolean result;
		try {
			result = BookDAO.updateBook(i, s);
			if (result != false) {
				RunningEndView.successMsg("���������� ����Ǿ����ϴ�.");
			} else {
				RunningEndView.successMsg("���濡 �����Ͽ����ϴ�.");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			RunningEndView.showError("����� ���� �߻�");
		}
	}
}
