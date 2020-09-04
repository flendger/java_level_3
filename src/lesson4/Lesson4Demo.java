package lesson4;

public class Lesson4Demo {
    private final Object mon = new Object();
    private final char[] chars = {'A', 'B', 'C'};
    private volatile int curCharIdx = 0; //убираем кэширование значения для переменной в разных потоках

    public static void main(String[] args) {
        Lesson4Demo l = new Lesson4Demo();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    l.printChar(finalI);
                }
            }).start();
        }
    }

    private void printChar(int idx) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (curCharIdx != idx) {
                        mon.wait();
                    }

                    System.out.print(chars[idx]);
                    curCharIdx++;
                    if (curCharIdx > 2) {
                        curCharIdx = 0;
                    }
                    //оповещаем все параллельные потоки
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
