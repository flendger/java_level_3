package lesson5.transports;

import lesson5.FuelStation;

public class Truck extends BaseTransport {

    public Truck(String number, FuelStation station) {
        super(number, 15F, 60F, station);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "number='" + super.getNumber() + '\'' +
                ", fuelConsumption=" + super.getFuelConsumption() +
                ", fuelRemaining=" + super.getFuelRemaining() +
                '}';
    }
}
