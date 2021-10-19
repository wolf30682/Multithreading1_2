package Multithreading1_2;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {

    private int maxCountMessages;
    private int currentCountMessages = 0;

    public void setCurrentCountMessages(int currentCountMessages) {
        this.currentCountMessages = currentCountMessages;
    }

    public MyCallable(int maxCountMessages) {
        this.maxCountMessages = maxCountMessages;
    }

    public Integer call() throws Exception {
        for (int i= maxCountMessages; i>0; i--){
            Thread.sleep(2500);
            currentCountMessages++;
            System.out.printf("Я %s. Сообщение № %d: Всем привет!\n", Thread.currentThread().getName(), currentCountMessages);
        }

        return currentCountMessages;
    }
}
