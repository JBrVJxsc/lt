public class Solution {
    
  public String multiply(String a, String b) {
    if (a == null || b == null) {
      throw new IllegalArgumentException("a and b cannot be null.");
    }
    
    int aLen = a.length();
    int bLen = b.length();
    int[] result = new int[aLen + bLen];
    
    for (int i = aLen - 1; i >= 0; i--) {
      for (int j = bLen - 1; j >= 0; j--) {
        int aNum = a.charAt(i) - '0';
        int bNum = b.charAt(j) - '0';
        int pos1 = i + j;
        int pos2 = i + j + 1;
        int multi = aNum * bNum;
        multi += result[pos2];
        result[pos1] += multi / 10;
        result[pos2] = multi % 10;
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