package io.output;

import model.Cart;
import model.Menu;
import model.MenuItem;

import java.util.List;

// FIXME: 상단 출력메서드 3개 및 전체적 수정 필요
public class OutputPrinter {
    // ✅프로그램 종료 포함 입력창 프롬프트 출력 메서드
    public void printInputPromptWithExit(){
        System.out.print("➡️선택창 (프로그램 종료: 0): ");
    }

    // ✅뒤로가기 포함 입력창 프롬프트 출력 메서드
    public void printInputPromptWithBack(){
        System.out.print("➡️선택창 (뒤로가기: 0): ");
    }

    // ✅기본 입력창 프롬프트 출력 메서드
    public void printInputPrompt(){
        System.out.print("➡️선택창: ");
    }

    /**
     * ✅메인메뉴 출력 메서드
     * @param menus Menu 객체 리스트
     */
    public void printMainMenuList(List<Menu> menus){
        System.out.println("[ SPARTA MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        System.out.println();
    }

    public void printOrderMenu(int startNumber){
        System.out.println("[ ORDER MENU ]");
        System.out.println(startNumber + ". Orders  | 장바구니를 확인 후 주문합니다.");
        System.out.println((startNumber + 1) + ". Cancel  | 진행중인 주문을 취소합니다.");
        System.out.println();
    }

    /**
     * ✅선택된 메뉴 출력 메서드
     * @param menuItems 상세메뉴 리스트
     * @param category 메뉴 카테고리
     */
    public void printSelectedMenu(List<MenuItem> menuItems, String category){
        System.out.println("\n[ " + category + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).getFormattedString());
        }
    }

    /**
     * ✅선택된 상세메뉴 및 추가여부 출력 메서드
     * @param menuItemInfo 상세메뉴 정보
     */
    public void printSelectedMenuItem(String menuItemInfo){
        System.out.println("\n📌 선택된 메뉴는 아래와 같습니다.");
        System.out.println("\u001B[33m" + menuItemInfo + "\u001B[0m");

        // 선택된 메뉴를 장바구니에 추가 여부 메시지
        System.out.println("위 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인   2. 취소");
    }

    /**
     * ✅장바구니 추가 성공 출력 메서드
     * @param menuItem 장바구니에 추가할 상세메뉴
     */
    public void printSuccessAddCart(MenuItem menuItem){
        System.out.print("\n\u001B[34m\u001B[1m" + menuItem.getName() + "\u001B[0m");
        System.out.println(" 이/가 장바구니에 추가되었습니다.\n");
    }


    public void printOrderCartPrompt(Cart cart){
        System.out.println("아래와 같이 주문하시겠습니까?");

        // 장바구니에 담겨 있는 메뉴
        System.out.println("\n[ Orders ]");
        for(MenuItem menuItem: cart.getCartItems()){
            System.out.println("\u001B[33m" + menuItem.getFormattedString() + "\u001B[0m");
        }

        // 장바구니 총 합계 금액
        // FIXME: totalPrice 설정 필요
        System.out.println("\n[ Total ]");
        System.out.println("W " + cart.getTotalPrice());

        // 장바구니 결제 여부 메시지
        System.out.println("1. 주문   2. 메뉴판");
        printInputPrompt();
    }

    public void printOrderCancelPrompt(){
        System.out.println("장바구니를 비우시겠습니까?");
        System.out.println("1. 비우기   2. 처음으로");
        printInputPrompt();
    }

    public void printSuccessCartClear(){
        System.out.println("장바구니를 비웠습니다.\n");;
    }

    // FIXME: totalPrice 설정 필요
    public void printSuccessOrderPrompt(double totalPrice){
        System.out.println("\u001B[31m주문이 완료되었습니다. 금액은 W " + totalPrice + "입니다.\u001B[0m\n");
    }

    // ✅취소 메시지 출력 메서드
    public void printCancelPrompt(){
        System.out.println("취소되었습니다.");
        System.out.println();
    }

    // ✅프로그램 재시작 메시지 출력 메서드
    public void printInvalidPrompt(){
        System.out.println("\n✋🏻잘못된 접근입니다.");
        System.out.println();
    }

    // ✅프로그램 종료 메시지 출력 메서드
    public void printExitPrompt() {
        System.out.println("\n🚀 프로그램을 종료합니다.");
    }
}
