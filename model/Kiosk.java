package model;

import io.input.InputReader;
import io.output.OutputPrinter;

import java.util.ArrayList;
import java.util.List;

public class Kiosk {
    // ✅속성
    private final List<Menu> menus;

    OutputPrinter outputPrinter = new OutputPrinter();
    InputReader inputReader = new InputReader();

    // ✅생성자
    public Kiosk(){
        // 객체 초기화
        menus = new ArrayList<>();

        // 키오스크에 메인메뉴 설정
        setMainMenu();
    }

    // ✅프로그램 시작 메서드
    public void start(){
        // 무한 루프 시작
        while (true){
            // 메인메뉴 출력
            this.printMainMenu();

            // selectedMenuNumber: 입력 받은 사용자 정수 값
            int selectedMenuNumber = this.getSelectedNumberInRange(menus.size());


            // 0 입력 받을 시, 프로그램 종료
            if (selectedMenuNumber == 0){
                this.exit();
                break;
            }

            // 선택한 메뉴, 메뉴 출력
            Menu selectedMenu = menus.get(selectedMenuNumber - 1);
            outputPrinter.printSelectedMenu(selectedMenu);

            // selectedMenuItemNumber: 입력 받은 사용자 정수 값
            outputPrinter.printMenuItemInputPrompt();
            int selectedMenuItemNumber = this.getSelectedNumberInRange(selectedMenu.getMenuItemCount());

            // 0 입력 받을 시, continue
            if (selectedMenuItemNumber == 0){
                System.out.println();
                continue;
            }

            // 선택한 상세메뉴, 상세메뉴 출력
            MenuItem selectedMenuItem = selectedMenu.getMenuItem(selectedMenuItemNumber - 1);
            outputPrinter.printSelectedMenuItem(selectedMenuItem.toString());
        }
    }

    // ✅메인 메뉴 출력 메서드
    private void printMainMenu() {
        outputPrinter.printMainMenuList(menus);
        outputPrinter.printMenuInputPrompt();
    }

    // ✅선택된 번호 반환 메서드
    private int getSelectedNumberInRange(int range){
        return inputReader.checkIntScanner(range);
    }

    // ✅키오스크 메뉴 추가 메서드
    // FIXME: 다른 방법 고민 필요
    public void setMainMenu(){
        // 햄버거 메뉴 추가
        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 6.9, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // 음료수 메뉴 추가
        Menu drinkMenu = new Menu("Drinks");
        drinkMenu.addMenuItem(new MenuItem("Coke/ZeroCoke", 3.0, "클래식한 코카콜라 또는 제로콜라"));
        drinkMenu.addMenuItem(new MenuItem("Dr Pepper", 3.5, "23가지의 독특한 맛이 어우러져 매력적인 맛을 자랑하는 닥터페퍼"));
        drinkMenu.addMenuItem(new MenuItem("Welch's", 3.0, "웰치스의 풍부한 맛을 느낄 수 있는 포도음료"));
        drinkMenu.addMenuItem(new MenuItem("Lipton", 3.0, "시원한 복숭아 맛의 아이스티"));

        // 사이드 메뉴 추가
        Menu sideMenu = new Menu("Desserts");
        sideMenu.addMenuItem(new MenuItem("Corn Salad", 3.0, "달콤한 옥수수와 부드러운 마요네즈가 어우러져 크리미하고 상큼한 맛"));
        sideMenu.addMenuItem(new MenuItem("Chicken Tender", 3.0, "겉바속촉의 치킨텐더"));
        sideMenu.addMenuItem(new MenuItem("Fries", 3.0, "바삭하고 고소한 감자튀김 (맥날st)"));

        menus.add(burgerMenu);
        menus.add(drinkMenu);
        menus.add(sideMenu);
    }

    // ✅프로그램 종료 메서드
    public void exit(){
        outputPrinter.printExitPrompt();
        System.exit(0); // 프로그램 종료
    }
}
