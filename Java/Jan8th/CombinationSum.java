package Jan8th;

import java.util.*;

public class CombinationSum {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return res;
    }

    void backtrack(int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                track.add(candidates[i]);
                backtrack(candidates, target, sum + candidates[i], i);
                track.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        (new CombinationSum()).combinationSum(candidates, 7);
    }
}
