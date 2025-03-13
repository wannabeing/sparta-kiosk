package handler;

import io.input.InputReader;
import io.output.OutputPrinter;
import model.Cart;
import model.Menu;
import model.MenuItem;

import java.util.List;

/**
 * 사용자의 입력에 따라 메뉴를 선택하고,
 * 상세 메뉴를 장바구니에 추가하는 기능을 담당하는 핸들러
 */
public class MenuHandler {
    // ✅속성
    private final OutputPrinter printer;
    private final InputReader reader;

    private final Cart cart; // 키오스크에 저장된 장바구니
    private final List<Menu> menus; // 키오스크에 저장된 메뉴 리스트

    // ✅생성자
    public MenuHandler(Cart cart, List<Menu> menus){
        this.cart = cart;
        this.menus = menus;

        printer = new OutputPrinter();
        reader = new InputReader();
    }

    /**
     * ✅사용자가 메뉴를 선택하고,
     * 상세메뉴를 장바구니에 추가할 수 있는 기능을 처리하는 메서드
     *
     * @param index 사용자가 입력한 번호
     */
    public void chooseMenu(int index){
        // 선택된 메뉴
        Menu selectedMenu = findMenuByIndex(index);

        // 잘못된 메뉴번호일 경우, 메인으로 이동
        if(selectedMenu == null){
            printer.printInvalidPrompt();
            return;
        }

        // 선택한 메뉴의 상세메뉴 출력
        printer.printSelectedMenu(selectedMenu.getMenuItems(), selectedMenu.getCategory());

        // selectedMenuItemNumber: 유효한 사용자 입력 값
        int selectedMenuItemNumber = getSelectedNumberInRange(selectedMenu.getMenuItemCount(), true);

        // 0 입력 받을 시, 뒤로 이동 (메인으로 이동)
        if (selectedMenuItemNumber == 0){
            return;
        }

        // 선택한 상세메뉴
        MenuItem selectedMenuItem = selectedMenu.getMenuItem(selectedMenuItemNumber);

        // 잘못된 상세메뉴번호일 경우, 메인으로 이동
        if(selectedMenuItem == null){
            printer.printInvalidPrompt();
            return;
        }

        // 선택한 상세메뉴 출력
        printer.printSelectedMenuItem(selectedMenuItem.getFormattedString());

        // cartAddNumber: 입력받은 사용자 정수 값 (1: 추가, 2: 취소)
        int cartAddNumber = getSelectedNumberInRange(2, false);

        // 1. 장바구니에 추가 시
        if(cartAddNumber == 1){
            printer.printSuccessAddCartPrompt(selectedMenuItem);
            cart.add(selectedMenuItem);
        }
        // 2. 취소 시
        else {
            printer.printCancelPrompt();
        }
    }

    /**
     * ✅인덱스가 유효한지 검사하고, 인덱스에 해당하는 메뉴 반환하는 메서드
     * @param index 메뉴 인덱스 번호
     * @return 선택된 메뉴 (or null)
     */
    public Menu findMenuByIndex(int index){
        if (index > 0 && index <= menus.size()) {
            return menus.get(index - 1);
        }
        // 잘못된 인덱스일 경우, null 반환
        else {
            System.out.println("잘못된 메뉴번호 입니다.");
            return null;
        }
    }

    /**
     * ✅입력한 숫자가 유효한 범위에 있는지 체크하고 반환하는 메서드
     * @param maxRange 유효 최대 범위 값
     * @param allowZero 유효값에 0 포함 여부
     * @return 유효한 입력 값
     */
    public int getSelectedNumberInRange(int maxRange, boolean allowZero){
        return reader.checkIntScanner(maxRange, allowZero);
    }
}
