package lesson5.transports;

import lesson5.FuelStation;

public class Car extends BaseTransport {

    public Car(String number, FuelStation station) {
        this(number, station, 2.5F);
    }

    public Car(String number, FuelStation station, Float fuelConsumption) {
        super(number, fuelConsumption, 20F, station);
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + super.getNumber() + '\'' +
                ", fuelConsumption=" + super.getFuelConsumption() +
                ", fuelRemaining=" + super.getFuelRemaining() +
                '}';
    }
}
