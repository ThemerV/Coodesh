package com.example;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        //Starts a pointer on the first and last characters and compares them while the first is going forward and the last backwards.
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;

    }
}
