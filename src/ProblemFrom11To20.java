
public class ProblemFrom11To20 {

    /*
    Problem 11 Container With Most Water:
    Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
     */
    /*
    Former solution:
    public int maxArea(int[] height) {
        int maxArea = 0;
        int index1 = 0, index2 = 1;
        //for (int index1 = 0; index1 < height.length - 1; index1 ++) {
            while (index1 < height.length - 1 && index2 < height.length) {
                maxArea = Math.max(maxArea, (index2 - index1) * Math.min(height[index1], height[index2]));
                index2 ++;
                if (index2 == height.length - 1) {
                    index1 ++;
                    index2 = index1 + 1;
                }
            }
        return maxArea;
    }
    Still over time limit
     */
    //先考虑的应该是运算时间而不是时间复杂度,所以虽然减少了一层循环,减少了O(n),但是运算时间并没有改变,有很多次无效运算
    //主体部分是一样的,用了Math.max, Math.min, 重点思路在于并不是暴力比较,而是将两点放在两边,从最大的底边开始比较,那边的height小那边就向对方移动,然后去max再进行比较,主要是找到两个height最接近且最大的点,只比较一次loop即可
    public int maxArea(int[] height) {
        int maxArea = 0;
        int index1 = 0, index2 = height.length - 1;
            while (index1 < index2) {
                maxArea = Math.max(maxArea, (index2 - index1) * Math.min(height[index1], height[index2]));
                if (height[index1] < height[index2]) {
                    index1 ++;
                }
                else {
                    index2 --;
                }
            }
        return maxArea;
    }

    /*Problem 14 Longest comment prefix:
    Write a function to find the longest common prefix string amongst an array of strings.
     */
    public String longestCommonPrefix(String[] strs) {
        //if array strs has no elements, return ""
        if (strs.length == 0){
            return "";
        }
        //find the min length string in strs as minStr
        int minLen = strs[0].length();
        String minStr = strs[0];
        for (String str: strs) {
            if (str.length() == 0) {
                return "";
            }
            if (minLen > Math.min(str.length(), minLen)) {
                minLen = Math.min(str.length(), minLen);
                minStr = str;
            }
        }
        //Shrink the minStr by 1 each step to make sure each string in strs contains this substring and also start from 0
        for (String str: strs) {
            while (str.indexOf(minStr) != 0) {
                minStr = minStr.substring(0, minStr.length() - 1);
            }
        }
        return minStr;
    }









}