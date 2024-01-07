package Project01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Order 클래스: 주문 정보를 담은 클래스
class Order implements Serializable {
 private static final long serialVersionUID = 1L;

 private Product product;
 private int quantity;

 // 생성자: 주문 정보 초기화
 public Order(Product product, int quantity) {
     this.product = product;
     this.quantity = quantity;
 }

 // 주문한 제품 반환
 public Product getProduct() {
     return product;
 }

 // 주문 수량 반환
 public int getQuantity() {
     return quantity;
 }

 // 주문 총액 계산
 public double calculateTotal() {
     return product.getPrice() * quantity;
 }

 // 객체 문자열 표현 반환 (디버깅용)
 @Override
 public String toString() {
     return "Order{" +
             "product=" + product +
             ", quantity=" + quantity +
             '}';
 }
}
