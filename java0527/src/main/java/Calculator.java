import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Calculator
{
    public Calculator() {}
    // Sum of A n B
    public int intersection(int[] A, int[] B)
    {
        int result = 0;
        // todo
        Set<Integer> set = new HashSet();
        for(int num:A){
            set.add(num);
        }
        for(int num:B){
            if(set.contains(num)){
                result+=num;
            }
        }
        return result;
    }

    // Sum of A - B
    public int differenceOfSet(int[] A, int[] B)
    {
        int result = 0;
        // todo
        Set<Integer> set = new HashSet();
        for(int num:B){
            set.add(num);
        }
        for(int num:A){
            if(!set.contains(num)){
                result+=num;
            }
        }
        return result;
    }
}