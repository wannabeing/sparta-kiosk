package io.output;

public enum InputPrompt {
    EXIT("프로그램 종료: 0"),
    BACK("뒤로가기: 0"),
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
