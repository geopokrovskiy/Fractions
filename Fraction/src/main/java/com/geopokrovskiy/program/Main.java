package com.geopokrovskiy.program;

import com.geopokrovskiy.model.Fraction;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction("3 6");
        Fraction f2 = new Fraction("20 30");

        // Arithmetic operations on fractions 1
        Fraction sum = f1.add(f2);
        Fraction diff = f1.subtract(f2);
        Fraction prod = f1.multiply(f2);
        Fraction quot = f1.divide(f2);
        System.out.println("Sum of f1 and f2 is equal to " + sum);
        System.out.println("Difference of f1 and f2 is equal to " + diff);
        System.out.println("Product of f1 and f2 is equal to " + prod);
        System.out.println("Quotient of f1 and f2 is equal to " + quot);

        System.out.println();

        // Arithmetic operations of fractions 2
        Fraction fInitial = new Fraction(2, 7);
        Fraction fOperand = new Fraction(-30, 35);
        fInitial.addAsg(fOperand);
        System.out.println("New value of fInitial after addition is equal to " + fInitial);
        fInitial.subtractAsg(fOperand);
        System.out.println("New value of fInitial after subtraction is equal to " + fInitial);
        fInitial.multiplyAsg(fOperand);
        System.out.println("New value of fInitial after multiplication is equal to " + fInitial);
        fInitial.divideAsg(fOperand);
        System.out.println("Value of fInitial after division is equal to " + fInitial);

        System.out.println();

        // Sum of fractions
        Fraction f3 = new Fraction(4);
        Fraction[] fractions = new Fraction[] {f1, f2, f3};
        System.out.println("The sum of fractions f1, f2 and f3 is equal to " + Fraction.sum(fractions));

        // Max fraction
        Fraction f4 = new Fraction("4/5");
        Fraction f5 = new Fraction("22/7");
        Fraction f6 = new Fraction("314/100");
        Fraction f7 = new Fraction("101/100");
        Fraction[] fractions1 = new Fraction[] {f1, f2, f3, f4, f5, f6, f7};
        System.out.println("The maximal element among f1-f7 is equal to " + Fraction.maxFraction(fractions1));

        System.out.println();

        // Sorting of the array
        Fraction.sortFractionsByAscending(fractions1);
        System.out.println("The array f1-f7 has ben sorted by ascending.");
        System.out.println(Arrays.toString(fractions1));
        Fraction.sortFractionsByDescending(fractions1);
        System.out.println("The array f1-f7 has ben sorted by descending.");
        System.out.println(Arrays.toString(fractions1));
    }
}