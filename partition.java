import java.util.*;

class partition {

    // Function to calculate the minimum absolute difference
    static int findMinDifference(ArrayList<Integer> arr, int n, 
                                   int sumCalculated, int sumTotal) {
        
        // Base case: if we've considered all elements
        if (n == 0) {
            return Math.abs((sumTotal - sumCalculated) 
                                        - sumCalculated);
        }

        // Include the current element in the subset
        int include = findMinDifference(arr, n - 1, 
                        sumCalculated + arr.get(n - 1), sumTotal);

        // Exclude the current element from the subset
        int exclude = findMinDifference(arr,
                           n - 1, sumCalculated, sumTotal);

        // Return the minimum of both choices
        return Math.min(include, exclude);
    }

    // Function to get the minimum difference
    static int minDifference(ArrayList<Integer> arr) {
        int sumTotal = 0;
        
        // Calculate total sum of the array
        for (int num : arr) {
            sumTotal += num;
        }

        // Call recursive function to find 
        // the minimum difference
        return findMinDifference(arr, 
                           arr.size(), 0, sumTotal);
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr
          = new ArrayList<>(Arrays.asList(1, 6, 11, 5));

        System.out.println(minDifference(arr));
    }
}
