package entities;

import java.util.Scanner;

public class Product {
	private int id;
	private String name;
	private double price;
	private int categoryId;
	private boolean status;
	
	public Product() {}
	
	

	public Product(int id, String name, double price, int categoryId, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nNhập id sản phẩm: ");
		id = Integer.parseInt(sc.nextLine());
		System.out.println("Nhập tên sản phẩm: ");
		name = sc.nextLine();
		System.out.println("Nhập giá sản phẩm: ");
		price = Double.parseDouble(sc.nextLine());
		System.out.println("Nhập id danh mục sản phẩm: ");
		categoryId = Integer.parseInt(sc.nextLine());
		System.out.println("Nhập trạng thái sản phẩm: ");
		status = Boolean.parseBoolean(sc.nextLine());
	}
	
	public void display() {
		System.out.println("Thông tin sản phẩm ");
		System.out.println("\t Id sản phẩm: "+id);
		System.out.println("\t Tên sản phẩm: "+name);
		System.out.println("\t Giá sản phẩm: "+price);
		System.out.println("\t Id danh mục sản phẩm sản phẩm: "+categoryId);
		System.out.println("\t Trạng thái sản phẩm: "+ (status == true ? "Hiện" : "Ẩn"));
	}
	
}
