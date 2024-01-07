package Project01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//SalesManagementSystem 인터페이스: 판매 관리 시스템의 기능 정의
interface SalesManagementSystem {
 // 제품 추가
 void addProduct(Product product);

 // 제품 목록 조회
 List<Product> getProducts();

 // 주문 추가
 void addOrder(Order order);

 // 주문 목록 조회
 List<Order> getOrders();

 // 총 매출 계산
 double calculateTotalSales();

 // 제품 정보 파일에 저장
 void saveProductsToFile(String filename);

 // 제품 정보 파일에서 로드
 void loadProductsFromFile(String filename);
}