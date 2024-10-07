package lab03;

public class TV {   // TV 클래스
    private int size;       // TV 크기

    public TV(int size) {   // 생성자: TV 크기를 초기화
        this.size = size;
    }

    protected int getSize() { // TV 크기를 반환하는 메소드 (자식 클래스에서 사용 가능)
        return size;
    }
}
