package sample;
import java.util.*;



public class ArraySorter {

    public String[] array = new String[10];




    public static void main(String args[])
    {



    }

    @Override
    public void start(){
        array[0] = "Lenin, Vladimir";
        array[1] = "Stalin, Joseph";
        array[2] = "Castro, Fidel";

        printContent();
    }



    public void printContent(){
        for(int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }



}
