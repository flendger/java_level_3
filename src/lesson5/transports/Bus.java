package lesson5.transports;

import lesson5.FuelStation;

public class Bus extends BaseTransport {

    public Bus(String number, FuelStation station) {
        super(number, 7.5F, 40F, station);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "number='" + super.getNumber() + '\'' +
                ", fuelConsumption=" + super.getFuelConsumption() +
                ", fuelRemaining=" + super.getFuelRemaining() +
                '}';
    }
}
