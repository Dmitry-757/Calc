package org.dng;

import java.util.EnumSet;
import java.util.HashSet;


enum eromeDigits
{
    I,V,X;
};

public class MyDigits {
//    static HashSet<String> romeDigits;
//
//    static EnumSet<eromeDigits> romeDigits2;
//
//    public MyDigits() {
//        romeDigits = new HashSet<>();
//        romeDigits.add("I");
//        romeDigits.add("V");
//        romeDigits.add("X");
//
//        romeDigits2 = EnumSet.allOf(eromeDigits.class);
//
//    }



    static boolean IsItRomeDigit (String val){

//        return romeDigits.contains(val);
//        System.out.println(romeDigits2);

        try {
            eromeDigits rd = eromeDigits.valueOf(val);
            System.out.println("rd=" + rd);
            return true;
        }
        catch (IllegalArgumentException ex){
            System.out.println("WTF?!");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;

    }
}
