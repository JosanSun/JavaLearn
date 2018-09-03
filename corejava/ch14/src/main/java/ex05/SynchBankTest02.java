package ex05;

/**
 * @Author : zs.sun
 * @Date : 2018/8/16 10:53
 * @Package : ex03
 * @ProjectName: corejava
 * @Description: This program shows data corruption when multiple threads access a data structure.
 */
public class SynchBankTest02 {
    public static final int NACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 100;
    public static final double MAX_AMOUNT = 100;
    public static final int DELAY = 1000;

    public static void main(String[] args) {
        BankSynchBlock bank = new BankSynchBlock(NACCOUNTS, INITIAL_BALANCE);
        System.out.println("The bank has total balance is: " + bank.getTotalBalance());
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () ->{
                try
                {
                    while(true)
                    {
                        int toAccount = (int)(bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, 10);
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
