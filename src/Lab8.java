
public class Lab8 {
    public static void main(String[] args) throws Exception {
        TitanProbeHashMap<Integer,String> tm = new TitanProbeHashMap<>();

        for(int i = 0; i<200; i+=2){
            tm.put(i, Integer.toString(i));
        }
        System.out.println(tm.toString());
    }
}
