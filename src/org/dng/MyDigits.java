package org.dng;


import java.util.*;


public class MyDigits {
    private static HashSet<Character> romeDigits;
    private static HashMap<Character, Integer> romeDigitsM;

    private static HashSet<Character> arithmetical;

    public MyDigits() {
        romeDigits = new HashSet<>();
        romeDigits.add('I');
        romeDigits.add('V');
        romeDigits.add('X');
        romeDigits.add('L');//50
        romeDigits.add('C');//100
        romeDigits.add('D');//500
        romeDigits.add('M');//1000

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


    static boolean IsItRomeDigit1 (String val){
        val=val.toUpperCase();
//        if(val.matches(".*[0-9].*") || !val.matches("[M|D|C|L|X|V|I]*")){
        if(!val.matches("[MDCLXVI]*")){
            System.out.println("Impossible to convert. Wrong roman numeral");
            return false;
        }
        return true;
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


    static int value(char a) {
//        if (a=='M') return 1000;
//        else if (a=='D') return 500;
//        else if (a=='C') return 100;
//        else if (a=='L') return 50;
//        else if (a=='X') return 10;
//        else if (a=='V') return 5;
//        else if (a=='I') return 1;
//        else return 0;

        return romeDigitsM.get(a);
    }

    static int Rome2ArabTranslation2(String roman){
//        roman=roman.toLowerCase();
        int val=0;
        int val_next=0;
        int temp=0;
        int result=0;

        for (int i=0;i<roman.length();i++) {
            val=value(roman.charAt(i));
            if (i<roman.length()-1) {
                val_next=value(roman.charAt(i+1));
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


    }
