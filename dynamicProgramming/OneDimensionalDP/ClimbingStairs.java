package dsa.striver.dynamicProgramming.OneDimensionalDP;

public class ClimbingStairs {

    public int climbStairs(int n) {

        if (n==1) return 1;
        if (n==2) return 2;

        int current=0, first =1, second=2;
        for (int i = 2; i < n; i++) {
            current = first + second;
            first = second;
            second = current;
        }
        return current;
    }

    public static void main(String[] args) {

    }
}
