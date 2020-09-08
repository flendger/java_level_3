package lesson5.transports;

public interface Transport extends Runnable {
    void drive();
    void refuel();
    Float getFuelCapacity();
}
