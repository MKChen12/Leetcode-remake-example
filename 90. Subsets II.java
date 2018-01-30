题意：
    输入一串可重复得数字（int[] nums），求数组nums（int[] nums）的所有不重复子集。
    78. Subsets 的follow up, 输入的数组的每个数字能重复出现，但是子集不能重复出现
       
思路：
    典型的backtracking题。
    1，进行helper函数backtracking调用
    2，nums会有重复（duplicate) ，开始要对数组进行排序（sort），以便在helper函数去重判断 
    3，helper考虑边界条件 -> 何时返回结果 -> for循环递归
    4，for循环中,注意 if去重的判断条件
         
复杂度：
     time : O(2^n)
     space : O(n)
         
class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
