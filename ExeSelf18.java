package 练习;
import java.util.Objects;
import java.util.Scanner;
public class ExeSelf18 {
    /**
     * 将阿拉伯数字转换为中文繁体数字
     * @param num 要转换的数字
     * @return 转换后的中文繁体数字
     */
    private static String numToChinese(int num) {
        String[] chineseNums = {"零","壹","貳","叁","肆","伍","陸","柒","捌","玖"};
        String[] chineseUnits = {"","拾","佰","仟","萬","億","兆"};
        String chineseStr = "";
        int unitPos = 0;
        boolean needZero = false;
        while(num > 0){
            int digit = num % 10;
            if(digit == 0){
                if(needZero){
                    chineseStr = chineseNums[0] + chineseStr;
                }
                needZero = true;
            }else{
                chineseStr = chineseNums[digit] + chineseUnits[unitPos] + chineseStr;
                needZero = false;
            }
            unitPos++;
            num /= 10;
        }
        return chineseStr;
    }
public static void main(String[] args){
    double balance=0;//银行余额
    double interest=0;//利息
    Scanner myScanner=new Scanner(System.in);
    System.out.println("请输入您的姓名");
    String name= myScanner.next();
    System.out.println("账号");
    String account= myScanner.next();
    System.out.println("1.活期存款");
    System.out.println("2.定期存款");
    int mode=myScanner.nextInt();
    //活期存款模块


    if (mode==1) {
        System.out.println("请输入您想存储的金额");
        double amount= myScanner.nextDouble();
        balance +=amount;
        System.out.println("1.输出余额信息");
        System.out.println("2.打印银行表单");
        System.out.println("3.进行取钱操作");
        System.out.println("4.退出银行系统");
        int judgment= myScanner.nextInt();
        if(judgment==1){
            int a=(int)balance;
        System.out.print("姓名:"+name+"\t"+"账号:"+account+"\t"+"存款数:"+amount+"元\t"+"余额:"+balance+"元\t");
        System.out.println( "姓名"+name+"\t"+"账号："+account+"余额:"+numToChinese((int)balance)+"元");
        }else if(judgment==4){
            System.out.println("退出系统");
        }else if(judgment==2){
            System.out.println("欢迎来到中国建设银行！");
            System.out.println("============================================================");
            System.out.println("姓名：" + name + "                             账号：" + account);
            System.out.println("============================================================");
            System.out.println("存款类型                   存款金额                  利率          利息");
            System.out.println("============================================================");
            System.out.printf("%-18s%-26.2f%-15s%-15.2f%n", "活期存款", amount, "0.35%", amount*0.035 );
            System.out.println("============================================================");
            System.out.println("请确认以上信息是否正确：（Y/N）");
            String confirm = myScanner.next();
            if (confirm.equalsIgnoreCase("Y")) {
                System.out.println("正在打印表单，请稍等...");
                System.out.println("============================================================");
                System.out.println("姓名：" + name + "                             账号：" + account);
                System.out.println("============================================================");
                System.out.println("存款类型                   存款金额                  利率          利息");
                System.out.println("============================================================");
                System.out.printf("%-18s%-26.2f%-15s%-15.2f%n", "活期存款" +"   "+amount, "0.35%", amount * 0.0035);
                System.out.println("============================================================");
                System.out.println("表单打印完成，请取走您的存折和银行卡！");
            }
        } else if (judgment==3) {
            while (true) {
                System.out.println("您当前的余额为：" + balance + "元，请输入取款金额（输入0退出）：");
                double num = myScanner.nextDouble();

                // 如果用户输入0，则退出程序
                if (num == 0) {
                    System.out.println("感谢您的使用，再见！");
                }
                // 如果用户输入的金额大于余额，则无法取款
                if (num > balance) {
                    System.out.println("余额不足，无法取款！");
                } else {
                    // 更新余额
                    balance -= num;
                    System.out.println("取款成功，取款金额为：" + amount + "元，当前余额为：" + balance + "元。");
                    System.out.println("余额："+numToChinese((int)balance));
                }
            }
        }
        //定期存款模块
    }else if (mode==2){
            System.out.println("请输入您想存储的金额");
            double amount= myScanner.nextDouble();
            System.out.println("请输入您想存储的时间---(三个月/半年/一年/两年/三年/五年)");
            String storagetime=myScanner.next();
            if (Objects.equals(storagetime, "三个月")){//利息计算
              interest=amount*0.0135*0.25;
            }else if (Objects.equals(storagetime, "半年")){
                interest=amount*0.0155*0.5;
            }else if (Objects.equals(storagetime, "一年")){
                interest=amount*0.0175*1;
            }else if (Objects.equals(storagetime, "两年")){
                interest=amount*0.0225*2;
            }else if (Objects.equals(storagetime, "三年")) {
                interest = amount * 0.0275*3;
            }
            else if (Objects.equals(storagetime, "五年")){
                interest=amount*0.0275*5;
            }
            balance =amount+interest;
            System.out.println("1.输出余额信息");
            System.out.println("2.打印银行表单");
            System.out.println("3.进行取钱操作");
            System.out.println("4.退出银行系统");

            int judgment= myScanner.nextInt();
            if(judgment==1){
                int a;
                a=(int)balance;
                String balanceStr=numToChinese( a);
                System.out.println("姓名"+name+"\t"+"账号："+account+"\t"+"存款金额:"+amount+"元\t"+"存款时间："+storagetime+"\t"+"利息:"+interest+"元\t"+"本息合计:"+balance+"元");
                System.out.println( "姓名"+name+"\t"+"账号："+account+"本息合计:"+numToChinese((int)balance)+"元");
            }else if(judgment==4){
                System.out.println("退出系统");
            }else if(judgment==2){
                System.out.println("欢迎来到中国建设银行！");

                System.out.println("============================================================");
                System.out.println("姓名：" + name + "                             账号：" + account);
                System.out.println("============================================================");
                System.out.println("存款类型                   存款金额                  利率          利息");
                System.out.println("============================================================");
                System.out.printf("%-18s%-26.2f%-15s%-15.2f%n",  "定期存款"+storagetime, amount, "1.25%", amount * 0.0125);
                System.out.println("============================================================");

                System.out.println("请确认以上信息是否正确：（Y/N）");
                String confirm = myScanner.next();
                if (confirm.equalsIgnoreCase("Y")) {
                    System.out.println("正在打印表单，请稍等...");
                    System.out.println("============================================================");
                    System.out.println("姓名：" + name + "                             账号：" + account);
                    System.out.println("============================================================");
                    System.out.println("存款类型                   存款金额                  利率          利息");
                    System.out.println("============================================================");
                    System.out.printf("%-18s%-26.2f%-15s%-15.2f%n", "定期存款"+"    "+storagetime, amount, "1.25%", amount * 0.0125);
                    System.out.println("============================================================");
                    System.out.println("表单打印完成，请取走您的存折和银行卡！");
                }
                else {
                        System.out.println("请输入正确的指令");
                }
                    } else if(judgment==3) {
                // 不断循环，直到用户输入退出指令
                while (true) {
                    System.out.println("您当前的余额为：" + balance + "元，请输入取款金额（输入0退出）：");
                    double num = myScanner.nextDouble();

                    // 如果用户输入0，则退出程序
                    if (num == 0) {
                        System.out.println("感谢您的使用，再见！");
                    }

                    // 如果用户输入的金额大于余额，则无法取款
                    if (num > balance) {
                        System.out.println("余额不足，无法取款！");
                    } else {
                        // 更新余额
                        balance -= num;
                        System.out.println("取款成功，取款金额为：" + amount + "元，当前余额为：" + balance + "元。");
                        System.out.println("余额："+numToChinese((int)balance));
                    }
                }
            }

    }else{
        System.out.println("请输入正确的存款方式");
    }
}}
