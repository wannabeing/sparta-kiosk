package io.input;

import java.util.Scanner;

public class InputReader {
    // Scanner 객체 생성
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * ✅입력한 값이 유효한지 검증하고 반환하는 메서드
     *
     * @param maxRange 유효한 값의 최대 값
     * @param allowZero 최소 범위에 0 포함 여부
     * @return 유효한 정수 값
     */
    public int checkIntScanner(int maxRange, boolean allowZero) {
        int number; // 사용자가 입력한 정수
        boolean isValidRange; // 유효한 범위인지 검사하는 변수

        while(true){
            // 입력 값이 정수인 경우
            if(scanner.hasNextInt()){
                number = scanner.nextInt();

                // 유효 범위 설정 (0 포함 여부)
                isValidRange = allowZero ? (number >= 0 && number <= maxRange) : (number > 0 && number <= maxRange);

                // 유효한 범위일 경우, 정수 값 반환
                if (isValidRange) {
                    return number;
                }
            }
            // 입력 값이 정수 이외인 경우
            else {
                scanner.next();
            }
            System.out.print("올바른 숫자를 입력하세요 (" + (allowZero ? "0" : "1") + " ~ " + maxRange + "): ");
        }
    }
}
