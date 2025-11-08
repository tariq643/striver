package dsa.striver.greedyalgorithms;

import java.util.Arrays;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        //Arrays.sort(bills);

        int noOfFive = 0, noOfTen = 0;

        for (int i = 0; i < bills.length; i++) {

            if (bills[i] == 5) {
                noOfFive = noOfFive + 1;
            }
            else if (bills[i] == 10) {
                if (noOfFive > 0) {
                    noOfFive = noOfFive - 1;
                }
                else {
                    return false;
                }
                noOfTen = noOfTen + 1;
            }
            else {
                if (noOfFive > 0 && noOfTen > 0) {
                    noOfFive = noOfFive - 1;
                    noOfTen = noOfTen - 1;
                }
                else if (noOfFive >= 3) {
                    noOfFive = noOfFive - 3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        LemonadeChange lemonadeChange = new LemonadeChange();
        int bills[] = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange.lemonadeChange(bills));
    }
}
