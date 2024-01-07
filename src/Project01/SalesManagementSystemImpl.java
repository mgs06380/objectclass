package Project01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
//SalesManagementSystemImpl 클래스: 판매 관리 시스템 구현
class SalesManagementSystemImpl implements SalesManagementSystem {
 private List<Product> products;
 private List<Order> orders;

 // 생성자: 시스템 초기화
 public SalesManagementSystemImpl() {
     this.products = new ArrayList<>(); //컬렉션 프레임워크의 ArrayList를 사용해 리스트를 동적으로 관리.
     this.orders = new ArrayList<>();
 }

 // 제품 추가
 @Override
 public void addProduct(Product product) {
     products.add(product);
 }

 // 제품 목록 조회
 @Override
 public List<Product> getProducts() {
     return products;
 }

 // 주문 추가
 @Override
 public void addOrder(Order order) {
     orders.add(order);
     order.getProduct().sell(order.getQuantity());
 }

 
 // 주문 목록 조회
 @Override
 public List<Order> getOrders() {
     return orders;
 }

 // 총 매출 계산
 @Override
 public double calculateTotalSales() {
     double totalSales = 0;
     for (Order order : orders) {
         totalSales += order.calculateTotal();
     }
     return totalSales;
 }

 // 제품 정보 파일에 저장
 @Override
 public void saveProductsToFile(String filename) {
     try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
         oos.writeObject(products);
     } catch (IOException e) {
         e.printStackTrace();
     }
 }

 // 제품 정보 파일에서 로드
 @Override
 public void loadProductsFromFile(String filename) {
     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
         products = (List<Product>) ois.readObject();
     } catch (IOException | ClassNotFoundException e) {
         e.printStackTrace();
     }
 }
}