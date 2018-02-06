题意：
    输入一串不重复数字（int[] candidates），求等于target（int target）的所有可能结果。

思路：
    典型的backtracking题。
    1，进行helper函数backtracking调用
    2，helper考虑边界条件 -> 何时返回结果 -> for循环递归
    3，注意Target边界请款，返回值判断（target < 0 & target = 0）

复杂度：
     time : O(2^n)
     space : O(n)


class Solution {
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
