import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        System.out.printf("max of 1 and 2 is %d%n", Demo.max(1, 2));
        System.out.printf("max of 11 and 2 is %d%n", Demo.max(11, 2));
        System.out.printf("max of 11 and 2 is %d%n", Demo.max(11, 2));
        System.out.printf("max of 11, -1 and 2 is %d%n", Demo.max(11, 2, -1));

        var nitrogen = new ChemicalElement("N", -210.1f,-195.8f);
        var mercury = new ChemicalElement("Hg", -38.83f, 356.73f);
        var lead = new ChemicalElement("Pb", 327.46f, 1749f);

        List<Temperature> temperaturesToTest  = new ArrayList<Temperature>();
        temperaturesToTest.add(new Temperature(-250));
        temperaturesToTest.add(new Temperature(-200));
        temperaturesToTest.add(new Temperature(-50));
        temperaturesToTest.add(new Temperature(0));
        temperaturesToTest.add(new Temperature(333));
        temperaturesToTest.add(new Temperature(1000));
        temperaturesToTest.add(new Temperature(2000));

        for (Temperature temp: temperaturesToTest) {
            var nitrogenState = temp.getStateOfAggregationForElementByChemicalElement(nitrogen);
            var mercuryState = temp.getStateOfAggregationForElementByChemicalElement(mercury);
            var leadState = temp.getStateOfAggregationForElementByChemicalElement(lead);

            System.out.printf("On a Temperature %.2f C. Nitrogen will be %s, Mercury will be %s and Lead will be %s%n", temp.getValue(), nitrogenState, mercuryState, leadState);
        }

        List<Point> points = new ArrayList<Point>();
        points.add(new Point(1,1));
        points.add(new Point(1,-1));
        points.add(new Point(-1,1));
        points.add(new Point(-1,-1));
        points.add(new Point(0,0));

        for (Point point: points) {
            System.out.printf("Point (%d,%d) is in Quadrant %d%n", point.getX(), point.getY(), point.getQuadrant());
        }
    }
}
