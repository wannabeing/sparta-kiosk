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
     * ✅상세메뉴 속성을 문자열로 반환하는 메서드
     * @return 메뉴 속성 (문자열)
     */
    public String getFormattedString(){
        return name +
                " | W " +
                price +
                " | " +
                description;
    }

    /**
     * ✅상세메뉴의 이름을 반환하는 메서드
     * @return 상세메뉴 이름
     */
    public String getName(){
        return name;
    }
    /**
     * ✅상세메뉴의 가격을 반환하는 메서드
     * @return 상세메뉴 가격
     */
    public double getPrice(){
        return price;
    }

}
