package sample;


import java.util.Arrays;

public class ArraySorter {



    public ArraySorter(){

    }


    public static void main(String[] args)
    {
        String[] foo = new String[10];
        foo[0] = "Lenin, Vladimir dasklgh asdklhsdkla 124124";
        foo[1] = "Stalin, Joseph dasklgh asdklh";
        foo[2] = "Castro, Fidel dasklgh asdklh";
        foo[3] = "REE, KREE dasklgh asdklh";
        foo[4] = "Ww, ah dasklgh asdklh";
        foo[5] = "As, Fas dasklgh asdklh";
        foo[6] = "Ne, Ko dasklgh asdklh";
        foo[7] = "Be, Bo dasklgh asdklh";
        foo[8] = "He, Ho dasklgh asdklh";
        foo[9] = "Yo, Bro dasklgh asdklh";

        GetOrderedNames(foo);
        PrintContent(foo);;
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

        newArray = FirstLast(newArray);


        return newArray;
    }

    public static String[] FirstLast(String[] fArray)
    {
        String[] finalArray = new String[fArray.length];

        for(int i = 0; i < fArray.length; i++){
            String toFlip = fArray[i];
            int place = toFlip.indexOf(",");
            String last = toFlip.substring(0, place - 1);

            int stop = toFlip.indexOf(" ", place + 1);
            String first = toFlip.substring(place + 1, stop);



            finalArray[i] = first + ", " + last;

        }
        return finalArray;
    }


}
