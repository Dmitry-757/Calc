package org.dng;

import java.util.Scanner;

public class Calc {
    private String inValue;
    private double inNumber;
    private double currentNumber;
    static MyDigits md=new MyDigits();
    static Scanner in = new Scanner(System.in );


    static boolean input(){
        System.out.println("tape something!");
        String str=in.next();
        in.close();
        System.out.println("you taped: "+str);

        //*** testing input value ****
        System.out.println("inputed value is Rome digit = "+MyDigits.IsItRomeDigit(str));

        System.out.println("search in HashSet... inputed value is Rome digit = "+MyDigits.IsItRomeDigitHash(str));

        return true;
    }


}
