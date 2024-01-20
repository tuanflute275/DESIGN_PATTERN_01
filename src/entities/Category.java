package entities;

import java.util.Scanner;

public class Category {
	private int id;
	private String name;
	private boolean status;

	public Category() {
	}

	public Category(int id, String name, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nNhập id danh mục: ");
		id = Integer.parseInt(sc.nextLine());
		System.out.println("Nhập tên danh mục :");
		name = sc.nextLine();
		System.out.println("nhập trạng thái danh mục: ");
		status = Boolean.parseBoolean(sc.nextLine());
	}

	public void display() {
		System.out.println("Thông tin danh mục ");
		System.out.println("\t Id danh mục: "+id);
		System.out.println("\t Tên danh mục: "+name);
		System.out.println("\t Trạng thái danh mục: "+ (status == true ? "Hiện" : "Ẩn"));
	}

}
