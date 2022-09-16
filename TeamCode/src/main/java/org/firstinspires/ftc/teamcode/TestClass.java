package org.firstinspires.ftc.teamcode;

public class TestClass {
    public static void main(String args[]) {
        System.out.println("Hello");
        int x = 5;
        int y = 2;
        int totalMints = 500;
        int numberOfBags = totalMints/3; //I used integer division as I wanted to cut off any decimal digits that may have been in the answer, but I did want the number of bags so no modulo
        int mintsLeftOver = totalMints%3; //I wanted the remainder, so I used modulo
        System.out.println("Total Mints = " + totalMints);
        System.out.println("Number of Bags = " + numberOfBags);
        System.out.println("Mints Leftover = " + mintsLeftOver);
    }
}