package org.dng;

import java.util.Scanner;

public class Calc {
    private String inValue;
    private double inNumber;
    private double currentNumber;
    static MyDigits md=new MyDigits();
    static Scanner in = new Scanner(System.in );


    static boolean input(){
        System.out.println("input expression!");
        //String str=in.next();
        String str=in.nextLine();
        in.close();
        System.out.println("you taped: "+str);

        //*** testing input value ****

        System.out.println("search in HashSet... inputed value is Rome digit = "+MyDigits.IsItRomeDigit(str));
        System.out.println("search in HashMap... inputed value is Rome digit = "+MyDigits.IsItRomeDigitM(str));
        System.out.println("test isDigit... inputed value is Arab digit = "+MyDigits.IsItArabDigit(str));

        if (MyDigits.IsItRomeDigitM(str)) MyDigits.Rome2ArabTranslation(str);
        //******** Transform Roman number to human ;) *******

        //***************************************************
        return true;
    }


}
