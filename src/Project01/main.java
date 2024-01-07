package Project01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	 public static void main(String[] args) {
		 SalesManagementSystem system = new SalesManagementSystemImpl();
	        Scanner scanner = new Scanner(System.in);

	        // 초기 상품 등록
	        Product laptop = new Product("Laptop", 1200.0, 10);
	        Product smartphone = new Product("Smartphone", 800.0, 20);

	        system.addProduct(laptop);
	        system.addProduct(smartphone);

	        int choice;
	        do {
	            // 메뉴 출력
	            System.out.println("1. 상품등록");
	            System.out.println("2. 상품 리스트");
	            System.out.println("3. 주문하기");
	            System.out.println("4. 주문 리스트");
	            System.out.println("5. 총 판매 계산");
	            System.out.println("6. 등록된 상픔 파일에 저장");
	            System.out.println("7. 등록된 상품파일 불러오기");
	            System.out.println("8. 불러온 상품목록 출력");
	            System.out.println("0. 종료");
	            System.out.print("원하는 작업 번호를 입력하세요: ");

	            // 사용자 입력 처리
	            choice = scanner.nextInt();
	            scanner.nextLine(); // 개행 문자 처리

	            // 기능 실행
	            switch (choice) {
	                case 1:
	                    addProduct(system, scanner);
	                    break;
	                case 2:
	                    listProducts(system);
	                    break;
	                case 3:
	                    addOrder(system, scanner);
	                    break;
	                case 4:
	                    listOrders(system);
	                    break;
	                case 5:
	                    calculateTotalSales(system);
	                    break;
	                case 6:
	                    saveProductsToFile(system, scanner);
	                    break;
	                case 7:
	                    loadProductsFromFile(system, scanner);
	                    break;
	                case 8:
	                    listLoadedProducts(system);
	                    break;
	                case 0:
	                    System.out.println("Exiting the program. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	        } while (choice != 0);

	        // 프로그램 종료 시 리소스 정리
	        scanner.close();
	    }

	    // 상품 추가 메서드
	    private static void addProduct(SalesManagementSystem system, Scanner scanner) {
	        System.out.print("Enter product name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter product price: ");
	        double price = scanner.nextDouble();
	        System.out.print("Enter product stock: ");
	        int stock = scanner.nextInt();

	        Product newProduct = new Product(name, price, stock);
	        system.addProduct(newProduct);
	        System.out.println("Product added: " + newProduct);
	    }

	    // 상품 목록 조회 메서드
	    private static void listProducts(SalesManagementSystem system) {
	        List<Product> products = system.getProducts();
	        System.out.println("Product List:");
	        for (Product product : products) {
	            System.out.println(product);
	        }
	    }

	    // 주문 추가 메서드
	    private static void addOrder(SalesManagementSystem system, Scanner scanner) {
	        listProducts(system);
	        System.out.print("Enter product index to order: ");
	        int productIndex = scanner.nextInt();
	        System.out.print("Enter order quantity: ");
	        int quantity = scanner.nextInt();

	        Product selectedProduct = system.getProducts().get(productIndex);
	        Order newOrder = new Order(selectedProduct, quantity);
	        system.addOrder(newOrder);
	        System.out.println("Order added: " + newOrder);
	    }

	    // 주문 목록 조회 메서드
	    private static void listOrders(SalesManagementSystem system) {
	        List<Order> orders = system.getOrders();
	        System.out.println("Order List:");
	        for (Order order : orders) {
	            System.out.println(order);
	        }
	    }

	    // 총 매출 계산 메서드
	    private static void calculateTotalSales(SalesManagementSystem system) {
	        double totalSales = system.calculateTotalSales();
	        System.out.println("Total Sales: $" + totalSales);
	    }

	    // 상품 정보 파일에 저장 메서드
	    private static void saveProductsToFile(SalesManagementSystem system, Scanner scanner) {
	        System.out.print("Enter file name to save products: ");
	        String fileName = scanner.nextLine();
	        system.saveProductsToFile(fileName);
	        System.out.println("Product information saved to file: " + fileName);
	    }

	    // 파일에서 상품 정보 로드 메서드
	    private static void loadProductsFromFile(SalesManagementSystem system, Scanner scanner) {
	        System.out.print("Enter file name to load products: ");
	        String fileName = scanner.nextLine();
	        system.loadProductsFromFile(fileName);
	        System.out.println("Product information loaded from file: " + fileName);
	    }

	    // 로드된 상품 목록 조회 메서드
	    private static void listLoadedProducts(SalesManagementSystem system) {
	        List<Product> loadedProducts = system.getProducts();
	        System.out.println("Loaded Products:");
	        for (Product p : loadedProducts) {
	            System.out.println(p);
	        }
	    }
	}
