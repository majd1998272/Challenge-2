
package challenge.pkg1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Challenge1 {
   public static List<int[]> findAllIndexPairs(int[] nums, int target) {
        List<int[]> pairs = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                List<Integer> complementIndices = map.get(complement);
                for (int index : complementIndices) {
                    pairs.add(new int[] {index, i});
                }
            }
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        return pairs;
    }

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();
        
        List<int[]> pairs = findAllIndexPairs(nums, target);
        if (pairs.isEmpty()) {
            System.out.println("No such pair exists.");
        } else {
            System.out.println("Index pairs whose sum equals the target:");
            for (int[] pair : pairs) {
                System.out.println(Arrays.toString(pair));
            }
        }
        
        scanner.close();
    }
}