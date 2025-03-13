package io.output;

import model.Cart;
import model.Menu;
import model.MenuItem;

import java.util.List;

public class OutputPrinter {
    /**
     * String 연산을 효율/효과적으로 처리하기 위해 StringBuilder 사용
     * 전역에 선언하여 불필요한 객체 생성 방지 및 성능 최적화
     * 각 메서드에서 setLength(0)로 초기화하여 이전 데이터 제거
     */
    StringBuilder stringBuilder = new StringBuilder();

    /**
     * ✅[공통] 입력창 프롬프트 출력 메서드
     * @param promptType 입력창 프롬프트 기능 설정 (Enum InputPrompt)
     */
    public void printInputPrompt(InputPrompt promptType) {
        stringBuilder.setLength(0); // StringBuilder 초기화
        stringBuilder.
                append("\n➡️ 선택창")
                .append(promptType.getMessage().isEmpty()
                        ? ""
                        : " (" + promptType.getMessage() + ")")
                .append(": ");
        System.out.print(stringBuilder);
    }

    /**
     * ✅[공통] 색상을 적용하여 텍스트를 출력하는 메서드
     * @param textColor 적용할 색상 (Enum TextColor)
     * @param text 출력할 텍스트
     */
    public void printColorPrompt(TextColor textColor, String text){
        System.out.print(textColor.apply(text));
    }

    /**
     * ✅메인메뉴 출력 메서드
     * @param menus Menu 객체 리스트
     */
    public void printSpartaMenuList(List<Menu> menus){
        printColorPrompt(TextColor.BLUE, "[ SPARTA MENU ]\n");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
    }

    /**
     * ✅장바구니 기능 출력 메서드
     * @param startNumber 시작 번호
     */
    public void printOrderMenu(int startNumber){
        printColorPrompt(TextColor.BLUE, "\n[ ORDER MENU]\n");
        System.out.println(startNumber + ". Orders  | 장바구니를 확인 후 주문합니다.");
        System.out.println((startNumber + 1) + ". Cancel  | 진행중인 주문을 취소합니다.\n");
    }

    /**
     * ✅선택된 메뉴 출력 메서드
     * @param menuItems 상세메뉴 리스트
     * @param category 메뉴 카테고리
     */
    public void printSelectedMenu(List<MenuItem> menuItems, String category){
        printColorPrompt(TextColor.YELLOW, "\n[ " + category + "MENU ]\n");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).getFormattedString());
        }

        // 뒤로가기 기능 포함 입력창 출력
        printInputPrompt(InputPrompt.BACK);
    }

    /**
     * ✅선택된 상세메뉴 및 추가여부 출력 메서드
     * @param menuItemInfo 상세메뉴 정보
     */
    public void printSelectedMenuItem(String menuItemInfo){
        System.out.println("\n📌 선택된 메뉴는 아래와 같습니다.");
        printColorPrompt(TextColor.YELLOW, menuItemInfo + "\n");

        // 선택된 메뉴를 장바구니에 추가 여부 메시지
        System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인   2. 취소");

        // 기본 입력창 출력
        printInputPrompt(InputPrompt.DEFAULT);
    }

    /**
     * ✅장바구니 추가 성공 출력 메서드
     * @param menuItem 장바구니에 추가할 상세메뉴
     */
    public void printSuccessAddCartPrompt(MenuItem menuItem){
        printColorPrompt(TextColor.GREEN, menuItem.getName());
        System.out.println(" 이/가 장바구니에 추가되었습니다.\n");
    }

    /**
     * ✅장바구니에 담겨있는 정보를 출력하는 메서드
     * @param cart 장바구니
     */
    public void printOrderCartPrompt(Cart cart){
        System.out.println("아래와 같이 주문하시겠습니까?");

        // 장바구니에 담겨 있는 메뉴 출력
        System.out.println("\n[ Orders ]");
        for(MenuItem menuItem: cart.getCartItems()){
            printColorPrompt(TextColor.YELLOW, menuItem.getFormattedString() + "\n");
        }

        // 장바구니 총 합계 금액 출력
        System.out.println("\n[ Total ]");
        printColorPrompt(TextColor.YELLOW, "W " + cart.getTotalPrice() + "\n");

        // 장바구니 결제 여부 메시지
        System.out.println("\n1. 주문   2. 메뉴판");

        // 기본 입력창 출력
        printInputPrompt(InputPrompt.DEFAULT);
    }

    /**
     * ✅장바구니 비우기 여부 안내를 출력하는 메서드
     */
    public void printOrderCancelPrompt(){
        printColorPrompt(TextColor.YELLOW, "\n장바구니를 비우시겠습니까?\n");
        System.out.println("1. 비우기   2. 처음으로");
        printInputPrompt(InputPrompt.DEFAULT);
    }

    /**
     * ✅장바구니 비우기 성공 안내를 출력하는 메서드
     */
    public void printSuccessCartClearPrompt(){
        printColorPrompt(TextColor.GREEN, "장바구니를 비웠습니다.\n\n");
    }

    /**
     * ✅주문 성공 안내를 출력하는 메서드
     * @param totalPrice 주문 금액
     */
    public void printSuccessOrderPrompt(double totalPrice){
        printColorPrompt(TextColor.GREEN, "주문이 완료되었습니다. 금액은 W " + totalPrice + " 입니다.\n");
        System.out.println("처음오로 돌아갑니다.\n");
    }

    /**
     * ✅취소 안내 출력 메서드
     */
    public void printCancelPrompt(){
        printColorPrompt(TextColor.GREEN, "취소되었습니다.\n\n");
    }

    /**
     * ✅잘못된 접근 안내 출력 메서드
     */
    public void printInvalidPrompt(){
        printColorPrompt(TextColor.RED, "잘못된 접근입니다.\n\n");
    }

    /**
     * ✅프로그램 종료 안내 출력 메서드
     */
    public void printExitPrompt() {
        printColorPrompt(TextColor.GREEN, "\n🚀 프로그램을 종료합니다.\n");
    }
}
