import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int
    firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        int lo = 0;
        int hi = a.length - 1;
        int firstIndex = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = comparator.compare(key, a[mid]);

            if (cmp == 0) {
                firstIndex = mid;
                hi = mid - 1; // Continue searching on the left side
            }
            else if (cmp < 0) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }

        return firstIndex;
    }

    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        int lo = 0;
        int hi = a.length - 1;
        int lastIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = comparator.compare(key, a[mid]);

            if (cmp == 0) {
                lastIndex = mid;
                lo = mid + 1;
            }
            else if (cmp < 0) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
            // For last occurrence:
            // For first occurrence:
            // high = mid - 1;
        }

        return lastIndex;

    }

    // unit testing (required)
    public static void main(String[] args) {
        Integer[] array = { 1, 2, 2, 2, 3, 4, 4, 5, 6, 7 };

        System.out.println("First Index of 2: " +
                                   firstIndexOf(array, 2, Comparator.naturalOrder()));
        System.out.println("Last Index of 4: " +
                                   lastIndexOf(array, 4, Comparator.naturalOrder()));
    }
}

