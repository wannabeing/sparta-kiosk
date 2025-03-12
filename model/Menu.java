package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // ✅속성
    private final String category; // 메뉴 카테고리(이름)
    private final List<MenuItem> items; // 메뉴 항목 리스트

    // ✅생성자
    public Menu(String category){
        this.category = category; // 메뉴 카테고리 초기화
        this.items = new ArrayList<>(); // 메뉴 리스트 초기화
    }

    // ✅SETTER | 메뉴 추가 메서드
    public void addMenuItem(MenuItem item){
        items.add(item);
    }

    // ✅GETTER | 메뉴 이름 반환 메서드
    public String getCategory() {
        return category;
    }

    // ✅GETTER | 메뉴 리스트 반환 메서드
    public List<MenuItem> getMenuItems(){
        if(items.isEmpty()){
            System.out.println("상세메뉴가 준비되지 않았습니다.");
            return new ArrayList<>();
        }
        return items;
    }

    // ✅GETTER | 선택된 상세메뉴 반환 메서드
    public MenuItem getMenuItem(int index){
        if (index > 0 && index <= items.size()) {
            return items.get(index - 1);
        }
        // 잘못된 인덱스일 경우, null 반환
        else {
            System.out.println("잘못된 상세메뉴 번호입니다.");
            return null;
        }
    }

    // ✅GETTER | 메뉴 리스트 길이 반환 메서드
    public int getMenuItemCount(){
        return items.size();
    }
}
