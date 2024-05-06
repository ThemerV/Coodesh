package com.example;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 *
 */

public class TASK3 {

    public static void main(String[] args) {
        //Create list
        ArrayList<String> itemList = new ArrayList<String>();
        
        itemList.add("1");
        itemList.add("2");
        itemList.add("3");
        itemList.add("4");
        itemList.add("5");
        itemList.add("6");
        itemList.add("7");
        
        System.out.println("Distinct items count: " + countDistinctItems(itemList));
    }

    //Iterates on the list and adds distinct items to the distinct items list
    public static int countDistinctItems(ArrayList<String> itemList) {
        ArrayList<String> distinctItems = new ArrayList<String>();
        Iterator<String> iterator = itemList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (!distinctItems.contains(item)) {
                distinctItems.add(item);
            }
        }
        return distinctItems.size();
    }
}
