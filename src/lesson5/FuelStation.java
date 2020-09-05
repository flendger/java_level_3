package lesson5;

import java.util.concurrent.Semaphore;
import lesson5.transports.Transport;

public class FuelStation {
    private final Semaphore semaphore;

    public FuelStation(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void getFuel(Transport  transport) {
        try {
            semaphore.acquire();
            System.out.println(transport.toString() + " started refueling...");
            Thread.sleep(5000);
            System.out.println(transport.toString() + " has refueled...");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
