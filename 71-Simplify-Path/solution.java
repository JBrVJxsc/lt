public class Solution {
  public String simplifyPath(String path) {
    if (path == null) {
      throw new IllegalArgumentException("path cannot be null.");
    }
    
    Stack<String> stack = new Stack<>();
    String[] strs = path.split("/");
    for (String str : strs) {
      if (str.equals("..")) {
          if (!stack.isEmpty()) {
              stack.pop();
          }
      } else if (str.length() != 0 && !str.equals(".")) {
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