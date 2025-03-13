package utils;

/**
 * OutputPrinter 에서
 * 사용자 입력창을 동적으로 보여줄 때 사용하는 Enum 클래스
 */
public enum InputPrompt {
    EXIT("프로그램 종료: 0"),
    BACK("뒤로가기: 0"),
    ALL("전체비우기: 0"),
    DEFAULT("");

    // ✅속성
    private final String message;

    // ✅생성자
    InputPrompt(String message) {
        this.message = message;
    }

    // ✅ Enum 메시지 반환하는 메서드
    public String getMessage(){
        return message;
    }
}
