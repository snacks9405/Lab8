

public class TitanProbeHashMap<K,V> extends LinearProbingHashTable<K,V> {

    public String toString(){
        StringBuilder sBuilder = new StringBuilder();

        for (int i = 0; i < tableSize; i++) {
            if (i % 79 == 0 && i != 0) {
                sBuilder.append("\n");
            }
            sBuilder.append(keys[i] == null ? "E" : "O");
        }
        return sBuilder.toString();
    }
}
