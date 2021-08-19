package arraylist;

import java.util.Scanner;

public class MainArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagementArrayList productManagementArrayList = new ProductManagementArrayList();
        runMainProgram(scanner, productManagementArrayList);
    }

    private static void runMainProgram(Scanner scanner, ProductManagementArrayList productManagementArrayList) {
        int choice;
        do {
            menu();
            System.out.print("Mời bạn chọn : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    addProductInArrayList(scanner, productManagementArrayList);
                    break;
                }
                case 2: {
                    editProductInList(scanner, productManagementArrayList);
                    break;
                }
                case 3: {
                    deleteProductInList(scanner, productManagementArrayList);
                    break;
                }
                case 4: {
                    productManagementArrayList.displayProduct();
                    break;
                }
                case 5: {
                    findProductInList(scanner, productManagementArrayList);
                    break;
                }
                case 6: {
                    productManagementArrayList.sortProduct();
                    System.out.println("Đã sắp xếp");
                    break;
                }
                case 0: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Số không hợp lệ mời nhập lại!!!");
                }
            }

        } while (choice != 0);
    }

    private static void editProductInList(Scanner scanner, ProductManagementArrayList productManagementArrayList) {
        System.out.print("Nhập id sản phẩm muốn sửa : ");
        String idProduct = scanner.nextLine();
        int index = findIndexFromIdProduct(idProduct, productManagementArrayList);
        if (index != -1) {
            Product product = initProduct(scanner);
            productManagementArrayList.editProduct(index, product);
        } else {
            System.out.println("Không thấy id sản phẩm " + idProduct + " trong danh sách!");
        }
    }

    private static void deleteProductInList(Scanner scanner, ProductManagementArrayList productManagementArrayList) {
        System.out.print("Nhập id sản phẩm muốn xóa : ");
        String idProduct = scanner.nextLine();
        int index = findIndexFromIdProduct(idProduct, productManagementArrayList);
        if (index != -1) {
            productManagementArrayList.removeProduct(index);
        } else {
            System.out.println("Không thấy id sản phẩm " + idProduct + " trong danh sách!");
        }
    }

    private static void findProductInList(Scanner scanner, ProductManagementArrayList productManagementArrayList) {
        System.out.print("Hãy nhập tên sản phẩm : ");
        String nameProduct = scanner.nextLine();
        int index = findIndexFromName(nameProduct, productManagementArrayList);
        if (index != -1) {
            System.out.println("Đã tìm thấy : " + productManagementArrayList.findProduct(index).toString());
        } else {
            System.out.println("Không tìm thấy " + nameProduct + " trong danh sách");
        }
    }


    private static void addProductInArrayList(Scanner scanner, ProductManagementArrayList productManagementArrayList) {
        Product product = initProduct(scanner);
        productManagementArrayList.addProduct(product);
        System.out.println("Đã thêm sản phẩm thành công");
    }

    private static Product initProduct(Scanner scanner) {
        System.out.print("Tên sản phẩm : ");
        String name = scanner.nextLine();
        System.out.print("Id sản phẩm : ");
        String idProduct = scanner.nextLine();
        System.out.print("Giá sản phẩm : ");
        int price = scanner.nextInt();
        Product product = new Product(name, idProduct, price);
        return product;
    }

    private static int findIndexFromIdProduct(String idProduct, ProductManagementArrayList productManagementArrayList) {
        int index = -1;
        for (int i = 0; i < productManagementArrayList.getProducts().size(); i++) {
            if (idProduct.equals(productManagementArrayList.getProducts().get(i).getIdProduct())) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static int findIndexFromName(String name, ProductManagementArrayList productManagementArrayList) {
        int index = -1;
        for (int i = 0; i < productManagementArrayList.getProducts().size(); i++) {
            if (name.equals(productManagementArrayList.getProducts().get(i).getName())) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static void menu() {
        System.out.println("--------------------");
        System.out.println("MENU");
        System.out.println("1: Thêm sản phẩm");
        System.out.println("2: Sửa sản phẩm");
        System.out.println("3: Xóa sản phẩm");
        System.out.println("4: Hiển thị danh sách sản phẩm");
        System.out.println("5: Tìm kiếm sản phẩm");
        System.out.println("6: Sắp sếp sản phẩm");
        System.out.println("0: Thoát");
        System.out.println("--------------------");
    }
}
