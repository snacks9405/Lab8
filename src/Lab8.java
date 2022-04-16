import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class Lab8 {
    public static void main(String[] args) throws Exception {
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