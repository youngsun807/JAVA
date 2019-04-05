package book.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import book.model.dto.BookDTO;
import bookstore.controller.BookStoreController;

public class RunningStartView {

	public static void main(String[] args) {

		System.out.println("***** ȯ���մϴ�. *****");

		System.out.println("1. ����Ұ��� ������� ���̺� - 1 �Է�");
		System.out.println("2. ���Ⱑ���� ������� ���̺� - 2 �Է�");
		System.out.println("3. ���ο� ���� ���� �Է� - 3 �Է�");
		System.out.println("4. ������ ���� ���� ���� - 4 �Է�");
		System.out.println("5. ���� ���� ���� - 5 �Է�");

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
				BookStoreController.insertBook(new BookDTO(10020, "����", "������", "�迵��", 2018, "4��", 116, 0));
				break;
			case 4:
				BookStoreController.deleteBook(10007);// �̹�ȣ�� �����
				BookStoreController.getAlldeleteBooks();
				break;
			case 5:
				BookStoreController.updateBook(10002, "3��");
				break;
			default:
				System.out.println("�����մϴ�.");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("�߸��� �Է��Դϴ�. �ٽ� �����Ͽ� ó��ȭ������ ���ư�����.");
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
