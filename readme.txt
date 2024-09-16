Programming Assignment 3: Autocomplete


/* *****************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that is equal to the search key.
 **************************************************************************** */
It enters a loop that continues as long as low is less than or equal to high.
In each iteration, it calculates the middle index mid.
It compares the key at the middle index with the search key using the provided comparator.
If the key at mid is equal to the search key, it updates result to mid and continues
the search in the lower half by setting high to mid - 1.
If the key at mid is less than the search key, the search continues in the upper
 half by setting low to mid + 1.
If the key at mid is greater than the search key, the search continues in the
lower half by setting high to mid - 1.
The loop terminates when low is greater than high.
If the search key is found at least once in the array, the result variable
 contains the index of the first occurrence.
If the search key is not found, result remains at its initialized value,
indicating that the key is not present.


/* *****************************************************************************
 *  Identify which sorting algorithm (if any) that your program uses in the
 *  Autocomplete constructor and instance methods. Choose from the following
 *  options:
 *
 *    none, selection sort, insertion sort, mergesort, quicksort, heapsort
 *
 *  If you are using an optimized implementation, such as Arrays.sort(),
 *  select the principal algorithm.
 **************************************************************************** */

Autocomplete() : Dual Pivot Quick-Sort --> Arrays.sort()

allMatches() : Dual Pivot Quick-Sort --> Arrays.sort()

numberOfMatches() : Assumes sorted array --> none (doesn't sort)

/* *****************************************************************************
 *  How many compares (in the worst case) does each of the operations in the
 *  Autocomplete data type make, as a function of both the number of terms n
 *  and the number of matching terms m? Use Big Theta notation to simplify
 *  your answers.
 *
 *  Recall that with Big Theta notation, you should discard both the
 *  leading coefficients and lower-order terms, e.g., Theta(m^2 + m log n).
 **************************************************************************** */

Autocomplete():     Theta(n log n)

allMatches():       Theta(log n + m log m)

numberOfMatches():  Theta(log n )



/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */



/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */
none



/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */
We enjoyed this assignment
