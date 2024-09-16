import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;


public class Autocomplete {
    // terms to sort
    private final Term[] terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if (terms == null || Arrays.asList(terms).contains(null)) {
            throw new IllegalArgumentException(
                    "Input array cannot be null or contain null entries");
        }
        this.terms = Arrays.copyOf(terms, terms.length);
        Arrays.sort(this.terms);

    }

    // Returns all terms that start with the given prefix,
    // in descending order of weight.
    public Term[] allMatches(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }

        Term queryTerm = new Term(prefix, 0);
        int firstIndex = BinarySearchDeluxe.
                firstIndexOf(terms, queryTerm, Term.byPrefixOrder(prefix.length()));
        int lastIndex = BinarySearchDeluxe.
                lastIndexOf(terms, queryTerm, Term.byPrefixOrder(prefix.length()));

        if (firstIndex == -1 || lastIndex == -1) {
            return new Term[0];  // No matches found
        }

        int numMatches = lastIndex - firstIndex + 1;
        Term[] matches = Arrays.
                copyOfRange(terms, firstIndex, firstIndex + numMatches);
        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }

        Term queryTerm = new Term(prefix, 0);
        int firstIndex = BinarySearchDeluxe.
                firstIndexOf(terms, queryTerm, Term.byPrefixOrder(prefix.length()));
        int lastIndex = BinarySearchDeluxe.
                lastIndexOf(terms, queryTerm, Term.byPrefixOrder(prefix.length()));

        if (firstIndex == -1 || lastIndex == -1) {
            return 0;  // No matches found
        }

        return lastIndex - firstIndex + 1;
    }

    // unit testing (required)
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Term[] terms = new Term[n];
        for (int i = 0; i < n; i++) {
            long weight = in.readLong();
            in.readChar();
            String query = in.readLine();
            terms[i] = new Term(query, weight);
        }

        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            StdOut.printf("%d matches\n", autocomplete.numberOfMatches(prefix));
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}
