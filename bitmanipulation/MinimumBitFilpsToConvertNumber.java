package dsa.striver.bitmanipulation;

public class MinimumBitFilpsToConvertNumber {

    public int minBitsFlip(int start, int goal) {

        int xorNumber = start ^ goal, count = 0;
        while (xorNumber > 0) {
            count = count + xorNumber % 2;
            xorNumber = xorNumber >> 1;
        }
        return count;
    }
}
