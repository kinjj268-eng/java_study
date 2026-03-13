package 회원관리시스템;

public class Member {
    // 필드 (표에 있는 순서대로)
    public static int totalCount = 0; // 전체 가입 회원 수 (모든 객체가 공유)
    private int id;                  // 회원번호 (고유 번호)
    private String name;
    private String userId;
    private String password;
    private int age;

    // 생성자: 회원가입 시 호출
    public Member(String name, String userId, String password, int age) {
        totalCount++;         // 가입 시 전체 수 증가
        this.id = totalCount; // 증가된 번호를 이 회원의 번호로 부여
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.age = age;
    }

    // 메서드 (조건 필수 구현)
    public static int getTotalCount() { return totalCount; }
    public String getUserId() { return userId; }

    // 로그인 확인: 문자열 비교는 반드시 .equals() 사용
    public boolean login(String userId, String password) {
        return this.userId.equals(userId) && this.password.equals(password);
    }

    // 정보 수정: 아이디 제외
    public void updateInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }

    // 비밀번호 변경
    public void changePassword(String oldPw, String newPw) {
        if(this.password.equals(oldPw)) {
            this.password = newPw;
            System.out.println("→ 비밀번호가 변경되었습니다.");
        } else {
            System.out.println("→ 현재 비밀번호가 일치하지 않습니다.");
        }
    }

    // 정보 출력
    public void printInfo() {
        System.out.printf("회원번호: %d | 이름: %s | 아이디: %s | 나이: %d세\n", id, name, userId, age);
    }
    public static  void decreaseCount() {  // 회원 삭제 시 감소
        if (totalCount > 0) totalCount--;
    }
}