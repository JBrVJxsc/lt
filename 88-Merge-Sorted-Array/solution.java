public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int pos = m + n - 1;
    
    while (0 <= i || 0 <= j) {
      if (i < 0) {
        nums1[pos--] = nums2[j--];
      } else if (j < 0) {
        nums1[pos--] = nums1[i--];
      } else if (nums1[i] < nums2[j]) {
        nums1[pos--] = nums2[j--];
      } else {
        nums1[pos--] = nums1[i--];
      }
    }
  }
}