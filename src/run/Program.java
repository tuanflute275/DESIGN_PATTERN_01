package run;

import java.util.List;
import java.util.Scanner;

import dao.impl.CategoryDAOImpl;
import dao.impl.ProductDAOImpl;
import entities.Category;
import entities.Product;

public class Program {
	public static void category() {
		Scanner sc = new Scanner(System.in);
		Category category = new Category();
		int choice_category = 5;
		do {
			System.out.println("\n======Quản lý danh mục======");
			System.out.println("1. Hiển thị d/s danh mục sắp xếp theo tên A-Z");
			System.out.println("2. Thêm mới danh mục");
			System.out.println("3. Cập nhật danh mục");
			System.out.println("4. Xóa danh mục");
			System.out.println("5. Quay lại");
			choice_category = sc.nextInt();
			sc.nextLine();
			switch (choice_category) {
			case 1:
				List<Category> list = CategoryDAOImpl.getInstance().get();
				if (list.size() == 0) {
					System.out.println("WARNING  ===> KHÔNG CÓ DỮ LIỆU.");
				} else {
					System.out.println("======>DANH SÁCH DANH MỤC<=======\n ");
					for (Category cate : list) {
						cate.display();
					}
				}
				break;
			case 2:
				category.input();
				boolean checkInsert = CategoryDAOImpl.getInstance().add(category);
				if (checkInsert) {
					System.out.println("\nSUCCESS ===> Thêm mới danh mục thành công.");
				} else {
					System.out.println("\nERROR ===> Thêm mới danh mục thất bại.");
				}
				break;
			case 3:
				System.out.print("Nhập ID cần cập nhật: ");
				Integer idUpdate = sc.nextInt();
				Category dataByIdUpdate = CategoryDAOImpl.getInstance().findId(idUpdate);
				if (dataByIdUpdate == null) {
					System.out.println("Không có danh mục nào với Id là: " + idUpdate);
				} else {
					dataByIdUpdate.display();
					category.input();
					boolean checkUpdate = CategoryDAOImpl.getInstance().edit(category);
					if (checkUpdate) {
						System.out.println("\nSUCCESS ===>Cập nhật danh mục thành công.");
					} else {
						System.out.println("\nERROR ===>Cập nhật danh mục thất bại.");
						System.out.println("\nERROR ===>Không có danh mục với ID là: " + idUpdate);
					}
				}
				break;
			case 4:
				System.out.print("Nhập thông tin cần xóa: \n");
				category.input();
				boolean checkDelete = CategoryDAOImpl.getInstance().remove(category);
				if (checkDelete) {
					System.out.println("\nSUCCESS ===>Xóa danh mục thành công.");
				} else {
					System.out.println("\nERROR ===>Xóa danh mục thất bại.");
				}
				break;
			case 5:
				menu();
				break;

			default:
				System.out.println("Yêu cầu không phù hợp , vui lòng nhập từ 1 - 5 !!!");
				break;
			}
		} while (choice_category != 5);

	}

	public static void product() {
		Scanner sc = new Scanner(System.in);
		Product product = new Product();
		int choice_product = 5;
		do {
			System.out.println("\n======Quản lý sản phẩm======");
			System.out.println("1. Hiển thị d/s sản phẩm");
			System.out.println("2. Thêm mới sản phẩm");
			System.out.println("3. Cập nhật thông tin sản phẩm");
			System.out.println("4. Xóa sản phẩm");
			System.out.println("5. Quay lại");
			choice_product = sc.nextInt();
			sc.nextLine();
			switch (choice_product) {
			case 1:
				List<Product> list = ProductDAOImpl.getInstance().get();
				if (list.size() == 0) {
					System.out.println("WARNING  ===> KHÔNG CÓ DỮ LIỆU.");
				} else {
					System.out.println("======>DANH SÁCH SẢN PHẨM<=======\n ");
					for (Product pro : list) {
						pro.display();
					}
				}
				break;
			case 2:
				product.input();
				boolean checkInsert = ProductDAOImpl.getInstance().add(product);
				if (checkInsert) {
					System.out.println("\nSUCCESS ===> Thêm mới sản phẩm thành công.");
				} else {
					System.out.println("\nERROR ===> Thêm mới sản phẩm thất bại.");
				}
				break;
			case 3:
				System.out.print("Nhập ID cần cập nhật: ");
				Integer idUpdate = sc.nextInt();
				Product dataByIdUpdate = ProductDAOImpl.getInstance().findId(idUpdate);
				if (dataByIdUpdate == null) {
					System.out.println("Không có sản phẩm nào với Id là: " + idUpdate);
				} else {
					dataByIdUpdate.display();
					product.input();
					boolean checkUpdate = ProductDAOImpl.getInstance().edit(product);
					if (checkUpdate) {
						System.out.println("\nSUCCESS ===>Cập nhật sản phẩm thành công.");
					} else {
						System.out.println("\nERROR ===>Cập nhật sản phẩm thất bại.");
						System.out.println("\nERROR ===>Không có sản phẩm với ID là: " + idUpdate);
					}
				}
				break;
			case 4:
				System.out.print("Nhập thông tin cần xóa: \n");
				product.input();
				boolean checkDelete = ProductDAOImpl.getInstance().remove(product);
				if (checkDelete) {
					System.out.println("\nSUCCESS ===>Xóa sản phẩm thành công.");
				} else {
					System.out.println("\nERROR ===>Xóa sản phẩm thất bại.");
				}
				break;
			case 5:
				menu();
				break;

			default:
				System.out.println("Yêu cầu không phù hợp , vui lòng nhập từ 1 - 5 !!!");
				break;
			}
		} while (choice_product != 5);

	}

	public static void menu() {
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n======MENU CHỨC NĂNG======");
		System.out.println("1. Quản lí danh mục ");
		System.out.println("2. Quản lí sản phẩm");
		System.out.println("3.Thoát");
		choice = Integer.parseInt(sc.nextLine());
		if (choice == 1) {
			category();
		} else if (choice == 2) {
			product();
		} else if (choice == 3) {
			System.out.println("Thank you");
		} else {
			System.out.println("Yêu cầu không phù hợp , vui lòng nhập từ 1 - 3 !!!");
		}
	}

	public static void main(String[] args) {
		menu();
	}
}
