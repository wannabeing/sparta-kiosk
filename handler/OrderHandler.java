package handler;

import common.enums.Discount;
import io.input.InputReader;
import io.output.OutputPrinter;
import model.Cart;

/**
 * 사용자의 장바구니를 조회하고
 * 장바구니에 담긴 메뉴들을 주문 및 취소하는 기능을 담당하는 핸들러
 */
public class OrderHandler {
    //✅속성
    private final OutputPrinter printer;
    private final InputReader reader;

    private final Cart cart; // 키오스크에 저장된 장바구니

    // ✅생성자
    public OrderHandler(Cart cart){
        printer = new OutputPrinter();
        reader = new InputReader();

        this.cart = cart;
    }

    /**
     * ✅사용자의 주문기능을 선택하고 처리하는 메서드
     * @param selectedMenuNumber 선택한 주문 번호
     * @param orderMenuStartNumber 주문기능 시작 번호
     */
    public void selectOrderMenu(int selectedMenuNumber, int orderMenuStartNumber){
//        FIXME: velog 작성 필요
//        switch (selectedMenuNumber) {
//            case orderMenuStartNumber -> placeOrder();
//            case orderMenuStartNumber + 1 -> cancelOrder();
//            default -> printer.printInvalidPrompt();
//        }
        // 입력한 번호가 주문 기능일 경우
        if(selectedMenuNumber == orderMenuStartNumber){
            placeOrder();
        }
        // 입력한 번호가 주문취소(장바구니 비우기)일 경우
        else if (selectedMenuNumber == orderMenuStartNumber + 1){
            cancelOrder();
        }
    }

    /**
     * ✅사용자의 최종 주문(결제)를 하는 메서드
     */
    private void placeOrder(){
        // 장바구니 출력
        printer.printOrderCartPrompt(cart);

        // 1. 주문, 2. 메뉴판
        int selectedNumber = reader.checkIntScanner(2, false);

        // 주문할 경우
        if(selectedNumber == 1){
            // 결제하기 위한 최종 가격 설정
            double finalPrice = calculateFinalPrice();
            cart.setTotalPrice(finalPrice);

            // 결제 메시지 및 장바구니 비우기
            printer.printSuccessOrderPrompt(cart.getTotalPrice());
            cart.clear();
        }
    }

    /**
     * ✅사용자의 할인유형에 따라
     * 할인된 가격을 계산하고 반환하는 메서드
     * @return 할인된 가격
     */
    private double calculateFinalPrice(){
        // 할인 정보 출력
        printer.printDiscountInfoPrompt();

        // 할인 대상 유효범위
        int discountRange = Discount.values().length;

        // 입력한 할인 번호로 Enum 할인 객체로 변환
        int selectedDiscountIndex = reader.checkIntScanner(discountRange, false);
        Discount selectedDiscount = Discount.values()[selectedDiscountIndex - 1];

        return selectedDiscount.getDiscountPrice(cart.getTotalPrice());

    }

    /**
     * ✅장바구니 비우기를 처리하는 메서드
     */
    private void cancelOrder(){
        // 취소 메시지 출력
        printer.printOrderCancelPrompt();

        // 1. 장바구니 비우기, 2. 처음으로
        int selectedNumber = reader.checkIntScanner(2, false);

        // 장바구니 비울 경우
        if(selectedNumber == 1){
            printer.printSuccessCartClearPrompt();
            cart.clear();
        }
    }
}
