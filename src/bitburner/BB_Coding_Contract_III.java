package bitburner;

public class BB_Coding_Contract_III {

    /*
    *
    * */

    /*
    
    You are attempting to solve a Coding Contract. You have 10 tries remaining, after which the contract will self-destruct.

    You are given the following array of stock prices (which are numbers) where the i-th element represents the stock price on day i:

    63,112,1,125,57,94,69,10,173,12,119,23

    Determine the maximum possible profit you can earn using at most two transactions.
    A transaction is defined as buying and then selling one share of the stock.
    Note that you cannot engage in multiple transactions at once.
    In other words, you must sell the stock before you buy it again.

    If no profit can be made, then the answer should be 0.

    If your solution is an empty string, you must leave the text box empty. Do not use "", '', or ``.
     */

    public static void main(String[] args) {
        int[] stockPrices = new int[]{63,112,1,125,57,94,69,10,173,12,119,23};
        int maxProfit = maxProfit(stockPrices);
        System.out.println(maxProfit);
    }
    
    private static int maxProfit(int[] stockPrices) {
        
        int finalMaxProfit = 0;
        
        // single window slide with variable end point
        int start = 0;
        int end = stockPrices.length;
        int maxProfit = getMaxProfitInWindow(stockPrices, start, end);
        if (maxProfit > finalMaxProfit) {
            finalMaxProfit = maxProfit;
        }

        // double window slide with variable end point
        // here we move the intersection point between two windows
        // and sum their profits to get the max profit over two buy/sell actions

        //start = 0;
        //end = stockPrices.length;
        // windowA starts with width 2
        // windowB ends with width 2
        int doubleWindowMaxProfit = 0;
        for (int i = start+2; i < end-1; i++) {
            int maxProfitWindowA = getMaxProfitInWindow(stockPrices, start, i);
            int maxProfitWindowB = getMaxProfitInWindow(stockPrices, i, end);
            int profit = maxProfitWindowA + maxProfitWindowB;
            if (profit > doubleWindowMaxProfit) {
                doubleWindowMaxProfit = profit;
            }
        }

        if (doubleWindowMaxProfit > finalMaxProfit) {
            finalMaxProfit = doubleWindowMaxProfit;
        }

        return finalMaxProfit;
    }

    private static int getMaxProfitInWindow(int[] stockPrices, int start, int end) {
        int profit = -stockPrices[start];
        int maxProfit = profit;
        for (int j = start; j < end -1; j++) {
            profit = -stockPrices[j];
            for (int i = j+1; i < end; i++) {
                int prevStock = (i-1) > j ? stockPrices[i-1] : 0;
                profit += stockPrices[i] - prevStock;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

}
