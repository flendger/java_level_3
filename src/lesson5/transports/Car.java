package lesson5.transports;

import lesson5.FuelStation;

public class Car extends BaseTransport {

    public Car(String number, FuelStation station) {
        super(number, 2.5F, 20F, station);
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
