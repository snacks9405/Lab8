import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lab8 {
    public static void main(String[] args) throws Exception {
        TitanProbeHashMap tm = new TitanProbeHashMap<>(8);
        tm.put(0, 0);
        tm.put(1, 1);
        tm.put(4, 0);
        tm.put(5, 5);
        tm.put(6, 6);
        System.out.println(tm.empiricalAverageSearchMissCost());
        System.out.println(TitanProbeHashMap.empiricalAverageSearchMissCost(tm.toString()));

        HashMapPlayground hm = new HashMapPlayground();
        hm.printExperimentalResultsTable(8192);
    }

    @Test
    public void asmcTest(){
        assertEquals(1.0, TitanProbeHashMap.empiricalAverageSearchMissCost("EEEEEEEE"), 0);
        assertEquals(2.125, TitanProbeHashMap.empiricalAverageSearchMissCost("OOEEOOOE"), 0);
        assertEquals(1.25, TitanProbeHashMap.empiricalAverageSearchMissCost("EEOE"), 0);
        assertEquals(1.875, TitanProbeHashMap.empiricalAverageSearchMissCost("OOEEEOEO"), 0);
        assertEquals(1.375, TitanProbeHashMap.empiricalAverageSearchMissCost("EOEEEOEO"), 0);
    }
}