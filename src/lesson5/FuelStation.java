package lesson5;

import lesson5.transports.Transport;

import java.util.concurrent.Semaphore;

public class FuelStation {
    private final Semaphore semaphore = new Semaphore(3, true);

    public void getFuel(Transport  transport) {
        try {
            semaphore.acquire();
            System.out.println(transport.toString() + " started refueling...");
            Thread.sleep(7000);
            System.out.println(transport.toString() + " has refueled...");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
