import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import java.util.Collections;
// Write a program to create an array of strings and then print out the array and strings backwards.
//
//Example, given {"Harry", "Ron", "Hermione"}, print out "enoimreH", "noR", "yrraH".
public class Backwards {
    public static void main( String [] args) {
        ArrayList<String> listName = new ArrayList<>();
        listName.add("Funky");
        listName.add("Fresh");
        listName.add("Buddha");
        listName.add("Pest");

        System.out.println(listName);
        //System.out.println(indexOf(listName));

        // prints index in reverse *need contents of index to print instead*
        int size = listName.size();
        for (int n = size ; n >= 0 ; --n) {
            System.out.println(n);
        }

        // I need to iterate thru the indices from back to front
        // for each loop?
        //i need to get loop thru the array backwards and store the result in a new array
        /*Iterator<String> stringIterator = listName.iterator();//gets iterator
        (number of indices in listName) = n
        listName.forEach(i = size-1);

         */

    }}