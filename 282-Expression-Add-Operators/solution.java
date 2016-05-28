    public class Solution {
        public List<String> addOperators(String num, int target) {
            List<String> list = new ArrayList<>();
            dfs(num, target, list, 0, "", 0, 0);
            return list;
        }

        private void dfs(String num, int target, List<String> list, int index, String curStr, long curVal, long last) {
            if (index == num.length()) {
                if (curVal == target) {
                    list.add(curStr);
                }
                return;
            }

            for (int i = index; i < num.length(); i++) {
                if (i != index && num.charAt(index) == '0') {
                    return;
                }
                String sub = num.substring(index, i + 1);
                long val = Long.valueOf(sub);
                if (index == 0) {
                    dfs(num, target, list, i + 1, sub, val, val);
                } else {
                    dfs(num, target, list, i + 1, curStr + "+" + sub, curVal + val, val);
                    dfs(num, target, list, i + 1, curStr + "-" + sub, curVal - val, -val);
                    dfs(num, target, list, i + 1, curStr + "*" + sub, curVal - last + last * val, last * val);
                }
            }
        }
    }