public class TitanProbeHashMap<K, V> extends LinearProbingHashTable<K, V> {

    public TitanProbeHashMap(int capacity) {
        super(capacity);
    }

    public String toString() {
        StringBuilder sBuilder = new StringBuilder();

        for (int i = 0; i < tableSize; i++) {
            if (i % 79 == 0 && i != 0) {
                sBuilder.append("    " + i + "     \n");
            }
            sBuilder.append(keys[i] == null ? "E" : "O");
        }
        return sBuilder.toString();
    }

    public double empiricalAverageSearchMissCost() {
        double totalMissCost = 0;

        for (int i = 0; i < tableSize; i++) {
            if (keys[i] == null) {
                totalMissCost++;
            } else {
                int j = 0;
                while (keys[(i + j) % tableSize] != null && j != tableSize) {
                    totalMissCost++;
                    j++;
                }
                totalMissCost++;
            }
        }
        return totalMissCost / tableSize;
    }

    public static double empiricalAverageSearchMissCost(String str) {
        TitanProbeHashMap<Integer, Integer> stringTestMap = new TitanProbeHashMap<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'O'){
                stringTestMap.put(i, i);
            }
        }
        return stringTestMap.empiricalAverageSearchMissCost();
    }
}
