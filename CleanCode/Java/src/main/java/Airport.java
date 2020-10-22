// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

import plane.ExperimentalPlane;
import model.MilitaryTypes;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return (List<PassengerPlane>) this.planes.stream().filter(plane->plane instanceof PassengerPlane)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return (List<MilitaryPlane>) this.planes.stream().filter(plane->plane instanceof MilitaryPlane)
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return (List<ExperimentalPlane>) this.planes.stream().filter(plane->plane instanceof ExperimentalPlane)
                .collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return (PassengerPlane) getPassengerPlanes().stream().sorted(Comparator
                .comparingInt(PassengerPlane::getPassengersCapacity)).limit(1);
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return (List<MilitaryPlane>) getMilitaryPlanes().stream()
                .filter(plane->plane.getType()==MilitaryTypes.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return (List<MilitaryPlane>) getMilitaryPlanes().stream()
                .filter(plane->plane.getType()==MilitaryTypes.BOMBER);

    }

    public List<Plane> sortByMaxDistance() {
        return planes.stream().sorted(Comparator.comparingInt(Plane::getMaxFlightDistance)).collect(Collectors.toList());
    }

    public List<Plane> sortByMaxSpeed() {
        return planes.stream().sorted(Comparator.comparingInt(Plane::getMaxSpeed)).collect(Collectors.toList());
    }

    public List<Plane> sortByMaxLoadCapacity() {
        return planes.stream().sorted(Comparator.comparingInt(Plane::getMaxLoadCapacity)).collect(Collectors.toList());

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Airport{").append("Planes=").append(planes.toString()).append(+'}');
        return stringBuilder.toString();
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<? extends Plane> planes) {
        this.planes=planes;
    }
}
