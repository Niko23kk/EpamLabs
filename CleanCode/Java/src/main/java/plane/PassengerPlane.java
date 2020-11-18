package plane;

import java.util.Objects;

public class PassengerPlane extends Plane{

    private int passengersCapacity;

    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder(super.toString());
        stringBuilder.replace(stringBuilder.indexOf("}"),stringBuilder.indexOf("}")+1,", passengersCapacity=" +
                passengersCapacity +'}');
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PassengerPlane)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return passengersCapacity == ((PassengerPlane) o).passengersCapacity;
    }
}
