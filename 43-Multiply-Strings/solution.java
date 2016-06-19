public class Solution {
  public String multiply(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    int[] nums = new int[len1 + len2];
    
    for (int i = len1 - 1; i >= 0; i--) {
      for (int j = len2 - 1; j >= 0; j--) {
        int num = num1.charAt(i) - '0';
        num *= num2.charAt(j) - '0';
        int a = i + j;
        int b = a + 1;
        
        num += nums[b];
        nums[b] = num % 10;
        nums[a] += num / 10;
      }
    }
    
    int i = 0;
    while (i < nums.length && nums[i] == 0) {
      i++;
    }
    
    StringBuilder sb = new StringBuilder();
    for (; i < nums.length; i++) {
      sb.append(nums[i]);
    }
    
    return sb.length() == 0 ? "0" : sb.toString();
  }
}




//          5  6  7    0,1,2    i
//                8    0        j
//        ___________
//             5  6
//          4  8
//       4  0
// ____________________
//       4  5  3  6
           
//       0  1  2  3     
           
//             ^  ^
//             a  b
//          a  b 
// 1:            
//   a = i + j
//   b = i + j + 1
    
// 2:
  
            
           
           
      