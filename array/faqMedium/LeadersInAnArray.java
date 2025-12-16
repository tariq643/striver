package dsa.striver.array.faqMedium;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInAnArray {

    public ArrayList<Integer> leaders(int[] nums) {

        int n = nums.length, maxElement = nums[n-1];
        ArrayList<Integer> leaders = new ArrayList<>();
        leaders.add(maxElement);
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] > maxElement) {
                leaders.add(nums[i]);
                maxElement = nums[i];
            }
        }
        Collections.reverse(leaders);
//        leaders.forEach(System.out::println);
        return leaders;
    }

    public static void main(String[] args) {

        LeadersInAnArray leadersInAnArray = new LeadersInAnArray();
        int nums[] = {1, 2, 5, 3, 1, 2};
        leadersInAnArray.leaders(nums);
    }
}
