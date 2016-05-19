public class Solution {
    public boolean isMatch(String str, String pattern) {
        int s = 0; // cursor for traversal in str.
        int p = 0; // cursor for traversal in pattern.
        int starIdx = -1; // once we found a star, we want to record the place of the star.
        int match = 0; // once we found a star, we want to start to match the rest of pattern with str, starting from match; this is for remembering the place where we need to start.
         
        // we check and match every char for str.
        while (s < str.length()){
            // 1. case 1: we are not currently at any *, 
            if (p < pattern.length() && (pattern.charAt(p) == str.charAt(s) || pattern.charAt(p) == '?')){
                p++;
                s++;
            }// 2. case 2: we are currently at a '*'
            else if (p < pattern.length() && pattern.charAt(p) == '*' ){
                starIdx = p;
                p++;
                match = s;
            } // 3. case 3: they do not match, we do not currently at a *, but the last matched is a *
            else if (starIdx != -1){
                match++;
                s = match;
                p = starIdx + 1;
            } // 4. case 4: they do not match, do not currently at a *, and last matched is not a *, then the answer is false;
            else{
                return false;
            }
        }
        // when we finish matching all characters in str, is pattern also finished? we could only allow '*' at the rest of pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
        p++;
   
        return p == pattern.length();
    }
}