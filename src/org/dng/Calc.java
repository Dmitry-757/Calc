package org.dng;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
//        System.out.println("Result is: " + result);
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

    static int Calculate(int num1, int num2, char operDesignation){
        switch (operDesignation){
            case '+':
                return(num1+num2);
            case '-':
                return(num1-num2);
            case '*':
                return(num1*num2);
            case '/':
                return(num1/num2);
            default:
                System.out.println("somthing wrong during calculating!");
        }
        return 0;
    }

    static boolean input(){


        System.out.println("input expression!");
        String str=in.nextLine();
        in.close();
        System.out.println("you taped: "+str);

        //*** testing input value ****
        int arabNumber=0;
        str=str.replace(" ","").toUpperCase();//убираем пробелы
        System.out.println("you taped: "+str);

        int result=0;

//        if(str.matches("[MDCLXVI\\+\\-\\*\\/]*")  ){
        if(str.matches("[MDCLXVI\\Q+-*/\\E]*")  ){ //все, что между \\Q и \\E экранируется
            //System.out.println("str.matches passed");

            //**** делаем расчленинград исходной строки на числа и знаки операций ***
            String tmp;
            int lastEnd=0;
            char operDesignation='+';
            String REGEX = "[\\Q+-*/\\E]";
            String INPUT = str;
            Pattern p = Pattern.compile(REGEX);
            Matcher m = p.matcher(INPUT);   // получение matcher объекта

            while (m.find()){
                System.out.println("*********");
                System.out.println("at pos "+m.start()+" find "+str.charAt(m.start()));


                tmp=str.substring(lastEnd, m.start());
                lastEnd=m.end();
                System.out.println("tmp = "+tmp);

                arabNumber=Rome2Arab(tmp);
                System.out.println("last number = "+result);
                System.out.println("operDesignation "+operDesignation);
                System.out.println("Arab equals = "+arabNumber);


                result=Calculate(result, arabNumber, operDesignation);
                System.out.println("result = "+result);

                operDesignation=str.charAt(m.start());

                System.out.println("*********");
            }

            System.out.println("*********");
            tmp=str.substring(lastEnd, str.length());
            //System.out.println("at pos "+lastEnd+" find "+str.charAt(m.start()));
            System.out.println("tmp = "+tmp);
            arabNumber=Rome2Arab(tmp);

            System.out.println("last number = "+result);
            System.out.println("operDesignation "+operDesignation);
            System.out.println("Arab equals = "+arabNumber);

            result=Calculate(result, arabNumber, operDesignation);
            System.out.println("result = "+result);

            System.out.println("*********");


            //******** Transform Roman number to human ;) *******
/*
            arabNumber=Rome2Arab(str);
            System.out.println("Arab equals = "+arabNumber);

            arabNumber=Rome2Arab2(str);
            System.out.println("2 Arab equals = "+arabNumber);
*/

        }
        else{
            System.out.println("WTF?! Wrong roman digits!");
            throw new IllegalArgumentException("WTF?! Inputed digits isn't roman !");
        }



        //***************************************************
        return true;
    }


}
