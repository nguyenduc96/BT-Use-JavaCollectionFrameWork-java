package linkedlist;

import java.util.Scanner;

public class MainLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagementLinkedList productManagementLinkedList = new ProductManagementLinkedList();
        runMainProgram(scanner, productManagementLinkedList);
    }

    private static void runMainProgram(Scanner scanner, ProductManagementLinkedList productManagementLinkedList) {
        int choice;
        do {
            menu();
            System.out.print("Mời bạn chọn : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    addProductInLinkedList(scanner, productManagementLinkedList);
                    break;
                }
                case 2: {
                    editProductInList(scanner, productManagementLinkedList);
                    break;
                }
                case 3: {
                    deleteProductInList(scanner, productManagementLinkedList);
                    break;
                }
                case 4: {
                    productManagementLinkedList.displayProduct();
                    break;
                }
                case 5: {
                    findProductInList(scanner, productManagementLinkedList);
                    break;
                }
                case 6: {
                    productManagementLinkedList.sortProduct();
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

    private static void addProductInLinkedList(Scanner scanner, ProductManagementLinkedList productManagementLinkedList) {
        subMenu();
        int choiceSub = scanner.nextInt();
        scanner.nextLine();
        switch (choiceSub) {
            case 1: {
                addProductInFirstLinkedList(scanner, productManagementLinkedList);
                break;
            }
            case 2: {
                addProductInLastLinkedList(scanner, productManagementLinkedList);
                break;
            }
            case 0: {
                break;
            }
        }
    }

    private static void subMenu() {
        System.out.println("-------------------");
        System.out.println("THÊM SẢN PHẨM");
        System.out.println("1: Thêm vào đầu");
        System.out.println("2: Thêm vào cuối");
        System.out.println("0: Quay lại");
        System.out.println("-------------------");
        System.out.println("Mời bạn chọn : ");
    }

    private static void editProductInList(Scanner scanner, ProductManagementLinkedList productManagementLinkedList) {
        System.out.print("Nhập id sản phẩm muốn sửa : ");
        String idProduct = scanner.nextLine();
        int index = findIndexFromIdProduct(idProduct, productManagementLinkedList);
        if (index != -1) {
            Product product = new Product();
            productManagementLinkedList.editProduct(index, product);
        } else {
            System.out.println("Không thấy id sản phẩm " + idProduct + " trong danh sách!");
        }
    }

    private static void deleteProductInList(Scanner scanner, ProductManagementLinkedList productManagementLinkedList) {
        System.out.print("Nhập id sản phẩm muốn xóa : ");
        String idProduct = scanner.nextLine();
        int index = findIndexFromIdProduct(idProduct, productManagementLinkedList);
        if (index != -1) {
            productManagementLinkedList.deleteProduct(index);
        } else {
            System.out.println("Không thấy id sản phẩm " + idProduct + " trong danh sách!");
        }
    }

    private static void findProductInList(Scanner scanner, ProductManagementLinkedList productManagementLinkedList) {
        System.out.print("Hãy nhập tên sản phẩm : ");
        String nameProduct = scanner.nextLine();
        int index = findIndexFromName(nameProduct, productManagementLinkedList);
        if (index != -1) {
            System.out.println("Đã tìm thấy : " + productManagementLinkedList.findProduct(index).toString());
        } else {
            System.out.println("Không tìm thấy " + nameProduct + " trong danh sách");
        }
    }


    private static void addProductInLastLinkedList(Scanner scanner, ProductManagementLinkedList productManagementLinkedList) {
        Product product = initProduct(scanner);
        productManagementLinkedList.addLast(product);
        System.out.println("Đã thêm sản phẩm thành công");
    }

    private static void addProductInFirstLinkedList(Scanner scanner, ProductManagementLinkedList productManagementLinkedList) {
        Product product = initProduct(scanner);
        productManagementLinkedList.addFirst(product);
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

    private static int findIndexFromIdProduct(String idProduct, ProductManagementLinkedList productManagementLinkedList) {
        int index = -1;
        for (int i = 0; i < productManagementLinkedList.getProducts().size(); i++) {
            if (idProduct.equals(productManagementLinkedList.getProducts().get(i).getIdProduct())) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static int findIndexFromName(String name, ProductManagementLinkedList productManagementLinkedList) {
        int index = -1;
        for (int i = 0; i < productManagementLinkedList.getProducts().size(); i++) {
            if (name.equals(productManagementLinkedList.getProducts().get(i).getName())) {
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
