package exe;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

import static exe.NumberToChineseUtil.toChineseRMB;

public class DepositAccount {
    static BigDecimal balance; // 余额
    private static LocalDate depositStartDate; // 存款起始日期

    // 定期存款
    public static void fixedDeposit(double amount, int term) {
        BigDecimal interestRate = new BigDecimal("0.0175"); // 利率为 1.20%
        BigDecimal interest = new BigDecimal(Double.toString(amount))
                .multiply(interestRate)
                .multiply(new BigDecimal(term))
                .divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP); // 利息
        balance = balance == null ? new BigDecimal(Double.toString(amount)).add(interest) : balance.add(new BigDecimal(Double.toString(amount))).add(interest);
        depositStartDate = LocalDate.now();
       // System.out.println("存款成功，存款金额为：" + amount + "元，存款期限为：" + term + "个月，利率为：" + interestRate + "%，获得利息为：" + interest + "元，当前余额为：" + balance + "元。");
        System.out.println("存款金额为：" + amount + "元");
        System.out.println("存款余额为：" + toChineseRMB(amount));
        System.out.println("存款期限为：" + term + "个月");
        BigDecimal bigDecimal=new BigDecimal(String.valueOf(interestRate));
        double interestRate1=bigDecimal.doubleValue();
        System.out.println("利率为：" + (interestRate1*100)+"%");
        System.out.println("获得利息为：" + interest + "元");
        System.out.println("当前余额为：" + balance + "元");
        BigDecimal bigDecimal1=new BigDecimal(String.valueOf(balance));
        double balance1=bigDecimal1.doubleValue();
        System.out.println("当前余额为：" + toChineseRMB(balance1));
    }

    // 活期存款
    public static void currentDeposit(double amount) {
        BigDecimal interestRate = new BigDecimal("0.0035"); // 利率为 0.35%
        BigDecimal interest = new BigDecimal(Double.toString(amount))
                .multiply(interestRate)
                .divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP); // 利息
        balance = balance == null ? new BigDecimal(Double.toString(amount)).add(interest) : balance.add(new BigDecimal(Double.toString(amount))).add(interest);
        depositStartDate = LocalDate.now();
        System.out.println("存款金额为：" + amount + "元");
        System.out.println("存款余额为：" + toChineseRMB(amount));
        BigDecimal bigDecimal1=new BigDecimal(String.valueOf(interestRate));
        double interestRate1=bigDecimal1.doubleValue();
        System.out.println("利率为：" + (interestRate1*100)+"%");
        System.out.println("获得利息为：" + interest + "元");
        System.out.println("获得利息为：" + interest + "元");
        System.out.println("当前余额为：" + balance + "元");
        BigDecimal bigDecimal=new BigDecimal(String.valueOf(balance));
        double balance1=bigDecimal.doubleValue();
        System.out.println("当前余额为：" + toChineseRMB(balance1));
    }

    // 整存整取
    public static void regularDeposit(double amount, int term) {
        BigDecimal interestRate = new BigDecimal("0.0275"); // 利率为 1.35%
        BigDecimal interest = new BigDecimal(Double.toString(amount))
                .multiply(interestRate)
                .multiply(new BigDecimal(term))
                .divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP); // 利息
        balance = balance == null ? new BigDecimal(Double.toString(amount)).add(interest) : balance.add(new BigDecimal(Double.toString(amount))).add(interest);
        depositStartDate = LocalDate.now();
        LocalDate depositEndDate = depositStartDate.plusMonths(term);
        Period period = Period.between(depositStartDate, depositEndDate);
        System.out.println("存款金额为：" + amount + "元");
        System.out.println("存款余额为：" + toChineseRMB(amount));
        BigDecimal bigDecimal1=new BigDecimal(String.valueOf(interestRate));
        double interestRate1=bigDecimal1.doubleValue();
        System.out.println("利率为：" + (interestRate1*100)+"%");
        System.out.println("获得利息为：" + interest + "元");
        System.out.println("当前余额为：" + balance + "元");
        BigDecimal bigDecimal=new BigDecimal(String.valueOf(balance));
        double balance1=bigDecimal.doubleValue();
        System.out.println("当前余额为：" + toChineseRMB(balance1));
    }

    // 输出余额
    public void showBalance() {
        System.out.println("当前余额为：" + balance + "元。");
    }
}