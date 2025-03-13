package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // ✅속성
    private final List<MenuItem> cartItems; // 상세메뉴 리스트
    private double totalPrice = 0; // 총 합계금액

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
        setTotalPrice(this.getTotalPrice() + item.getPrice());
    }

    /**
     * ✅장바구니에 들어 있는 상세메뉴 단일 삭제 메서드
     * @param deleteItemMenuName 삭제할 상세메뉴 이름
     */
    public boolean deleteMenuItem(String deleteItemMenuName){
        return cartItems.stream()
                // 대소문자 구분하지 않고, 이름이 같은지 확인
                .filter(menuItem -> menuItem.getName().equalsIgnoreCase(deleteItemMenuName))

                // 첫번째로 일치하는 항목 선택
                .findFirst()

                // 존재하면 삭제 후, true 반환
                .map(menuItem -> {
                    cartItems.remove(menuItem);
                    setTotalPrice(this.getTotalPrice() - menuItem.getPrice());
                    return true;
                })

                // 존재하지 않을 경우, false 반환
                .orElse(false);
    }

    /**
     * ✅장바구니 전체 비우기 메서드
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
     * ✅장바구니의 총 합계금액을 설정하는 메서드
     * @param price 변경된 총 합계금액
     */
    public void setTotalPrice(double price){
        totalPrice = price;
    }

    /**
     * ✅장바구니의 총 합계금액 반환 메서드
     * @return 총 합계금액
     */
    public double getTotalPrice() {
        return totalPrice;
    }
}
