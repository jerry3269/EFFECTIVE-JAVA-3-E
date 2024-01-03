package chapter2.item1;

public class AdminSingleTon extends Person{
    private String adminId;
    private String password;
    private String secretKey;

    private static final AdminSingleTon ADMIN_SINGLE_TON = new AdminSingleTon();

    public static AdminSingleTon getInstance() {
        return ADMIN_SINGLE_TON;
    }
}
