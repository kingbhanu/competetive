package practice.acm.misc;


// @problem : https://helloacm.com/c-coding-exercise-find-letter-case-permutation-with-dfs/

public class LetterCasePermutation {

    public static void main(String[] args) {
        String input = "a1b2c34f";
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        letterCasePermutation.printLetterCasePermutation(input);
    }

    private void printLetterCasePermutation(String in) {
        printAllPermutation("", in, 0, in.length());
    }

    private void printAllPermutation(String curr, String in, int s, int e) {
        if (s>=e) {
            System.out.println(curr);
            return;
        }
        String curr1 = curr + in.toLowerCase().charAt(s);
        printAllPermutation(curr1,in,s+1,e);
        String curr2 = curr + in.toUpperCase().charAt(s);
        // handle if numeric char
        if (!curr1.equals(curr2)) {
            printAllPermutation(curr2, in,s+1, e);
        }
    }

}
