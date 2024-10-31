import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){

    }

    public int minTransactions(int[][] transactions){
        Map<Integer,Integer> memberVsBalanceMap = new HashMap<>();
        // compute the overall balance (incoming - outgoing) for each member
        for(int[] transaction : transactions){
            int from = transaction[0];
            int to = transaction[1];
            int amount = transaction[2];

            memberVsBalanceMap.put(from,memberVsBalanceMap.getOrDefault(from,0) - amount);
            memberVsBalanceMap.put(to,memberVsBalanceMap.getOrDefault(to,0) + amount);
        }

        List<Integer> balances = new ArrayList<>();
        for(int balance : memberVsBalanceMap.values()){
            if(balance!=0){
                balances.add(balance);
            }
        }

        return dfs(balances,0);
    }

    private int dfs(List<Integer> balances,int currentIndex){

        if(balances.size()==0 || currentIndex >= balances.size()) return 0;

        if(balances.get(currentIndex)==0){
            return dfs(balances,currentIndex + 1);
        }

        int currVal = balances.get(currentIndex);
        int minTrxnCount = Integer.MAX_VALUE;

        for(int trxnIndex = currentIndex + 1; trxnIndex < balances.size(); trxnIndex++){

            int nextVal =  balances.get(trxnIndex);

            if(currVal * nextVal < 0){
                balances.set(trxnIndex,nextVal + currVal);
                minTrxnCount = Math.min(minTrxnCount,1 + dfs(balances,currentIndex + 1));
                balances.set(trxnIndex,nextVal);

                if(currVal + nextVal == 0) break;
            }
        }

        return minTrxnCount;
    }
}
