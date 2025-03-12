package model;

public class MenuItem {
    // ✅속성
    private final String name; // 이름
    private final double price; // 가격
    private final String description; // 설명

    // ✅생성자
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * ✅메뉴 속성 문자열 반환 메서드
     * @return 메뉴 속성
     */
    public String getFormattedString(){
        return name +
                " | W " +
                price +
                " | " +
                description;
    }

}
