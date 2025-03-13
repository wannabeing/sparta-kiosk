package model;

import handler.MenuHandler;
import handler.OrderHandler;
import utils.InputPrompt;
import io.input.InputReader;
import io.output.OutputPrinter;
import utils.TextColor;

import java.util.ArrayList;
import java.util.List;

public class Kiosk {
    // ✅속성
    private final List<Menu> menus; // 메인메뉴 리스트
    private final Cart cart; // 장바구니
    private int kioskMenuMaxValue; // 키오스크 메뉴의 유효한 범위 최대값

    OutputPrinter printer;
    InputReader reader;

    private final MenuHandler menuHandler;
    private final OrderHandler orderHandler;

    // ✅생성자
    public Kiosk(){
        // 객체 초기화
        menus = new ArrayList<>();
        cart = new Cart();

        printer = new OutputPrinter();
        reader = new InputReader();

        menuHandler = new MenuHandler(cart, menus);
        orderHandler = new OrderHandler(cart);

        // 메인 메뉴 생성
        initializeSpartaMenu();

        // 키오스크 메뉴의 범위 초기화
        updateKioskMenuRange();
    }

    // ✅키오스크 프로그램 시작 메서드
    public void start(){
        // 무한 루프 시작
        while (true){
            // 키오스크 메뉴 출력
            this.displayKioskMenu();

            // 유효한 사용자 입력 값을 받음
            int selectedMenuNumber = menuHandler.getSelectedNumberInRange(kioskMenuMaxValue, true);

            // 0 입력 받을 시, 프로그램 종료
            if (selectedMenuNumber == 0){
                this.terminate();
                break;
            }

            // 장바구니 기능의 시작 번호
            int orderMenuStartNumber = menus.size() + 1;

            // ✅주문 기능 실행 (장바구니가 비어있지 않고, 장바구니 기능 번호를 눌렀을 경우)
            if(!cart.getCartItems().isEmpty() && selectedMenuNumber >= orderMenuStartNumber){
                // OrderMenu(주문) 기능 실행
                orderHandler.selectOrderMenu(selectedMenuNumber, orderMenuStartNumber);

                // 실행 이후, 메인으로 이동
                continue;
            }

            // ✅메뉴 선택기능 실행 (장바구니 기능번호가 아닐 경우)
            menuHandler.chooseMenu(selectedMenuNumber);

        }
    }

    // ✅키오스크 메뉴 출력 메서드
    private void displayKioskMenu() {
        // 메인 메뉴가 비어있는지 확인
        if(menus.isEmpty()){
            printer.printColorPrompt(TextColor.YELLOW, "영업준비중 입니다...🚀\n");
            System.exit(0);
        }

        // 키오스크 메뉴 범위 업데이트
        updateKioskMenuRange();

        // 메인 메뉴(스파르타 메뉴) 출력
        printer.printSpartaMenuList(menus);

        // 장바구니가 비어있지 않으면, 오더 메뉴 추가하여 출력
        if(!cart.getCartItems().isEmpty()){
            printer.printOrderMenu(menus.size() + 1);
        }
        // 입력창 출력
        printer.printInputPrompt(InputPrompt.EXIT);
    }

    /**
     * ✅키오스크 프로그램 종료 메서드
     */
    public void terminate(){
        printer.printExitPrompt();
        System.exit(0); // 프로그램 종료
    }

    // ✅키오스크 메뉴 범위 업데이트 메서드
    public void updateKioskMenuRange(){
        // 장바구니에 1개 이상의 메뉴가 담겼을 경우, 키오스크 메뉴범위에 오더메뉴 범위 추가
        kioskMenuMaxValue = menus.size() + (cart.getCartItems().isEmpty() ? 0 : 2);
    }

    // ✅메인 메뉴 설정 메서드
    // FIXME: 추후 프로젝트에서는 분리해야 할 부분
    public void initializeSpartaMenu(){
        // 햄버거 메뉴 설정
        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 6.9, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // 음료수 메뉴 설정
        Menu drinkMenu = new Menu("Drinks");
        drinkMenu.addMenuItem(new MenuItem("Coke/ZeroCoke", 3.0, "클래식한 코카콜라 또는 제로콜라"));
        drinkMenu.addMenuItem(new MenuItem("Dr Pepper", 3.5, "23가지의 독특한 맛이 어우러져 매력적인 맛을 자랑하는 닥터페퍼"));
        drinkMenu.addMenuItem(new MenuItem("Welch's", 3.0, "웰치스의 풍부한 맛을 느낄 수 있는 포도음료"));
        drinkMenu.addMenuItem(new MenuItem("Lipton", 3.0, "시원한 복숭아 맛의 아이스티"));

        // 사이드 메뉴 설정
        Menu sideMenu = new Menu("Desserts");
        sideMenu.addMenuItem(new MenuItem("Corn Salad", 3.0, "달콤한 옥수수와 부드러운 마요네즈가 어우러져 크리미하고 상큼한 맛"));
        sideMenu.addMenuItem(new MenuItem("Chicken Tender", 3.0, "겉바속촉의 치킨텐더"));
        sideMenu.addMenuItem(new MenuItem("Fries", 3.0, "바삭하고 고소한 감자튀김 (맥날st)"));

        menus.add(burgerMenu);
        menus.add(drinkMenu);
        menus.add(sideMenu);
    }

}
