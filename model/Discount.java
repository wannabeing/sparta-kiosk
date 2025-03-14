package model;

public enum Discount {
    VETERAN(0.10, "국가유공자"),
    SOLDIER(0.05,"군인"),
    STUDENT(0.03, "학생"),
    GENERAL(0.00, "일반");

    // ✅속성
    private final double discountRate; // 할인율
    private final String label; // 할인 유형

    // ✅생성자
    Discount(double discountRate, String label){
        this.discountRate = discountRate;
        this.label = label;
    }

    /**
     * ✅할인된 가격을 반환하는 메서드
     * @param price 원가
     * @return 할인된 가격 (소숫점 첫쨰자리까지)
     */
    public double getDiscountPrice(double price){
        return Math.round(price * (1 - discountRate) * 10) / 10.0;
    }

    /**
     * ✅할인율을 백분율로 반환하는 메서드
     * @return 할인율
     */
    public String getDiscountRatePercentage() {
        return (int) (discountRate * 100) + "%";
    }

    /**
     * ✅할인유형을 반환하는 메서드
     * @return 할인유형
     */
    public String getLabel() {
        return label;
    }
}
