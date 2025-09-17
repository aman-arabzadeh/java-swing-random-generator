package com.company.xmlxsd;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsoleRandomGen {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter Lower-bound: ");
        int lowerBound = sc.nextInt();

        System.out.print("Enter Upper-bound: ");
        int upperBound = sc.nextInt();

        if (lowerBound > upperBound) {
            System.out.println("The lower limit value needs to be smaller than the upper limit value.\n");
            return;
        }

        if (lowerBound == 0 || upperBound == 0) {
            System.out.println("Lower bound || upper bound cannot both be 0.\n");
            return;
        }

        System.out.print("How many?: ");
        int range = sc.nextInt();

        if (range < 1) {
            System.out.println("Please provide a positive integer as the amount of numbers to generate.\n");
            return;
        }

        if (range > (upperBound - lowerBound + 1)) {
            System.out.println("Not enough unique numbers in the given range.\n");
            return;
        }

        SecureRandom random = new SecureRandom();
        Set<Integer> integers = new HashSet<>();

        while (integers.size() < range) {
            integers.add(random.nextInt(upperBound - lowerBound + 1) + lowerBound);
        }

        System.out.println("Generated numbers: " + integers);
    }
}
