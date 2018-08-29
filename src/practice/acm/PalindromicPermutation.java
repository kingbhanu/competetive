package practice.acm;

import java.util.Arrays;

/**
 *
 *
 * @problem : https://helloacm.com/how-to-check-any-string-is-palindrome-from-its-permutation/
 * @author  : swayam raina
 * @type    : strings
 *
 */
public class PalindromicPermutation {

    public static void main(String[] args) {
        System.out.println(isPermutationAPalindrome("geekskeegs") == true);
        System.out.println(isPermutationAPalindrome("swayam") == false);
        System.out.println(isPermutationAPalindrome("keegswsgk") == true);

        System.out.println(isPermutationAPalindrome("baa") == true);
        System.out.println(isPermutationAPalindrome("ac") == false);
    }

    private static boolean isPermutationAPalindrome(String input) {
        boolean odd[] = new boolean[26];
        int count = 0;
        for (int i=0; i< input.length(); i++) {
            char c = input.charAt(i);
            odd[c-'a'] = !odd[c-'a'];
        }
        for (boolean o : odd) {
            if (o) count++;
        }
        return count>1 ? false : true;
    }

}
