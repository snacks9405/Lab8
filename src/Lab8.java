import static org.junit.Assert.assertEquals;


import org.junit.Test;
/*  
Description: Lab 8 
Author: alex rodriguez 
Date: 4.16.22
Bugs: None that I know of
Reflection: I couldn't for the life of me figure out why my numbers didn't match yours. 
for that reason alone: frustrating lab
*/ 
public class Lab8 {
    public static void main(String[] args) throws Exception {
        HashMapPlayground hm = new HashMapPlayground(); //instantiate HashMapPlayground
        hm.printExperimentalResultsTable(8192); //run results on tablesize 8192
    }//main method

    /**
     * runs a few basic tests to ensure empiricalAverageSearchMissCost() is
     * generating the appropriate values
     */
    @Test
    public void asmcTest(){
        assertEquals(1.0, TitanProbeHashMap.empiricalAverageSearchMissCost("EEEEEEEE"), 0);
        assertEquals(2.125, TitanProbeHashMap.empiricalAverageSearchMissCost("OOEEOOOE"), 0);
        assertEquals(1.25, TitanProbeHashMap.empiricalAverageSearchMissCost("EEOE"), 0);
        assertEquals(1.875, TitanProbeHashMap.empiricalAverageSearchMissCost("OOEEEOEO"), 0);
        assertEquals(1.375, TitanProbeHashMap.empiricalAverageSearchMissCost("EOEEEOEO"), 0);
    }//asmcTest method
}