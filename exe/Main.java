package exe.exe;

import java.math.BigDecimal;
import java.util.Scanner;

import static exe.exe.BankFormPrinter.print2;

public class Main  {
    static double balance;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入账号信息：");
        System.out.print("账号：");
        String accountNumber=scanner.nextLine();
        System.out.print("用户名：");
        String accountName=scanner.nextLine();
        int choice = 0;
        do {

            System.out.println("请选择服务：");
            System.out.println("===1.进行存款操作 2.进行取款操作 3.查询余额操作 4.退出银行系统===");
            choice = scanner.nextInt();
            switch (choice) {
                case 3:
                    System.out.println("账号："+accountNumber);
                    System.out.println("用户名："+accountName);
                    DepositAccount.showBalance();
                    break;
                case 2:
                    System.out.println("账号："+accountNumber);
                    System.out.println("用户名："+accountName);
                    System.out.println("请输入取款金额");
                    double num =scanner.nextDouble();
                    BankAccount.withdraw(num);


                    break;
                case 1:
                    System.out.println("账号："+accountNumber);
                    System.out.println("用户名："+accountName);
                    System.out.println("请输入存款方式：");
                    System.out.println("1. 定期存款");
                    System.out.println("2. 活期存款");
                    System.out.println("3. 整存整取");
                    int depositType = scanner.nextInt();
                    System.out.print("请输入存款金额（元）：");
                    double amount = scanner.nextDouble();
                    // 根据不同存款方式创建不同的存款信息对象
                    switch (depositType) {
                        case 1: // 定期存款
                            System.out.println("请输入想要存入的月份");
                            int moon= scanner.nextInt();
                            DepositAccount.fixedDeposit(amount,moon);
                            System.out.println("1.输出银行表单");
                            System.out.println("2.跳过这步操作");
                            int jud=scanner.nextInt();
                            if (jud==1){
                                BigDecimal bigDecimal=new BigDecimal(String.valueOf(balance));
                                double balance1=bigDecimal.doubleValue();
                                BankFormPrinter.print(accountName,accountNumber,amount,moon,balance1);
                            }

                            break;
                        case 2: // 活期存款
                            DepositAccount.currentDeposit(amount);

                            System.out.println("1.输出银行表单");
                            System.out.println("2.跳过这步操作");
                            jud=scanner.nextInt();
                            if (jud==1){
                                BigDecimal bigDecimal=new BigDecimal(String.valueOf(balance));
                                double balance1=bigDecimal.doubleValue();
                                BankFormPrinter.print1(accountName, accountNumber, amount,balance1);
                            }
                            break;
                        case 3: // 整存整取
                            System.out.println("请输入想要存入的年份");
                             int year= scanner.nextInt();
                            DepositAccount.regularDeposit(amount,year);
                            System.out.println("1.输出银行表单");
                            System.out.println("2.跳过这步操作");
                            jud=scanner.nextInt();
                            if (jud==1){
                                BigDecimal bigDecimal=new BigDecimal(String.valueOf(balance));
                                double balance1=bigDecimal.doubleValue();
                            print2(accountName, accountNumber, amount, year,balance1);}
                            break;
                        default:
                            System.out.println("错误的存款方式！");
                            return;
                    }
                case 4:
                    System.out.println("账号："+accountNumber);
                    System.out.println("用户名："+accountName);
                    System.out.println("感谢您的使用，再见！");
                    break;
                default:
                    System.out.println("账号："+accountNumber);
                    System.out.println("用户名："+accountName);
                    System.out.println("请输入正确的选项！");
            }
        } while (choice != 4);
    }
}