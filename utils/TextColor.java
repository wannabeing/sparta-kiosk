package utils;

/**
 * OutputPrinter 에서
 * 색상 텍스트를 출력할 때 사용하는 Enum 클래스
 */
public enum TextColor {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m");

    private final String code;

    TextColor(String code) {
        this.code = code;
    }

    /**
     * ✅색상 텍스트를 반환하는 메서드
     *
     * @param text 사용자에게 출력할 텍스트
     * @return 사용자에게 출력할 색상 텍스트
     */
    public String apply(String text) {
        return code // 색상 설정
                + "\u001B[1m" // 볼드체 설정
                + text
                + "\u001B[0m"; // 색상 초기화
    }
}
