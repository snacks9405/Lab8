public class TitanProbeHashMap<K, V> extends LinearProbingHashTable<K, V> {

    /**
     * constructor to include capacity specification
     * 
     * @param capacity
     */
    public TitanProbeHashMap(int capacity) {
        super(capacity);
    }//TitanProbeHashMap constructor

    /**
     * returns a string representing the hashmap with empty cells : E and 
     * occupied cells : O
     */
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < tableSize; i++) {
            if (i % 79 == 0 && i != 0) {
                sBuilder.append("\n"); //new line every 80 cells
            }
            sBuilder.append(keys[i] == null ? "E" : "O");  //E if empty, O if full
        }
        return sBuilder.toString();
    }//toString method

    /**
     * calculates average search miss cost of a hashmap by 
     * iterating through and calculating each cells cost, then 
     * averaging them against table size
     * 
     * @return average search miss cost
     */
    public double empiricalAverageSearchMissCost() {
        double totalMissCost = 0;
        for (int i = 0; i < tableSize; i++) {
            if (keys[i] == null) {
                totalMissCost++; //if cell is empty, cost is 1
            } else {
                int j = 0;
                while (keys[(i + j) % tableSize] != null && j != tableSize) {
                    totalMissCost++; //if cell is not empty, iterate until you find an empty one or complete a circuit of the map
                    j++; 
                }
                totalMissCost++;
            }
        }
        return totalMissCost / tableSize; //total / tablesize to return average
    }//empiricalAverageSearchMissCost method

    /**
     * translates a string into a hashmap and then calls empiricalAverageSearchMissCost()
     * to get the average miss cost
     * 
     * @param str string to calculate miss cost
     * @return miss cost
     */
    public static double empiricalAverageSearchMissCost(String str) {
        TitanProbeHashMap<Integer, Integer> stringTestMap = new TitanProbeHashMap<>(str.length());
        char full = 'O'; //full character is O
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == full){ //if it's full put it into the map
                stringTestMap.put(i, i);
            }
        }
        return stringTestMap.empiricalAverageSearchMissCost();
    }//empiricalAverageSearchMissCost
}//TitanProbeHashMap class