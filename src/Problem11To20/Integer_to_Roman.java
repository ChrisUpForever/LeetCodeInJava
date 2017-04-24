package Problem11To20;

public class Integer_to_Roman {

    /**
     * 12. Integer to Roman
     * Given an integer, convert it to a roman numeral.

     Input is guaranteed to be within the range from 1 to 3999.

     Show Company Tags
     Show Tags
     Show Similar Problems
     */

    /**
     * Solution:
     * Roman integer is combined with each bit digit transferred to Roman
     * 1. We need to have array or dictionary (hashMap) to represent integer to Roman
     * 2. Separate num by thousand bit, hundred bit, ten bit and single bit
     * 3. combine each bit transferred Roman and append together
     *
     * Time: O(1)
     * Space: O(1) constant space for roman arrays
     */

    public String intToRoman(int num) {
        String thousand[] = {"", "M", "MM", "MMM"};
        String hundred[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String ten[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String one[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousand[num/1000%10] + hundred[num/100%10] + ten[num/10%10] + one[num%10];
    }

}
