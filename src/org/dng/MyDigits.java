package org.dng;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;

public class MyDigits {
    private static HashSet<Character> romeDigits;
    private static HashMap<Character, Integer> romeDigitsM;
    private static HashMap<String, Integer> romeDigitsM2;

    private static HashSet<Character> arithmetical;

    public MyDigits() {
        romeDigits = new HashSet<>();
        romeDigits.add('I');
        romeDigits.add('V');
        romeDigits.add('X');
//        romeDigits.add('L');//50

        romeDigitsM = new HashMap<>();
        romeDigitsM.put('I',1);
        romeDigitsM.put('V',5);
        romeDigitsM.put('X',10);
        romeDigitsM.put('L',50);
        romeDigitsM.put('C',100);
        romeDigitsM.put('D',500);
        romeDigitsM.put('M',1000);

        romeDigitsM2 = new HashMap<>();
        romeDigitsM2.put("I",1);
        romeDigitsM2.put("II",2);
        romeDigitsM2.put("III",3);
        romeDigitsM2.put("IV",4);
        romeDigitsM2.put("V",5);
        romeDigitsM2.put("VI",6);
        romeDigitsM2.put("VII",7);
        romeDigitsM2.put("VIII",8);
        romeDigitsM2.put("IX",9);
        romeDigitsM2.put("X",10);
        romeDigitsM2.put("XI",11);
        romeDigitsM2.put("XII",12);
        romeDigitsM2.put("XIII",13);
        romeDigitsM2.put("XIV",14);
        romeDigitsM2.put("XV",15);

        romeDigitsM2.put("L",50);
        romeDigitsM2.put("C",100);
        romeDigitsM2.put("D",500);
        romeDigitsM2.put("M",1000);

        arithmetical = new HashSet<>();
        arithmetical.add(' ');
        arithmetical.add('+');
        arithmetical.add('-');
        arithmetical.add('*');
        arithmetical.add('/');


    }


    static boolean IsItRomeDigit (String val){
        char[] inValue = val.toCharArray();
        for (char c : inValue) {
            if (!romeDigits.contains( Character.toUpperCase(c) ) & (!arithmetical.contains(c)) ) return false;
        }
        return true;
    }

    static boolean IsItRomeDigitM (String val){
        char[] inValue = val.toCharArray();
        for (char c : inValue) {
            if (!romeDigitsM.containsKey( Character.toUpperCase(c) ) & (!arithmetical.contains(c)) ) return false;
        }
        return true;
    }

    static boolean IsItRomeDigitM2 (String val){
        char[] inValue = val.toCharArray();
        for (char c : inValue) {
            if (!romeDigitsM.containsKey( Character.toString(Character.toUpperCase(c)) ) & (!arithmetical.contains(c)) ) return false;
        }
        return true;
    }


    static boolean IsItArabDigit (String val){
        char[] inValue = val.toCharArray();
        for (char c : inValue) {
            if (! (Character.isDigit(c) ) & (!arithmetical.contains(c))  ) return false;
        }
        return true;
    }

    static int Rome2ArabTranslation(String val){
        int rez=0;
        char[] inValue = val.toCharArray();
        for (char c : inValue){

        }
        for (int i = (inValue.length-1); i>=0 ; i--) {
            System.out.println("haracter.toUpperCase(inValue[i] = "+Character.toUpperCase(inValue[i]));
//            System.out.println( romeDigitsM.get('X') );
            System.out.println("romeDigitsM.get(Character.toUpperCase(inValue[i])) = "+romeDigitsM.get(Character.toUpperCase(inValue[i])));
            rez+=romeDigitsM.get(Character.toUpperCase(inValue[i]));
            System.out.println("inputed number is "+rez);
        }

        return rez;
    }

}
