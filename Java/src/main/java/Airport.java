import planes.ExperimentalPlane;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = planes.stream()
                .filter(x -> x instanceof PassengerPlane)
                .map(x -> (PassengerPlane) x).collect(Collectors.toList());

        return passengerPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = planes.stream()
                .filter(x -> x instanceof ExperimentalPlane)
                .map(x -> (ExperimentalPlane) x).collect(Collectors.toList());

        return experimentalPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = planes.stream()
                .filter(x -> x instanceof MilitaryPlane)
                .map(x -> (MilitaryPlane) x).collect(Collectors.toList());

        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        PassengerPlane planeWithMaxCapacity = getPassengerPlanes().stream().max(Comparator.
                comparing(PassengerPlane::getPassengersCapacity)).get();

        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = getMilitaryPlanes().stream()
                .filter(x -> x.getType() == MilitaryType.TRANSPORT)
                .collect(Collectors.toList());

        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = getMilitaryPlanes().stream()
                .filter(x -> x.getType() == MilitaryType.BOMBER)
                .collect(Collectors.toList());

        return bomberMilitaryPlanes;

    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
        return this;
    }

    @Override
    public String toString() {
        return "Airport{\n" +
                "Planes=" + planes.toString() +
                "\n}";
    }

}
