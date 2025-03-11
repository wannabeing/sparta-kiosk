package io.input;

import java.util.Scanner;

public class InputReader {
    // Scanner 객체 생성
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * ✅ 사용자의 숫자 입력 값을 검증하고 반환하는 메서드
     *
     * @param range 유효한 값의 범위 (0 ~ range)
     * @return 입력받은 정수 값
     */
    public int checkIntScanner(int range) {
        int number;

        while(true){
            // 입력 값이 정수인 경우
            if(scanner.hasNextInt()){
                number = scanner.nextInt();

                // 0 ~ range 인 값일 경우 반환
                if (number >= 0 && number <= range) {
                    return number;
                }
            }
            // 입력 값이 정수 이외인 경우
            else {
                scanner.next();
            }

            System.out.print("올바른 숫자를 입력하세요 (0 ~ " + range + "): ");
        }
    }
}
