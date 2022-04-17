import java.util.ArrayList;
import java.util.Random;

public class HashMapPlayground {
    double lambda = 0.10; //beginning lambda value
    Random rand = new Random(42); //seeded rng
    
    /**
     * drives mechanism to create and print experimental data to the terminal
     * 
     * @param N size of table to test
     */
    public void printExperimentalResultsTable(int N) {
        ArrayList<ArrayList<Double>> dataList = new ArrayList<>(); //stores data to print here
        for (double i = lambda; i <= 0.9; i += .1) {
            dataList.add(dataList.size(), generateData(i, N)); //passes lambda and table size to generateData(), stores in array
        }
        printToTerminal(dataList); //sends complete data to printToTerminal() for final printing step
    }//printExperimentalResultsTable method

    /**
     * accepts an array of data and prints to terminal with appropriate format
     * each ArrayList within ArrayList contains two values, first: lambda value, second: average miss cost
     * @param data data to print
     */
    public void printToTerminal(ArrayList<ArrayList<Double>> data) {
        System.out.println(" L        Empirical   Theoretical");
        System.out.println("            ASMC         ASMC");
        for (ArrayList<Double> lineData : data) {
            double theoreticalValue = 0.5 * (1.0 + (1.0 / Math.pow((1-lineData.get(0)), 2))); //takes current lambda and calculates theoretical
            System.out.printf("%-10.1f %6.3f %11.3f\n", lineData.get(0), lineData.get(1), theoreticalValue);
        }
    }//printToTerminal method

    /**
     * generates empirical average miss cost on given lambda and table size by averagine
     * 1000 runs
     * 
     * @param lambda current lambda value
     * @param N tablesize
     * @return ArrayList with current lambda and average miss cost
     */
    public ArrayList<Double> generateData(double lambda, int N) {
        ArrayList<Double> lineData = new ArrayList<>();
        double averageCostToSearch = 0;
        for (int i = 0; i <= 1000; i++) {
            TitanProbeHashMap<Integer, Integer> mapToTest = new TitanProbeHashMap<>(N);
            for (int j = 0; j < lambda * N; j++) { //fills hashmap with lambda*N values
                mapToTest.put(rand.nextInt(), j);
            }
            averageCostToSearch += mapToTest.empiricalAverageSearchMissCost(); //combines average cost 1000x
        }
        lineData.add(0, lambda); //stores lambda in first position
        lineData.add(1, averageCostToSearch/1000); //stores average miss cost in second position
        return lineData;
    }//generateData method
}//HashMapPlayground class