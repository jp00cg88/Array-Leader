public class DomainValidation {
    static void validateElementDomain(int k, int m, int[] sortedArray) {
        int n = sortedArray.length;
        validateLenghtArrayN(n, sortedArray);
        validateRangeM(m);
        validateLenghtArrayModificationsK(n, k, sortedArray);
        validateLenghtElementsM(n, m, sortedArray);
    }

    private static void validateLenghtArrayN(int n, int[] sortedArray){
        if (sortedArray[n-1] < 1 || sortedArray[n-1] > 100000){
            throw new RuntimeException("N value is out of range [1..100,000]");
        }
    }

    private static void validateRangeM(int m){
        if (m < 1 || m > 100000){
            throw new RuntimeException("M value is out of range [1..100,000]");
        }
    }

    private static void validateLenghtArrayModificationsK(int n, int k, int[] sortedArray){
        if (k < 1 || k > n-1){
            throw new RuntimeException("K value is out of range [1..n]");
        }
    }

    private static void validateLenghtElementsM(int n, int m, int[] sortedArray){
        if (sortedArray[n-1] < 1 || sortedArray[n-1] > m){
            throw new RuntimeException("Array elements are out of range [1..M]");
        }
    }
}
