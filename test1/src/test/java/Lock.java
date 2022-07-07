import java.util.concurrent.CountDownLatch;

public class Lock {
    static volatile  int  s =1;
    public synchronized  boolean getLock(String name)  {
        while(s==0){
            try {
                System.out.println(name+"-->wait");
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        s--;
        System.out.println(name+"-->lock");
        return true;
    }

    public synchronized boolean unLock(String name){
        s++;
        this.notifyAll();
        System.out.println(name+"-->unlock");
        return true;
    }

    public static void main(String[] args) {
        CountDownLatch c = new CountDownLatch(2);
        Lock lock = new Lock();
        Thread t1 =new Thread(()->{
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
                while (true){
                    try {
                        if(lock.getLock("t1"))
                            System.out.println("t1");
                        lock.unLock("t1");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


        });
        Thread t2 =new Thread(()->{
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            while (true){
                try {
                    if(lock.getLock("t2"))
                        System.out.println("t2");
                    lock.unLock("t2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        t1.start();
        c.countDown();
        t2.start();
        c.countDown();

    }
}
