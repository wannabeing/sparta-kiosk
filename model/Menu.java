package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // ✅속성
    private final String category; // 메뉴 카테고리(이름)
    private final List<MenuItem> items; // 상세메뉴 리스트

    // ✅생성자
    public Menu(String category){
        this.category = category;
        this.items = new ArrayList<>();
    }

    /**
     * ✅메뉴에 상세메뉴를 추가하는 메서드
     * @param item 추가할 상세메뉴
     */
    public void addMenuItem(MenuItem item){
        items.add(item);
    }

    /**
     * ✅메뉴 카테고리(이름) 반환하는 메서드
     * @return 메뉴 카테고리(이름)
     */
    public String getCategory() {
        return category;
    }

    /**
     * ✅메뉴에 있는 상세메뉴 리스트 전체를 반환하는 메서드
     * Q. Collections.unmodifiableList()
     * -> items 자체를 불변리스트로 만들기 위한 코드
     *
     * @return 메뉴에 있는 상세메뉴 리스트
     */
    public List<MenuItem> getMenuItems(){
        return items.isEmpty()
                ? List.of()
                : items.stream().toList();
    }

    /**
     * ✅선택된 상세메뉴를 반환하는 메서드
     * @param index 상세메뉴의 인덱스 번호
     * @return 선택된 상세메뉴
     */
    public MenuItem getMenuItem(int index){
        // 인덱스가 유효하지 않은 경우
        if(index < 1 || index > items.size()) {
            System.out.println("잘못된 상세메뉴 번호입니다.");
            return null;
        }

        return items.stream()
                .skip(index - 1) // 인덱스에 해당하는 처음 값 가져오기
                .findFirst()
                .orElse(null);
    }

    /**
     * ✅메뉴에 저장된 상세메뉴 개수를 반환하는 메서드
     * @return 상세메뉴의 개수
     */
    public int getMenuItemCount(){
        return items.size();
    }
}
