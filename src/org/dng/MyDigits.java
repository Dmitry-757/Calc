package org.dng;

import java.util.HashMap;
import java.util.HashSet;

public class MyDigits {
    private static HashSet<Character> romeDigits;
    private static HashMap<Character, Integer> romeDigitsM;

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

        return rez;
    }

}
