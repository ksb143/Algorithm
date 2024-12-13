class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = 10001;
        int maxProfit = 0;
        for (int price : prices) {
            // 최저값 계속 갱신
            if (price < minPrice) {
                minPrice = price;
            }
            maxProfit = Math.max(maxProfit, price - minPrice);  // 현재 값이랑 최저값 비교
        }
        return maxProfit;
    }
}