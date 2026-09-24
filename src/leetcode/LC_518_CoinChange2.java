package leetcode;

import java.util.*;

public class LC_518_CoinChange2 {

    private static final LC_518_CoinChange2 lc518CoinChange2 = new LC_518_CoinChange2();

    public static void main(String[] args) {

        //constraints
//        1 <= coins.length <= 300
//        1 <= coins[i] <= 5000
//        All the values of coins are unique.
//        0 <= amount <= 5000

        executeTest(5, new int[]{1, 2, 5}, 4);
        executeTest(3, new int[]{2}, 0);
        executeTest(10, new int[]{10}, 1);
        //edge tests
        executeTest(0, new int[]{1}, 1);

        //full limit of 300 different coins
        int[] arrayOf300Coins = new int[300];
        arrayOf300Coins[0] = 1;
        arrayOf300Coins[1] = 2;
        arrayOf300Coins[2] = 4;
        arrayOf300Coins[3] = 8;
        arrayOf300Coins[4] = 16;
        arrayOf300Coins[5] = 32;
        arrayOf300Coins[6] = 64;
        arrayOf300Coins[7] = 128;
        arrayOf300Coins[8] = 256;
        arrayOf300Coins[9] = 512;
        arrayOf300Coins[10] = 1024;
        arrayOf300Coins[11] = 2048;
        arrayOf300Coins[12] = 4096;
        arrayOf300Coins[13] = 5000;
        for (int i = 14; i < arrayOf300Coins.length; i++) {
            arrayOf300Coins[i] = 4096 + i;
        }
        executeTest(5000, arrayOf300Coins, -1);
    }

    private static void executeTest(int amount, int[] coins, int expectedRes) {
        long startMillis = System.currentTimeMillis();
        int res = lc518CoinChange2.change(amount, coins);
        long endMillis = System.currentTimeMillis();
        System.out.println(res +  " - (" + (endMillis-startMillis) + "ms) "
                + (res == expectedRes ? "PASS" : "FAIL (expected " + expectedRes + ")"));
    }

    public int change(int amount, int[] coins) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        //add empty option to facilitate
        allCombinations.add(new ArrayList<>());

        int[] sortedCoins = Arrays.stream(coins).sorted().toArray();

        //start from the highest coin
        for (int i = sortedCoins.length-1; i >= 0; i--) {
            int coin = sortedCoins[i];
            if (coin == amount) {
                allCombinations.add(List.of(coin));
            } else if(coin < amount) {
                boolean isNewCombination = true;
                while (isNewCombination) {
                    isNewCombination = false;
                    List<List<Integer>> newCombinations = new ArrayList<>();

                    long startMillis = System.currentTimeMillis();

                    for (List<Integer> comb : allCombinations) {
                        //new list as a copy of the existing one
                        List<Integer> newComb = new ArrayList<>(comb);
                        Integer currSum = newComb.stream().reduce(Integer::sum).orElse(0);
                        if (currSum + coin <= amount) {
                            newComb.add(coin);
                            if (!allCombinations.contains(newComb)) {
                                newCombinations.add(newComb);
                                isNewCombination = true;
                            }
                        }
                    }

                    long endMillis = System.currentTimeMillis();
                    System.out.println("Coin: " + coin + ", " + (endMillis-startMillis) +  "ms");

                    if (isNewCombination) {
                        allCombinations.addAll(newCombinations);
                    }
                }
            }
            // coins > amount = ignored
        }

        return (int) allCombinations.stream()
                .map(list -> list.stream().reduce(Integer::sum).orElse(0))
                .filter(calculatedSum -> calculatedSum == amount)
                .count();
    }

}
