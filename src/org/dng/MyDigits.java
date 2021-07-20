package org.dng;

//import java.util.EnumSet;
import java.util.HashSet;

enum romeDigitsE
{
    I,V,X,L;
};

public class MyDigits {
    static HashSet<String> romeDigits;
//    static EnumSet<eromeDigits> romeDigits2;

    public MyDigits() {
        romeDigits = new HashSet<>();
        romeDigits.add("I");
        romeDigits.add("V");
        romeDigits.add("X");
        romeDigits.add("L");

//        romeDigits2 = EnumSet.allOf(eromeDigits.class);
    }


    static boolean IsItRomeDigit (String val){
        char[] inValue = val.toCharArray();
        for (char c :inValue) {

            try {
                romeDigitsE rd = romeDigitsE.valueOf( String.valueOf(c) );
                System.out.println("rd=" + rd);
            }
            catch (IllegalArgumentException ex){
                System.out.println("WTF?!");
                return false;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }

        return true;

    }


    static boolean IsItRomeDigitHash (String val){

        char[] inValue = val.toCharArray();
        for (char c :inValue) {
            if (!romeDigits.contains( String.valueOf(c) )) return false;
//            String myStr = Character.toString(c);
        }

        return true;

    }

}
