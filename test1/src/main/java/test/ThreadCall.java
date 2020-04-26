package test;

public class ThreadCall implements Runnable {
    private static  int count =0;
    private int id;
    ThreadCall(int i){
        id =i;
    }
    @Override
    public void run() {
        synchronized ("wq"){
            for(;;){
                if(count%2==id){
                    System.out.println(count+"   ===="+id);
                    count++;
                    "wq".notifyAll();
                    if(count>=100){
                        break;
                    }else{
                        try {
                            "wq".wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("关闭应用，释放资源");
        }));
        new Thread(new ThreadCall(0)).start();
        new Thread(new ThreadCall(1)).start();
    }
}
