package dsa.striver.dynamicProgramming.DPOnStocks;

public class BestTimeToBuySellStock {

    public int stockBuySell(int[] arr, int n) {

        int minPrice = Integer.MAX_VALUE, maxProfit = 0, currentProfit = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < minPrice) {
                minPrice = arr[i];
            }
            else {
                currentProfit = arr[i] - minPrice;
                maxProfit = currentProfit > maxProfit ? currentProfit : maxProfit;
            }
        }
        return maxProfit;
    }
}
