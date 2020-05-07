import java.util.HashSet;
import java.util.Set;

public class ArrayLeader {

    public static void main(String[] args) {
        int k = 2;
        int m = 4;
        int[] a = {1,2,2,3,3,3,4,4,4,4};
        ArrayUtils.print(solution(k,m,a));
    }

    public static int[] solution (int k, int m, int [] a){
        int [] sortedArray = ArrayUtils.sortArray(a);
        DomainValidation.validateElementDomain(k, m, sortedArray);
        return segmentLeaders(sortedArray,k);
    }

    private static int[] segmentLeaders(int[] sortedArray, int k) {
        Set leadersHashSet = new HashSet<>();
        int sortedArrayLength = sortedArray.length;
        int [] segment = new int [sortedArrayLength];
        int segmentLength = segment.length;
        int i = 0;
        while (i + k <= segmentLength){
            System.arraycopy(sortedArray,0,segment,0,sortedArrayLength);
            int count = 0;
            for (int j = i; j < segmentLength && count < k; j++){
                segment[j] = segment[j] + 1;
                count++;
            }
            i++;
            int segmentLeader = findLeaders(segment);
            if (segmentLeader > 0){
                leadersHashSet.add(segmentLeader);
            }
        }
        return ArrayUtils.hashSetToArray(leadersHashSet);
    }
    
    private static int findLeaders(int[] segment) {
        int [] sortedSegment = ArrayUtils.sortArray(segment);
        int segmentSize = sortedSegment.length;
        int size = 0;
        int value = 0;
        int candidate = -1;
        int leader = -1;
        int count = 0;
        for (int k : sortedSegment){
            if (size == 0){
                size += 1;
                value = sortedSegment[k];
            }else if (value != sortedSegment[k]){
                size -= 1;
            }else{
                size += 1;
            }
        }
        if (size > 0){
            candidate = value;
        }
        for (int k : sortedSegment){
            if (sortedSegment[k] == candidate){
                count += 1;
            }
        }
        if (count > segmentSize/2){
            leader = candidate;
        }
        return leader;
    }

}
