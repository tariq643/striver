package dsa.striver.array;

import java.util.ArrayList;
import java.util.List;

public class PrintArraySumEqualsK {

    static void main() {

        int arr[] = {1,2,3,4,5}, k = 9;
        int n = arr.length, sum;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sum = 0;
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
                temp.add(arr[j]);
                if (sum == k) {
                    result.add(temp);
                    break;
                }
            }
        }
        result.forEach(System.out::println);
    }
}
