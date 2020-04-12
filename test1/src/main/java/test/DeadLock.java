package test;

public class DeadLock {
    private String a="a";
    private String b="b";

    class A implements Runnable{
        public void run(){
            while(true){
                synchronized(a){
                    System.out.println("lock a");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(b){
                        System.out.println("lock b");
                    }
                }
            }

        }
    }


    class B implements Runnable{
        public void run(){
            while(true){
                synchronized(b){
                    System.out.println("lock b");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(a){
                        System.out.println("lock a");
                    }
                }
            }

        }
    }
}
