package string;

public class LicenseKeyFormatting {

    //TAG: Google
    //TAG: String
    //Difficulty: Easy

    /**
     * 482. License Key Formatting
     * ou are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.

     Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.

     Given a non-empty string S and a number K, format the string according to the rules described above.

     Example 1:
     Input: S = "5F3Z-2e-9-w", K = 4

     Output: "5F3Z-2E9W"

     Explanation: The string S has been split into two parts, each part has 4 characters.
     Note that the two extra dashes are not needed and can be removed.
     Example 2:
     Input: S = "2-5g-3-J", K = 2

     Output: "2-5G-3J"

     Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
     Note:
     The length of string S will not exceed 12,000, and K is a positive integer.
     String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
     String S is non-empty.

     */

    /**
     * Solution:
     * use char[]
     * Calculate all length of chars, len%k is the first word length, if len%k == 0 first word length == k
     * add - between k length substrings
     *
     * Time: O(n)
     * Space: O(n)
     */

    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0 || K == 0) return S;
        char[] chars = S.toCharArray();
        //Similar to move 0s to the end
        int slow = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '-') {
                //Convert all chars to uppercase as required in move char step
                chars[i] = Character.toUpperCase(chars[i]);
                chars[slow++] = chars[i];
            }
        }
        //now chars left than slow (not include slow) is characters
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i < slow) {
            int len = K;
            if (i == 0) len = slow % K == 0 ? K : slow % K;
            builder.append(chars, i, len);
            builder.append('-');
            i += len;
        }
        //Test case may contains "---" which has only '-'
        if (builder.length() != 0) builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    /**
     * Solution 2:
     * append stringBuilder from end to start, so that needn't to parse first length, append k length, and left the
     * last part for the first word
     */

}
