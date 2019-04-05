package book.model.dto;

public class People {

	int no;
	String name;
	String email;
	String phoneNo;

	public People() {
	}

	public People(int no, String name, String email, String phoneNo) {
		this.no = no;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. ���� ������ id : ");
		builder.append(no);
		builder.append(" 2. �̸� : ");
		builder.append(name);
		builder.append(" 3. �̸��� �ּ� : ");
		builder.append(email);
		builder.append(" 4. ��ȭ��ȣ : ");
		builder.append(phoneNo);
		return builder.toString();
	}
}
