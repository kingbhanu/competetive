package practice.g4g;


// @problem : https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/

public class SmallestPositiveInteger {

    public static void main(String[] args) {
        int arr[] = {1,2,4,8,10};
        SmallestPositiveInteger smallestPositiveInteger = new SmallestPositiveInteger();
        System.out.println(smallestPositiveInteger.getNumber(arr));
    }

    private int getNumber(int arr[]) {
        int n = arr.length;
        int ans = 1;
        // mapping 0....i with
        //         1....arr[i]
        // if a gap is obtained the number is reached
        for (int i=0; i<n; i++) {
            if (arr[i] <= ans) ans += arr[i];
        }
        return ans;
    }

}
