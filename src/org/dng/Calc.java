package org.dng;

import java.util.Scanner;

public class Calc {
    private String inValue;
    private double inNumber;
    private double currentNumber;
    static Scanner in = new Scanner(System.in );


    static boolean input(){
        System.out.println("tape something!");
        String str=in.next();
        in.close();

        System.out.println("you taped: "+str);
        System.out.println("inputed value is Rome digit "+MyDigits.IsItRomeDigit(str));

        return true;
    }

    boolean testValue(String in){
        char[] inValue = in.toCharArray();
        for (char i :inValue) {

        }
        return true;
    }

}
