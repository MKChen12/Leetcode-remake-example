题意：
    从1...9中，选出k个数，且和为n的所有不重复子集。 
    40. Combination Sum II 的变形。
    不同点1：输入范围限制为1...9 (Note: 40题input是： 从1..n)
    不同点2：输出结果的数组长度有限制 (长度为 K )
     
思路：
    典型的backtracking题。
    1，进行helper函数backtracking调用
    2，helper考虑边界条件 -> 何时返回结果 -> for循环递归
    3，helper注意边界条件 -> 要同时满足 数组长度为k（考虑 > k & <= k 的分情况讨论）&& 数组元素的和为n     
         
复杂度：
    time : O(2^n)
    space : O(n)


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <=9; i++) {
            list.add(i);
            helper(res, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
