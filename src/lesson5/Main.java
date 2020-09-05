package lesson5;

import lesson5.transports.Bus;
import lesson5.transports.Car;
import lesson5.transports.Transport;
import lesson5.transports.Truck;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        FuelStation station = new FuelStation();

        List<Transport> transports = new ArrayList<>();
        transports.add(new Car("a111aa", station));
        transports.add(new Truck("b222bb", station));
        transports.add(new Truck("b666bb", station));
        transports.add(new Bus("c333cc", station));
        transports.add(new Car("a444aa", station, 2.0F));
        transports.add(new Car("a555aa", station, 1.5F));

        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            executorService.invokeAll(transports);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
