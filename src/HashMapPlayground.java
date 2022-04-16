import java.util.ArrayList;
import java.util.Random;

public class HashMapPlayground {
    double lambda = 0.10;
    Random rand = new Random(42);
    

    public void printExperimentalResultsTable(int N) {
        ArrayList<ArrayList<Double>> dataList = new ArrayList<>();
        for (double i = lambda; i <= 0.9; i += .1) {
            dataList.add(dataList.size(), generateData(i, N));
        }
        printToTerminal(dataList);
    }

    public void printToTerminal(ArrayList<ArrayList<Double>> values) {
        System.out.println(" L        Empirical   Theoretical");
        System.out.println("            ASMC         ASMC");
        for (ArrayList<Double> lineData : values) {
            double theoreticalValue = 0.5 * (1.0 + (1.0 / Math.pow((1-lineData.get(0)), 2)));
            System.out.printf("%-10.1f %6.3f %11.3f\n", lineData.get(0), lineData.get(1), theoreticalValue);
        }
    }

    public ArrayList<Double> generateData(double lambda, int N) {
        ArrayList<Double> lineData = new ArrayList<>();
        double averageCostToSearch = 0;
        for (int i = 0; i <= 1000; i++) {
            TitanProbeHashMap<Integer, Integer> mapToTest = new TitanProbeHashMap<>(N);
            for (int j = 0; j < lambda * N; j++) {
                mapToTest.put(rand.nextInt(), j);
            }
            averageCostToSearch += mapToTest.empiricalAverageSearchMissCost();
        }
        lineData.add(0, lambda);
        lineData.add(1, averageCostToSearch/1000);
        return lineData;
    }
}