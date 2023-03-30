package exe.exe;

import static exe.exe.NumberToChineseUtil.toChineseRMB;

public class BankFormPrinter {
    public static void print(String accountName, String accountNumber,double amount,int moon,double balance) {
        // 打印表头
        System.out.println("*************************************");
        System.out.println("************ 银行存款凭证 ************");
        System.out.println("*************************************\n");
        // 打印账户信息
        System.out.println("账户名：" + accountName);
        System.out.println("账号：" + accountNumber);
        // 打印交易信息
        System.out.println("交易记录：");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-20s%-20s%-20s%n", "日期", "交易类型", "金额（元）");
        System.out.println("---------------------------------------------------------");
        System.out.println(moon+"月\t      "+"          定期存款\t"+   "             "+    amount+"\t");
        System.out.println("---------------------------------------------------------\n");
        System.out.println("余额："+toChineseRMB(balance));

        // 打印表尾
        System.out.println("*************************************");
        System.out.println("************ 请妥善保管 ************");
        System.out.println("*************************************");
    }
    public static void print1(String accountName, String accountNumber,double amount ,double balance) {
        // 打印表头
        System.out.println("*************************************");
        System.out.println("************ 银行存款凭证 ************");
        System.out.println("*************************************\n");
        // 打印账户信息
        System.out.println("账户名：" + accountName);
        System.out.println("账号：" + accountNumber);
        // 打印交易信息
        System.out.println("交易记录：");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-20s%-20s%-20s%n",  "交易类型", "金额（元）");
        System.out.println("---------------------------------------------------------");
        System.out.println("       "+"         活期存款\t"+   "            "+    amount+"\t");
        System.out.println("---------------------------------------------------------\n");
        System.out.println("余额："+toChineseRMB(balance));

        // 打印表尾
        System.out.println("*************************************");
        System.out.println("************ 请妥善保管 ************");
        System.out.println("*************************************");
    }
    public static void print2(String accountName, String accountNumber,double amount,int moon,double balance) {
        // 打印表头
        System.out.println("*************************************");
        System.out.println("************ 银行存款凭证 ************");
        System.out.println("*************************************\n");
        // 打印账户信息
        System.out.println("账户名：" + accountName);
        System.out.println("账号：" + accountNumber);
        // 打印交易信息
        System.out.println("交易记录：");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-20s%-20s%-20s%n", "日期", "交易类型", "金额（元）");
        System.out.println("---------------------------------------------------------");
        System.out.println(moon+"月\t      "+"           整存整取\t"+   "              "+    amount+"\t");
        System.out.println("---------------------------------------------------------\n");
        System.out.println("余额："+toChineseRMB(balance));

        // 打印表尾
        System.out.println("*************************************");
        System.out.println("************ 请妥善保管 ************");
        System.out.println("*************************************");
    }
}