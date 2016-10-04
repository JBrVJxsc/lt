public class Solution {
    public String simplifyPath(String path) {
        if (path == null) {
            return "/";
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
            sb.insert(0, '/');
            sb.insert(1, stack.pop());
        }
        return sb.toString();
    }
}