     题意：
         输入一串不重复数字（int[] nums），求数组nums集合（int[] nums）的所有子集。
       
     
     思路：
         典型的backtracking题。
           1，进行helper函数backtracking调用
           2，因为有空集的情况，所以第一次调用helper函数, new new ArrayList<>(list)会被加入到res
           3，helper考虑边界条件 -> 何时返回结果 -> for循环递归
           4，for循环中,注意 i = index,也就是说 当前的的数指向的是数组的哪个一个位置
     复杂度：
         time : O(2^n)
         space : O(n)


class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
