import java.util.Arrays;
import java.util.Set;

public class ArrayUtils {
    static int[] sortArray(int[] a) {
        Arrays.sort(a);
        return a;
    }

    public static void print(int [] a){
        System.out.println(Arrays.toString(a));
    }

    static int[] hashSetToArray(Set hashSet) {
        int hashSetSize = hashSet.size();
        int[]array = new int[hashSetSize];
        int i = 0;
        for (Object leader: hashSet){
            array[i++] = (int)leader;
        }
        return array;
    }
}
