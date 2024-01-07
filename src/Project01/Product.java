package Project01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Product 클래스: 제품 정보를 담은 클래스
class Product implements Serializable {
 private static final long serialVersionUID = 1L;

 private String name;
 private double price;
 private int stock;

 // 생성자: 제품 정보 초기화
 public Product(String name, double price, int stock) {
     this.name = name;
     this.price = price;
     this.stock = stock;
 }

 // 제품 이름 반환
 public String getName() {
     return name;
 }

 // 제품 가격 반환
 public double getPrice() {
     return price;
 }

 // 제품 재고 반환
 public int getStock() {
     return stock;
 }

 // 제품 판매 처리
 public void sell(int quantity) {
     if (quantity > 0 && quantity <= stock) {
         stock -= quantity;
     } else {
         System.out.println("재고 부족 또는 잘못된 수량입니다.");
     }
 }

 // 객체 문자열 표현 반환 (디버깅용)
 @Override
 public String toString() {
     return "Product{" +
             "name='" + name + '\'' +
             ", price=" + price +
             ", stock=" + stock +
             '}';
 }
}

