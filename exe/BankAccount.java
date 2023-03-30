package exe.exe;

public class BankAccount {
    private static String accountNumber; // 账号
    private static double balance; // 余额

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        BankAccount.balance = balance;
    }

    public static void withdraw(double money) {
        new BankAccount(accountNumber, balance);
        if(money <= balance) {
            balance = balance - money;
            System.out.println("取款成功，取款金额为：" + money + "，余额为：" + balance);
        } else {
            System.out.println("余额不足，取款失败");
        }
    }

    // 其他方法...
}