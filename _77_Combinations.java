package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : Combinations
 * Creator : Edward
 * Description : 77. Combinations
 */
public class Combinations {

    /**
     Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

     For example,
     If n = 4 and k = 2, a solution is:

     [
     [2,4],
     [3,4],
     [2,3],
     [1,2],
     [1,3],
     [1,4],
     ]
     [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

     
     视频错误: helper(res, new ArrayList<>(), n, k, 1); helper 第一调用的时候 start 值为0
     注：代码已更正
     
     题意：
         输入一串从1到n的数字（ 1 ... n ）, 求长度为k的排列组合。（相当于从n个不同元素中，任取出k个元素的排列组合）
       
     思路：
         典型的backtracking题。
         1，进行helper函数backtracking调用
         2，因为 input是从1到n的整数（ 1 ... n ），所以第一次调用helper函数, start 值为 1 
         3，helper考虑边界条件 -> 何时返回结果 ( i <= n ) -> for循环递归
         4，k考虑边界条件 -> 何时输出结果 (k = 0)
  
     复杂度：
         time : O(n^min{k,n-k})
         space : O(n);
         http://stackoverflow.com/questions/31120402/complexity-when-generating-all-combinations
     
     * @param n
     * @param k
     * @return
     */

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(res, list, n, k - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
