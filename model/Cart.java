package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // ✅속성
    private final List<MenuItem> cartItems; // 상세메뉴 리스트
    private double totalPrice = 0; // 총 함계금액

    // ✅생성자
    public Cart(){
        this.cartItems = new ArrayList<>(); // 빈 배열로 초기화
    }

    /**
     * ✅선택된 상세메뉴, 장바구니 추가 메서드
     * @param item 선택된 상세메뉴
     */
    public void add(MenuItem item){
        cartItems.add(item);
        totalPrice += item.getPrice();
    }

    /**
     * ✅장바구니 비우기 메서드
     */
    public void clear(){
        cartItems.clear();
        totalPrice = 0;
    }

    /**
     * ✅장바구니에 담긴 상세메뉴 리스트 반환 메서드
     * @return 상세메뉴 리스트
     */
    public List<MenuItem> getCartItems() {
        return cartItems;
    }

    /**
     * ✅장바구니 총 합계금액 반환 메서드
     * @return 총 합계금액
     */
    public double getTotalPrice() {
        return totalPrice;
    }
}
