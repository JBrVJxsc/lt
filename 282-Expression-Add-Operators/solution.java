public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return list;
        }
        dfs(num, target, list, 0, 0, 0, "");
        return list;
    }
    
    private void dfs(String num, int target, List<String> list, int pos, long val, long last, String cur) {
        if (pos == num.length()) {
            if (val == target) {
                list.add(cur);
            }
        } else {
            for (int i = pos; i < num.length(); i++) {
                if (i != pos && num.charAt(pos) == '0') {
                    break;
                }
                long n = Long.parseLong(num.substring(pos, i + 1));
                if (pos == 0) {
                    dfs(num, target, list, i + 1, n, n, cur + n);
                } else {
                    dfs(num, target, list, i + 1, val + n, n, cur + "+" + n);
                    dfs(num, target, list, i + 1, val - n, -n, cur + "-" + n);
                    dfs(num, target, list, i + 1, val - last + last * n, last * n, cur + "*" + n);
                }
            }
        }
    }
}