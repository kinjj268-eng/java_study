package 회원관리시스템;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Member> memberList = new ArrayList<>(); // 회원 저장소

        while (true) {
            System.out.println("\n=== 회원 관리 시스템 ===");
            System.out.println("[1]회원가입 [2]로그인 [3]전체회원조회 [4]회원삭제 [5]총 회원수 [6]종료");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();

            if (menu == 6) break; // 종료

            switch (menu) {

                case 1:
                    sc.nextLine();
                    System.out.print("이름 입력: ");
                    String name = sc.nextLine();

                    System.out.print("아이디 입력: ");
                    String userId = sc.nextLine();
                    boolean isDuplicate = false;
                    for (Member m : memberList){
                        if(m.getUserId().equals(userId)){
                            isDuplicate = true;
                            break;
                        }
                    }
                if(isDuplicate){
                    System.out.println("이미 사용중인 아이디입니다,");
                }else {
                    System.out.print("비밀번호 입력: ");
                    String password = sc.nextLine();

                    System.out.print("나이 입력 : ");
                    int age = sc.nextInt();

                    // 3. 리스트에 추가
                    Member newMember = new Member(name, userId, password, age);
                    memberList.add(newMember);

                    System.out.println("→ [" + Member.totalCount + "번] " + userId + " 님, 회원가입이 완료되었습니다.");
                }
                    break;
                case 2: // [2] 로그인
                    System.out.print("아이디 입력  : ");
                    String loginId = sc.next();
                    System.out.print("비밀번호 입력: ");
                    String loginPw = sc.next();

                    Member loginMember = null;
                    // 리스트에서 아이디 찾기
                    for (Member m : memberList) {
                        if (m.getUserId().equals(loginId)) {
                            loginMember = m;
                            break;
                        }
                    }

                    if (loginMember == null) {
                        System.out.println("→ 존재하지 않는 아이디입니다.");
                    } else if (!loginMember.login(loginId, loginPw)) {
                        System.out.println("→ 비밀번호가 틀렸습니다.");
                    } else {
                        System.out.println("→ 로그인 성공! 환영합니다, " + loginMember.getUserId() + " 님");

                        // --- 로그인 후 서브 메뉴 ---
                        boolean loginLoop = true;
                        while (loginLoop) {
                            System.out.println("\n[1]내 정보보기 [2]정보수정 [3]비밀번호 변경 [4]로그아웃");
                            System.out.print("선택 : ");
                            int subMenu = sc.nextInt();

                            switch (subMenu) {
                                case 1:
                                    loginMember.printInfo();
                                    break;
                                case 2:
                                    System.out.print("이름 입력 (현재: " + loginMember.getUserId() + ") : ");
                                    String newName = sc.next();
                                    System.out.print("나이 입력 : ");
                                    int newAge = sc.nextInt();
                                    loginMember.updateInfo(newName, newAge);
                                    System.out.println("→ 회원 정보가 수정되었습니다.");
                                    break;
                                case 3:
                                    System.out.print("현재 비밀번호 입력: ");
                                    String oldPw = sc.next();
                                    System.out.print("새 비밀번호 입력: ");
                                    String newPw = sc.next();
                                    loginMember.changePassword(oldPw, newPw);
                                    break;
                                case 4:
                                    System.out.println("→ 로그아웃 되었습니다.");
                                    loginLoop = false;
                                    break;
                            }
                        }
                    }
                    break;
                case 3: // [3] 전체 회원 조회
                    System.out.println("=== 전체 회원 목록 ===");
                    if (memberList.isEmpty()) {
                        System.out.println("가입된 회원이 없습니다.");
                    } else {
                        for (Member m : memberList) {
                            m.printInfo();
                        }
                    }
                    break;
                case 4:
                    System.out.println("삭제할 아이디 입력 : ");
                    String idName = sc.next();

                    Member targetMember = null;

                    for (Member m : memberList) {
                        if (m.getUserId().equals(idName)) {
                            targetMember = m;
                            break;
                        }
                    }


                    if (targetMember == null) {
                        System.out.println("존재하지 않는 아이디입니다.");
                    } else {
                        System.out.println("정말 삭제하시겠습니까? [y/n]");
                        String delete = sc.next();

                        if (delete.equalsIgnoreCase("y")) {
                            memberList.remove(targetMember);
                            Member.decreaseCount();
                            System.out.println("->" + targetMember + " 회원이 삭제되었습니다.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("총 회원수 : " + Member.getTotalCount());
                    break;
                case 6:
                    System.out.println("시스템을 종료합니다.");
                    break;
                default:
                    System.out.println("메뉴 선택이 잘못 되었습니다.");
                    break;


            }
        }

    }
}