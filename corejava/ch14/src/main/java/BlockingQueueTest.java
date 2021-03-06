/**
 * @Author : zs.sun
 * @Date : 2018/8/19 9:57
 * @Package : PACKAGE_NAME
 * @ProjectName: corejava
 * @Description:
 */

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
    //生产者
    public static class Producer implements Runnable{
        private final BlockingQueue<Integer> blockingQueue;
        private volatile boolean flag;
        private Random random;
        private volatile int cnt;

        public Producer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
            flag=false;
            random=new Random();
            cnt = 0;
        }

        @Override
        public void run() {
            while(!flag){
                int info=random.nextInt(100);
                try {
                    blockingQueue.put(info);
                    ++cnt;
                    System.out.println(Thread.currentThread().getName()+" produce "+info+
                            " And "+Thread.currentThread().getName()+" has produced "+cnt+" items!");
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        public void shutDown(){
            flag=true;
        }
    }
    //消费者
    public static class Consumer implements Runnable{
        private final BlockingQueue<Integer> blockingQueue;
        private volatile boolean flag;
        private volatile int  cnt;
        public Consumer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while(!flag){
                int info;
                try {
                    info = blockingQueue.take();
                    ++cnt;
                    System.out.println(Thread.currentThread().getName()+" consumer "+info+
                            " And "+Thread.currentThread().getName()+" has consumed "+cnt+" items!");
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        public void shutDown(){
            flag=true;
        }
    }
    public static void main(String[] args){
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(10);
        Producer producer=new Producer(blockingQueue);
        Consumer consumer=new Consumer(blockingQueue);
        //创建5个生产者，5个消费者
        for(int i=0;i<10;i++){
            if(i<5){
                new Thread(producer,"producer"+i).start();
            }else{
                new Thread(consumer,"consumer"+(i-5)).start();
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        producer.shutDown();
        consumer.shutDown();

    }
}
