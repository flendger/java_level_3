package lesson5.transports;

import java.util.concurrent.Callable;

public interface Transport extends Callable<Float> {
    void drive();
    void refuel();
}
