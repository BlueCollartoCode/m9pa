// ConceptDemo.java
// Justin Cope
// October 31, 2026
// Demonstrates the Adapter pattern using Java collections.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConceptDemo {

   // Entry point: runs each concept demonstration in order
   public static void main(String[] args) {
      // Create the original array of Integer values
      Integer[] numbers = {5, 2, 9, 1, 4, 7};

      // Wrap the array in the adapter and get a List view of the data
      ArrayAdapter adapter = new ArrayAdapter(numbers);
      List<Integer> list = adapter.toList();
      System.out.println("Before sorting: " + list);

      // Sort the list into ascending order
      Collections.sort(list);
      System.out.println("After sorting: " + list);

      // Remove the value 4 (not the element at index 4).
      // Integer.valueOf() makes Java call remove(Object) instead of
      // remove(int index).
      list.remove(Integer.valueOf(4));
      System.out.println("After removing 4: " + list);

      // Pass the List<Integer> to a method that accepts List<?>
      printList(list);
   }

   // Prints any kind of list. The unbounded wildcard <?> means this
   // method accepts a List of any element type (Integer, String, etc.).
   public static void printList(List<?> list) {
      System.out.println("Printing list using unbounded wildcard: " + list);
   }
}

// Object Adapter: ArrayAdapter HAS-A Integer[] (composition) and adapts
// it to the List<Integer> interface that the rest of the program needs.
class ArrayAdapter {

   // The adaptee: the array being wrapped
   private Integer[] array;

   // Constructor stores the array this adapter wraps
   public ArrayAdapter(Integer[] array) {
      this.array = array;
   }

   // Returns a new, mutable List containing the array's elements
   public List<Integer> toList() {
      // Diamond operator: Java infers <Integer> from the declared type
      List<Integer> list = new ArrayList<>();

      // Copy every element from the array into the list
      Collections.addAll(list, array);
      return list;
   }
}
