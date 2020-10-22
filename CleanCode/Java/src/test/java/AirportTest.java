import plane.ExperimentalPlane;
import model.ClassificationLevels;
import model.ExperimentalTypes;
import model.MilitaryTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.Plane;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryTypes.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryTypes.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryTypes.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryTypes.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryTypes.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryTypes.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevels.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevels.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void airportHasAtLeastOneTransportMilitaryPlanesTest() {
        Assert.assertTrue(new Airport(planes).getTransportMilitaryPlanes().stream().anyMatch(militaryPlane ->
                militaryPlane.getType()==MilitaryTypes.TRANSPORT));
    }

    @Test
    public void getPassengerPlaneWithMaxCapacityTest() {
        Assert.assertTrue(new Airport(planes).getPassengerPlaneWithMaxPassengersCapacity()
                .equals(planeWithMaxPassengerCapacity));
    }

    @Test
    public void CorrectSortedPlanesByMaxLoadCapacityTest() {
        Airport airport = new Airport(planes);
        airport.setPlanes(airport.sortByMaxLoadCapacity());
        Assert.assertTrue(airport.getPlanes().stream().equals(airport.getPlanes().stream()
                .sorted(Comparator.comparingInt(Plane::getMaxLoadCapacity))));
    }

    @Test
    public void hasAtLeastOneBomberInMilitaryPlanesTest() {
        Assert.assertTrue(new Airport(planes).getTransportMilitaryPlanes().stream().anyMatch(militaryPlane ->
                militaryPlane.getType()==MilitaryTypes.BOMBER));
    }

    @Test
    public void experimentalPlanesHasClassificationLevelHigherThanUnclassifiedTest(){
        Assert.assertTrue(new Airport(planes).getExperimentalPlanes().stream().anyMatch(experimentalPlane ->
                experimentalPlane.getClassificationLevel()==ClassificationLevels.UNCLASSIFIED));
    }
}
