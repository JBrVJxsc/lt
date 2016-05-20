public class Solution {
    
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};    
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }
    
    private String helper(int n) {
        String str = "";
        if (n < 10) {
            str = belowTen[n];
        } else if (n < 20) {
            str = belowTwenty[n - 10];
        } else if (n < 100) {
            str = belowHundred[n / 10] + " " + helper(n % 10);
        } else if (n < 1000) {
            str = helper(n / 100) + " Hundred " + helper(n % 100);
        } else if (n < 1000000) {
            str = helper(n / 1000) + " Thousand " + helper(n % 1000);
        } else if (n < 1000000000) {
            str = helper(n / 1000000) + " Million " + helper(n % 1000000);
        } else {
            str = helper(n / 1000000000) + " Billion " + helper(n % 1000000000);
        }
        return str.trim();
    }
}