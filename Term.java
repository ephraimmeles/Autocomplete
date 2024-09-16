import java.util.Comparator;

public class Term implements Comparable<Term> {
    // initializing the query string for the term
    private final String query;
    // Initializing the weight of the term
    private final long weight;

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        // checking for if the weight is negative and it is throw an exception
        if (weight < 0)
            throw new IllegalArgumentException("weight can't be a negative");
        // checking if the query string is null and if it is throwing an exception
        if (query == null)
            throw new IllegalArgumentException(" Query can't be null");
        // this assigns the terms query and weight to the instant variables
        this.weight = weight;
        this.query = query;
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new ReverseWeightOrder();
    }

    // we need to make a private nested class to implement the Comparator
    private static class ReverseWeightOrder implements Comparator<Term> {
        public int compare(Term x, Term y) {
            // if Term x is less than the wight of term y we return 1
            if (x.weight > y.weight)
                return -1;
                // if the term y is greater than ter x than we return -1
            else if (x.weight < y.weight)
                return 1;
                // this is for when the term x and y are both equal to each
                // other return 0
            else
                return 0;
        }
    }

    // Compares the two terms in lexicographic order,
    // but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) throw new IllegalArgumentException("r cannot be a negative");
        return new PrefixOrder(r);
    }

    // this defines the nested private static class for the PrefixOrder method
    private static class PrefixOrder implements Comparator<Term> {
        private int r; // this is used to store the length of the query

        // this is the constructor for prefix order
        public PrefixOrder(int r) {
            // this is used to initialize r
            this.r = r;
        }

        // this is the method implemeted to compare the two terms in order
        public int compare(Term i, Term j) {
            // checking the length of the query string of term i is less than
            // the prefix length r
            int min = Math.min(i.query.length(), j.query.length());
            int max = Math.max(i.query.length(), j.query.length());
            if (r <= min) {
                for (int k = 0; k < r; k++) {
                    // Compare characters at position k
                    if (i.query.charAt(k) > j.query.charAt(k)) return 1;
                    else if (i.query.charAt(k) < j.query.charAt(k)) return -1;
                }
                return 0;
                // CAT
                // CATAGON
            }
            else if (r >= max) {
                return i.query.compareTo(j.query);
            }
            else {
                for (int k = 0; k < min; k++) {
                    if (i.query.charAt(k) > j.query.charAt(k)) return 1;
                    else if (i.query.charAt(k) < j.query.charAt(k)) return -1;
                }
                return i.query.compareTo(j.query);
            }
        }
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        // we are just comparing the this and that term using the lexicographic
        // order in the query
        return query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return weight + "\t" + query;
    }

    // unit testing (required)
    public static void main(String[] args) {
        // Test constructor with valid arguments
        Term term1 = new Term("apple", 5);
        System.out.println("Term 1: " + term1.toString());
        // Expected output: "5\tapple"

        // // Test constructor with null query (expecting an exception)
        // try {
        //     Term term2 = new Term(null, 3);
        // }
        // catch (IllegalArgumentException e) {
        //     System.out.println("Exception caught");
        //     // Expected output: "Query can't be null"
        // }
        //
        // // Test constructor with negative weight (expecting an exception)
        // try {
        //     Term term3 = new Term("banana", -2);
        // }
        // catch (IllegalArgumentException e) {
        //     System.out.println("Exception caught");
        //     // Expected output: "weight can't be a negative"
        // }

        // Test byReverseWeightOrder method
        Comparator<Term> reverseWeightComparator = Term.byReverseWeightOrder();
        Term term4 = new Term("banana", 3);
        Term term5 = new Term("apple", 5);
        int comparisonResult = reverseWeightComparator.compare(term4, term5);
        System.out.println("Comparison result for reverse weight order: "
                                   + comparisonResult); // Expected output: 1

        // Test byPrefixOrder method
        Comparator<Term> prefixComparator = Term.byPrefixOrder(3);
        int compare = prefixComparator.compare(term4, term5);
        System.out.println(
                "Comparison result for prefix order: " + compare);
        // Expected output: 1

        // Test compareTo method
        int i = term4.compareTo(term5);
        System.out.println("Comparison result for lexicographic order: "
                                   + i); // Expected output: 1
    }
}

