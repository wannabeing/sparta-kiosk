package io.output;


import model.Menu;
import model.MenuItem;

import java.util.List;

public class OutputPrinter {
    // ✅메뉴 입력창 프롬프트 출력 메서드
    public void printMenuInputPrompt(){
        System.out.print("➡️선택창 (프로그램 종료: 0): ");
    }

    // ✅메뉴아이템 입력창 프롬프트 출력 메서드
    public void printMenuItemInputPrompt(){
        System.out.print("➡️선택창 (뒤로가기: 0): ");
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
    }

    /**
     * ✅선택된 메뉴 출력 메서드
     * @param menu 선택된 메뉴
     */
    public void printSelectedMenu(Menu menu){
        List<MenuItem> menuItems = menu.getMenuItems();

        System.out.println("\n[ " + menu.getCategory() + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
    }

    /**
     * ✅선택된 상세메뉴 출력 메서드
     * @param menuItemInfo 상세메뉴 정보
     */
    public void printSelectedMenuItem(String menuItemInfo){
        System.out.println("\n📌 선택된 메뉴는 아래와 같습니다.");
        System.out.println(menuItemInfo);
        System.out.println();
    }

    // ✅프로그램 종료 메시지 출력 메서드
    public void printExitPrompt() {
        System.out.println("\n🚀 프로그램을 종료합니다.");
    }
}
