package sample;


import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

public class ArraySorter {

    public String[] array;

    public ArraySorter(String[] ogArray){
        array = ogArray;
    }


    public static void main(String[] args)
    {
        String[] foo = new String[10];
        foo[0] = "Lenin, Vladimir dasklgh asdklhsdkla";
        foo[1] = "Stalin, Joseph dasklgh asdklh";
        foo[2] = "Castro, Fidel dasklgh asdklh";
        foo[3] = "REE, bad dasklgh asdklh";
        foo[4] = "Ww, ah dasklgh asdklh";
        foo[5] = "As, Fas dasklgh asdklh";
        foo[6] = "Ne, Ko dasklgh asdklh";
        foo[7] = "Be, Bo dasklgh asdklh";
        foo[8] = "He, Ho dasklgh asdklh";
        foo[9] = "Yo, Bro dasklgh asdklh";

    }


    public static void PrintContent(String[] nArray){
        for(int i = 0; i < nArray.length; i++)
        {
            System.out.println(nArray[i]);
        }
    }

    public static String[] GetOrderedNames(String[] newArray)
    {
        Arrays.sort(newArray);

        return newArray;
    }

    public static String[] FirstLast(String[] fArray)
    {
        String[] finalArray = new String[fArray.length];

        for(int i = 0; i < fArray.length; i++){
            System.out.println(i);

            String toFlip = fArray[i];
            toFlip = toFlip.replace("\t", " ");
            int commaPlace = toFlip.indexOf(",");
            String last = toFlip.substring(0,commaPlace);
            int secondStop = toFlip.indexOf(" ", commaPlace+2);
            String first = toFlip.substring(commaPlace+2, secondStop);
            String firstLast = first + ", " + last;

            finalArray[i] = firstLast.trim();
        }
        return finalArray;
    }


    public static String[] getFinalFromStart(String[] startWithThis){
        GetOrderedNames(startWithThis);
        return FirstLast(startWithThis);
    }
}
