
public class Lab8 {
    public static void main(String[] args) throws Exception {
        TitanProbeHashMap tm = new TitanProbeHashMap<>(8);
        tm.put(0, 0);
        tm.put(1, 1);
        tm.put(4, 0);
        tm.put(5, 5);
        tm.put(6, 6);
        System.out.println(tm.empiricalAverageSearchMissCost());

        HashMapPlayground hm = new HashMapPlayground();
        hm.printExperimentalResultsTable(8192);
    }
}