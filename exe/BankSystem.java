package exe.exe;


    public class BankSystem {
        static double balance=0; // 余额

        public BankSystem( double balance) {
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public static void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("取款成功！余额为：" + balance);
            } else {
                System.out.println("余额不足，取款失败！");
            }
        }

    }

