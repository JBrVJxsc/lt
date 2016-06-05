public class Solution {
  
//   public static void main(String[] args) {
//     System.out.println(new Solution().multiply("1234", "5678"));
//   }
  
  public String multiply(String num1, String num2) {
    int l1 = num1.length();
    int l2 = num2.length();
    int[] result = new int[l1 + l2];
    
    for (int i = l1 - 1; i >= 0; i--) {
      for (int j = l2 - 1; j >= 0; j--) {
        int p1 = i + j;
        int p2 = i + j + 1;
        int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        num += result[p2];
        
        result[p1] += num / 10;
        result[p2] = num % 10;
      }
    }
    
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < result.length && result[i] == 0) {
      i++;
    }
    for (; i < result.length; i++) {
      sb.append(result[i]);
    }
    if (sb.length() == 0) {
      return "0";
    }
    return sb.toString();
  }
}