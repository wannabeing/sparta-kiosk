package model;

public class MenuItem {
    // ✅속성
    private String name; // 이름
    private double price; // 가격
    private String description; // 설명

    // ✅생성자
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * ✅메뉴 정보 출력 메서드
     * toString() 메서드 재정의하여 메뉴 정보를 반환
     *
     * @return 메뉴 정보
     */
    @Override
    public String toString() {
        return name + " | W " + price + " | " + description;
    }

}
