import java.util.Scanner;

public class TalsTests {
    public static void main (String[]args){
        //array init
        int[]a1={17, 62, 19, 10, 1, 78, 20, 20, 20, 10};
        int[]a2={1,1,2,14,15,16,23,99,100,100,100,132,193,196,197};
        int toSearch=13;

        //2a
        //System.out.println("the index of "+toSearch+" is: "+Warmup.backtrackingSearch(a1,toSearch,3,2,new Stack()));

        //2b
        System.out.println("the index of "+toSearch+" is: "+Warmup.consistentBinSearch(a2,toSearch,new Stack()));
    }
}
