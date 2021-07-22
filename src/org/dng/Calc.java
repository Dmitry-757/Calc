package org.dng;

import java.util.*;
import java.util.stream.Collectors;

enum RomanNumeral {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    private int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static List getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                .collect(Collectors.toList());
    }

 }

public class Calc {
    private String inValue;
    private double inNumber;
    private double currentNumber;
    static MyDigits md=new MyDigits();
    static Scanner in = new Scanner(System.in );


    static int Rome2Arab(String roman){
        int val=0;
        int val_next=0;
        int temp=0;
        int result=0;

        for (int i=0;i<roman.length();i++) {
//            val=value(roman.charAt(i));
            val=RomanNumeral.valueOf(Character.toString(roman.charAt(i))).getValue();
            if (i<roman.length()-1) {
//                val_next=value(roman.charAt(i+1));
                val_next=RomanNumeral.valueOf(Character.toString(roman.charAt(i+1))).getValue();;
            } else val_next=0;

            if (val_next==0) {
                temp=val;
            } else {
                if (val>val_next) temp=val;
                else if (val<val_next) {
                    temp=val_next-val;
                    i++;
                } else if (val==val_next) temp=val;
            }
            result+=temp;
        }
        System.out.println("Result is: " + result);
        return result;
    }

    static int Rome2Arab2(String roman) {
        String romanNumeral = roman.toUpperCase();
        int result = 0;

        List romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = (RomanNumeral) romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(roman + " cannot be converted to a Roman Numeral");
        }

        return result;

    }



    static boolean input(){
//        System.out.println("RomanNumeral.valueOf(\"XL\")"+RomanNumeral.valueOf("CD").getValue());

        System.out.println("input expression!");
        String str=in.nextLine();
        in.close();
        System.out.println("you taped: "+str);

        //*** testing input value ****
        int arabNumber=0;
        str=str.toUpperCase();
        if(str.matches("[MDCLXVI]*")){
//            arabNumber=MyDigits.Rome2ArabTranslation2(str);
            arabNumber=Rome2Arab(str);
            System.out.println("Arab equals = "+arabNumber);

            arabNumber=Rome2Arab2(str);
            System.out.println("2 Arab equals = "+arabNumber);

        }
        else{
            System.out.println("WTF?! Wrong roman digits!");
            throw new IllegalArgumentException("WTF?! Inputed digits in't roman !");
        }


        //******** Transform Roman number to human ;) *******

        //***************************************************
        return true;
    }


}
