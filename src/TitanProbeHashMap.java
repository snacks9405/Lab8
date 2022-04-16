
public class TitanProbeHashMap<K, V> extends LinearProbingHashTable<K, V> {

    public TitanProbeHashMap(int capacity) {
        tableSize = capacity;
        size = 0;
        keys = (K[]) new Object[tableSize];
        values = (V[]) new Object[tableSize];
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
                int k = 0;
                while (keys[(i + k) % tableSize] != null && k != tableSize) {
                    totalMissCost++;
                    k++;
                }
                if (k == tableSize) {
                    totalMissCost++;
                }
            }
        }
        return totalMissCost / tableSize;
    }

    public static double empiricalAverageSearchMissCost(String str) {
        char[] charArray = str.toCharArray();
        double totalMissCost = 0;

        for (int i = 0; i < str.length(); i++) {
            int index = i;
            if (charArray[i] == 'E'){
                totalMissCost++;
            } else {
                totalMissCost++;
                while (charArray[index] != 'E' || index + 1 == i) {
                    totalMissCost++;
                    index++;
                }
            }
        }
        return totalMissCost / str.length();
    }
}
