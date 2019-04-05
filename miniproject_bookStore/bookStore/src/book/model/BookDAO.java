package book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import book.model.dto.BookDTO;
import book.model.util.DBUtil;

public class BookDAO {

	// �ű� ���� ���(insert)
	public static boolean addBook(BookDTO book) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into book values(?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, book.getNo());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getPublisher());
			pstmt.setInt(5, book.getYear());
			pstmt.setString(6, book.getLoc());
			pstmt.setInt(7, book.getCategory());
			pstmt.setInt(8, book.getStatus());
			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// ����
	// book no�� ��ġ �����ϱ�
	public static boolean updateBook(int bookNo, String loc) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update book set ��ġ=? where û����ȣ=?");
			pstmt.setString(1, loc);
			pstmt.setInt(2, bookNo);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// ����
	// book_no �� db���� �����ϱ�
	public static boolean deleteBook(int bookNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from book where û����ȣ=?");
			pstmt.setInt(1, bookNo);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// book_no�� Ư�� ������ ��� ���� ��ȯ
	public static BookDTO getBook(int bookNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BookDTO oneBook = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from book where û����ȣ=?");
			pstmt.setInt(1, bookNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				oneBook = new BookDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getString(6), rset.getInt(7), rset.getInt(8));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return oneBook;
	}

	// ��� ���� �˻��ؼ� ��ȯ
	public static ArrayList<BookDTO> getAllBooks() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookDTO> allBooks = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from book");
			rset = pstmt.executeQuery();

			allBooks = new ArrayList<BookDTO>();
			while (rset.next()) {
				allBooks.add(new BookDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getString(6), rset.getInt(7), rset.getInt(8)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return allBooks;
	}

	// ��� ���� �˻��ؼ� ��ȯ
	public static ArrayList<BookDTO> getAlldeleteBooks() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookDTO> allBooks = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from book_backup");
			rset = pstmt.executeQuery();

			allBooks = new ArrayList<BookDTO>();
			while (rset.next()) {
				allBooks.add(new BookDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5), rset.getString(6), rset.getInt(7), rset.getInt(8)));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return allBooks;
	}

	// book_status�� ������ ���� ��ȯ - 0�� 1�� ���� -����ó��
	public static ArrayList<BookDTO> getBookStatus(int bookStatus) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookDTO> canBooks = null;
		try {
			if (bookStatus == 0) {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from book where ������Ȳ=?");
				pstmt.setInt(1, bookStatus);
				rset = pstmt.executeQuery();

				canBooks = new ArrayList<BookDTO>();
				while (rset.next()) {
					canBooks.add(new BookDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
							rset.getInt(5), rset.getString(6), rset.getInt(7), rset.getInt(8)));
				}

			} else {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from book where ������Ȳ=?");
				pstmt.setInt(1, bookStatus);
				rset = pstmt.executeQuery();

				canBooks = new ArrayList<BookDTO>();
				while (rset.next()) {
					canBooks.add(new BookDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
							rset.getInt(5), rset.getString(6), rset.getInt(7), rset.getInt(8)));
				}
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return canBooks;
	}
}
