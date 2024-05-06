package com.example;
import java.util.Scanner;

/**
 * 
 *
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * 
 * 
 * 
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */

public class TASK1 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner string = new Scanner(System.in);
        System.out.println("Enter a string: ");

        String input = string.nextLine();
        //Checks if the string is a palindrome
        if (PalindromeChecker.isPalindrome(input)) {
            System.out.println("The string is a palindrome");
        } else {
            System.out.println("The string is not a palindrome");
        }
    }
}