public class Solution {
  public String simplifyPath(String path) {
    if (path == null) {
      return null;
    }
    
    String[] strs = path.split("/");
    
    Stack<String> stack = new Stack<>();
    for (String str : strs) {
      if (str.length() == 0 || str.equals(".")) {
        continue;
      } else if (str.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(str);
      }
    }
    
    if (stack.isEmpty()) {
      return "/";
    }
    
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append("/").append(stack.remove(0));
    }
    return sb.toString();
  }
}