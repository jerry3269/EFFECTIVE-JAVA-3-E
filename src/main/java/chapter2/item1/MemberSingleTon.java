package chapter2.item1;

public class MemberSingleTon extends Person {
    private String userId;
    private String password;

    private static final MemberSingleTon MEMBER_SINGLE_TON = new MemberSingleTon();

    public static MemberSingleTon getInstance() {
        return MEMBER_SINGLE_TON;
    }
}
