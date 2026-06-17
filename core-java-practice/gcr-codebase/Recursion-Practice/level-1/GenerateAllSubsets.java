import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsets {
    
    public static List<List<Integer>> generateSubsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsetsHelper(arr, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void generateSubsetsHelper(int[] arr, int index, 
                                              List<Integer> current, 
                                              List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            
            generateSubsetsHelper(arr, i + 1, current, result);
            
            current.remove(current.size() - 1);
        }
    }
    
    public static List<List<Integer>> generateSubsetsBitwise(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int totalSubsets = 1 << arr.length; // 2^n subsets
        
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                // Check if jth bit is set in i
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
    
    private static void printSubsets(List<List<Integer>> subsets) {
        System.out.println("{");
        for (int i = 0; i < subsets.size(); i++) {
            System.out.print("  " + subsets.get(i));
            if (i < subsets.size() - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("}");
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {5};
        
        System.out.println("All subsets of [1, 2]:");
        List<List<Integer>> subsets1 = generateSubsets(arr1);
        printSubsets(subsets1);
        System.out.println("Total subsets: " + subsets1.size());
        
        System.out.println("\nAll subsets of [1, 2, 3]:");
        List<List<Integer>> subsets2 = generateSubsets(arr2);
        printSubsets(subsets2);
        System.out.println("Total subsets: " + subsets2.size());
        
        System.out.println("\nAll subsets of [5]:");
        List<List<Integer>> subsets3 = generateSubsets(arr3);
        printSubsets(subsets3);
        System.out.println("Total subsets: " + subsets3.size());
        
        System.out.println("\n--- Using Bitwise Approach ---");
        System.out.println("All subsets of [1, 2] (bitwise):");
        List<List<Integer>> subsetsBitwise = generateSubsetsBitwise(arr1);
        printSubsets(subsetsBitwise);
    }
}
