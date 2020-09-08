package lesson5.transports;

import lesson5.FuelStation;

public abstract class BaseTransport implements Transport {
    private final String number;
    private final float fuelConsumption;
    private float fuelRemaining;
    private final float fuelCapacity;
    private final FuelStation station;

    public BaseTransport(String number, float fuelConsumption, float fuelCapacity, FuelStation station) {
        this.number = number;
        this.fuelConsumption = fuelConsumption;
        this.fuelRemaining = fuelCapacity;
        this.fuelCapacity = fuelCapacity;
        this.station = station;
    }

    public Float getFuelCapacity() {
        return fuelCapacity;
    }

    protected String getNumber() {
        return number;
    }

    protected float getFuelConsumption() {
        return fuelConsumption;
    }

    protected float getFuelRemaining() {
        return fuelRemaining;
    }

    @Override
    public void drive() {
        System.out.println(this.toString() + " started driving...");
        while (fuelRemaining > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            fuelRemaining -= Math.min(fuelConsumption, fuelRemaining);
//            System.out.println(String.format("%s fuel remain: %.02f", this.toString(), fuelRemaining));
        }
        System.out.println(this.toString() + " stopped...");
    }

    @Override
    public void refuel() {
        station.getFuel(this);
        fuelRemaining = fuelCapacity;
    }

    @Override
    public void run() {
        drive();
        refuel();
    }

}
