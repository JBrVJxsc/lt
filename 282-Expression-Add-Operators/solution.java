public class Solution {
  public List<String> addOperators(String num, int target) {
    List<String> result = new ArrayList<>();
    dfs(num, target, 0, "", 0, 0, result);
    return result;
  }
  
  private void dfs(String num, int target, int index, String curPath, long curVal, long preVal, List<String> result) {
    if (index == num.length()) {
      if (curVal == target) {
        result.add(curPath);
      }
      return;
    }
    for (int i = index; i < num.length(); i++) {
      String sub = num.substring(index, i + 1);
      long val = Long.valueOf(sub);
         
      if (i != index && num.charAt(index) == '0') {
        return;
      }         
      
      if (index == 0) {
        dfs(num, target, i + 1, sub, val, val, result);
      } else {
        dfs(num, target, i + 1, curPath + "+" + sub, curVal + val, val, result);
        dfs(num, target, i + 1, curPath + "-" + sub, curVal - val, -val, result);
        dfs(num, target, i + 1, curPath + "*" + sub, curVal - preVal + preVal * val, preVal * val, result);
      }
    }
  }
}

// "123", 6 -> ["1+2+3", "1*2*3"] 

//      1          12          123
//     /|\         /|\         /|\
//    + - * 


// 1 + 2      = 3
// 1 + 2 * 3  = curVal = 3 - 2 + 2 * 3 = 7
  
  
//   000000
  
  
  
  
  
//   12 -> 3
//  123 -> 3 * 3
// 1234 -> 3 * 3 * 3 
  
  
//   3^height