package lesson5;

import lesson5.transports.Transport;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FuelStation {
    private float fuelCapacity = 100F;
    private final Semaphore semaphore = new Semaphore(3, true);
    private final Lock lock = new ReentrantLock(true);

    public void getFuel(Transport  transport) {
        try {
            semaphore.acquire();
            float carCapacity = transport.getFuelCapacity();

//            lock.lock();
            if (carCapacity <= this.fuelCapacity) {
                fuelCapacity -= carCapacity;
//                lock.unlock();

                System.out.println(transport.toString() + " started refueling...");
                Thread.sleep(7000);
//                lock.lock();
                System.out.println(String.format("%s has refueled... FuelStation current capacity is: %.2f", transport.toString(), fuelCapacity));
//                lock.unlock();
            } else {
//                lock.unlock();
                System.out.println(String.format("%s cannot be refueled... FuelStation current capacity is: %.2f", transport.toString(), this.fuelCapacity));
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }
}
