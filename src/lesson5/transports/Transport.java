package lesson5.transports;

import lesson5.FuelStation;

import java.util.concurrent.Callable;

public interface Transport extends Callable<Float> {
    void drive();
    void refuel();
}
