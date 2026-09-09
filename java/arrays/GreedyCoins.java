import java.util.HashMap;
import java.util.Map;

public class GreedyCoins {
    public static void main(String[] args) {
        int returnAmount = 87;

        for (Map.Entry<Integer, Integer> e : minCoins(returnAmount).entrySet()) {
            System.out.println(e.getKey() + "->" + e.getValue());
        }
    }

    private static Map<Integer, Integer> minCoins(int returnAmount) {
        int coinCount = 0;
        int[] coins = {25, 10, 5, 1};
        Map<Integer,Integer> countMap = new HashMap<>();
        

        for (int coin : coins) {
            coinCount += returnAmount / coin;
            returnAmount = returnAmount % coin;
            countMap.put(coin, coinCount);
        }

        return countMap;
    }
}
