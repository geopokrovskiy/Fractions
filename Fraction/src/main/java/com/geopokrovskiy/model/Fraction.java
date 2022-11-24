package com.geopokrovskiy.model;

import com.geopokrovskiy.util.MathUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Implements arithmetic of fractions
 */
public class Fraction implements Comparable<Fraction> {
    private int a;
    private int b;

    /**
     * default constructor
     */
    public Fraction() {
        this.a = 0;
        this.b = 1;
    }

    /**
     * constructor taking an integer number
     *
     * @param a
     */
    public Fraction(int a) {
        this.a = a;
        this.b = 1;
    }

    /**
     * constructor taking numerator and denominator
     * as parameters
     *
     * @param a
     * @param b
     * @throws ArithmeticException
     */
    public Fraction(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        this.a = a;
        this.b = b;
        this.reduce();
    }

    /**
     * constructor taking another fraction as a parameter
     * (copy constructor)
     *
     * @param fraction
     */
    public Fraction(Fraction fraction) {
        this.a = fraction.a;
        this.b = fraction.b;
        this.reduce();
    }

    /**
     * Constructor taking a string as a parameter
     *
     * @param str
     */
    public Fraction(String str) throws ArithmeticException {
        if (!str.contains(" ") && !str.contains("/")) {
            this.a = Integer.parseInt(str);
            this.b = 1;
        } else {
            String[] splitString = str.split("[ /]");
            if (Integer.parseInt(splitString[1]) == 0) {
                throw new ArithmeticException("Division by zero!");
            }
            this.a = Integer.parseInt(splitString[0]);
            this.b = Integer.parseInt(splitString[1]);
        }
        this.reduce();
    }

    /**
     * getters and setters
     *
     * @return
     */
    private int getA() {
        return a;
    }

    private int getB() {
        return b;
    }

    private void setA(int a) {
        this.a = a;
    }

    private void setB(int b) {
        this.b = b;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return a == fraction.a && b == fraction.b;
    }

    /**
     * reduces the fraction
     */
    private void reduce() {
        int gcd = MathUtil.findGCD(this.a, this.b);
        if (this.a < 0) {
            this.a /= -gcd;
            this.b /= -gcd;
        } else {
            this.a /= gcd;
            this.b /= gcd;
        }
    }

    /**
     * returns a fraction reciprocal to the given one
     *
     * @return
     */
    private Fraction reciprocal() throws ArithmeticException {
        if (this.toString().equals("0")) {
            throw new ArithmeticException("Division by zero!");
        }
        Fraction zero = new Fraction();
        if (this.compareTo(zero) > 0) {
            return new Fraction(this.b, this.a);
        } else return new Fraction(-this.b, -this.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        this.reduce();
        if (this.a != 0 && this.b != 0 && this.b != 1) {
            return a + "/" + b;
        } else if (this.a == 0) {
            return "0";
        } else if (this.b == 1) {
            return a + "";
        }
        return "";
    }

    /**
     * Compares two fractions
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Fraction o) {
        return Integer.compare(this.a * o.b, this.b * this.a);
    }

    private static Comparator<Fraction> comparatorDescending = new Comparator<Fraction>() {
        @Override
        public int compare(Fraction o1, Fraction o2) {
            return o2.compareTo(o1);
        }
    };

    /** addition
     * @param other
     * @return
     */
    public Fraction add(Fraction other){
        this.reduce();
        other.reduce();
        Fraction ans = new Fraction(this.a * other.b + other.a * this.b, this.b * other.b);
        ans.reduce();
        return ans;
    }

    /**
     * Takes the fraction and an integer and returns a fraction
     * equal to the sum of arguments
     * @param B
     * @return
     */
    public Fraction add(int B) {
        this.reduce();
        Fraction result = new Fraction(this.a + B * this.b, this.b);
        result.reduce();
        return result;
    }

    /**
     * Takes the fraction and a double and returns a double
     * equal to the sum of arguments
     * @param B
     * @return
     */
    public double add(double B) {
        double a = this.getA();
        double b = this.getB();
        return a / b + B;
    }

    /**
     * +=
     * @param other
     * @return
     */
    public Fraction addAsg(Fraction other){
        Fraction res = this.add(other);
        this.a = res.a;
        this.b = res.b;
        return this;
    }

    /** subtraction
     * @param other
     * @return
     */
    public Fraction subtract(Fraction other){
        this.reduce();
        other.reduce();
        Fraction ans = new Fraction(this.a * other.b - other.a * this.b, this.b * other.b);
        ans.reduce();
        return ans;
    }

    /**
     * Takes the fraction and an integer and returns a fraction
     * equal to the difference of arguments
     *
     * @param f1
     * @param B
     * @return
     */
    public Fraction subtract(Fraction f1, int B)  {
        this.reduce();
        Fraction result = new Fraction(this.a - B * this.b, this.b);
        result.reduce();
        return result;
    }

    /**
     * Takes the fraction and a double and returns a double
     * equal to the difference of arguments
     *
     * @param f1
     * @param B
     * @return
     */
    public double subtract(Fraction f1, double B) {
        double a = this.getA();
        double b = this.getB();
        return a / b + B;
    }


    /**
     * -=
     * @param other
     * @return
     */
    public Fraction subtractAsg(Fraction other){
        Fraction res = this.subtract(other);
        this.a = res.a;
        this.b = res.b;
        return this;
    }


    /**
     * multiplication
     *
     * @param other
     * @return
     */
    public Fraction multiply(Fraction other) {
        Fraction ans = new Fraction(other.a * this.a, this.b * other.b);
        ans.reduce();
        return ans;
    }

    /**
     * Takes the fraction and an integer and returns a fraction
     * equal to the product of arguments
     * @param B
     * @return
     */
    public Fraction multiply(int B) {
        int newA = this.getA() * B;
        Fraction answer = new Fraction(newA, B);
        answer.reduce();
        return answer;
    }

    /**
     * Takes the fraction and a double and returns a double
     * equal to the product of arguments
     * @param B
     * @return
     */
    public double multiply(double B) {
        double a = this.getA();
        double b = this.getB();
        return a / b * B;
    }

    /**
     * *=
     * @param other
     * @return
     */
    public Fraction multiplyAsg(Fraction other){
        Fraction res = this.multiply(other);
        this.a = res.a;
        this.b = res.b;
        return this;
    }

    /**
     * division
     *
     * @param other
     * @return
     */
    public Fraction divide(Fraction other) {
        other = other.reciprocal();
        return this.multiply(other);
    }

    /**
     * Takes the fraction and an integer and returns a fraction
     * equal to the quotient of arguments
     * @param B
     * @return
     */
    public Fraction divide(int B) {
        Fraction f2 = new Fraction(1, B);
        return this.multiply(f2);
    }

    /**
     * Takes the fraction and a double and returns a double
     * equal to the quotient of arguments
     * @param B
     * @return
     */
    public double divide(double B) {
        double a = this.getA();
        double b = this.getB();
        return a / (b * B);
    }

    /**
     * /=
     *
     * @param
     * @return
     */
    public Fraction divideAsg(Fraction f) {
        Fraction res = this.divide(f);
        this.a = res.a;
        this.b = res.b;
        return this;
    }

    /**
     * Returns the sum of fractions in array
     *
     * @param array
     * @return
     */
    public static Fraction sum(Fraction[] array) {
        if (array.length == 0) {
            return null;
        } else if (array.length == 1) {
            return array[0];
        }
        Fraction result = array[0].add(array[1]);
        for (int i = 2; i < array.length; i++) {
            result.add(array[i]);
        }
        return result;
    }

    /**
     * Returns maximal fraction in array
     *
     * @param array
     * @return
     */
    public static Fraction maxFraction(Fraction[] array) {
        Fraction max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Sort given array by ascending
     *
     * @param array
     */
    public static void sortFractionsByAscending(Fraction[] array) {
        Arrays.sort(array);
    }

    /**
     * Sort given array by descending
     *
     * @param array
     */
    public static void sortFractionsByDescending(Fraction[] array) {
        Arrays.sort(array, comparatorDescending);
    }
}
