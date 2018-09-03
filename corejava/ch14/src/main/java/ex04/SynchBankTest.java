package ex04;

/**
 * @Author : zs.sun
 * @Date : 2018/8/16 10:53
 * @Package : ex03
 * @ProjectName: corejava
 * @Description: This program shows data corruption when multiple threads access a data structure.
 */
public class SynchBankTest {
    public static final int NACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 101;
    public static final int DELAY = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        System.out.println("The bank has total balance is: " + bank.getTotalBalance());
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () ->{
                try
                {
                    while(true)
                    {
                        int toAccount = (int)(bank.size() * Math.random());
                        double amount = MAX_AMOUNT ;
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int)(DELAY ));
                    }
                }
                catch (InterruptedException e)
                {

                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
