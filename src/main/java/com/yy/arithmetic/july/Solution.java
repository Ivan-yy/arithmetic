package com.yy.arithmetic.july;

/**
 * @author Ivan yu
 * @date 2020/07/24
 */
public class Solution {

    /**
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     * <p>
     * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
     * <p>
     * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
     * 用 N - x 替换黑板上的数字 N 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     * <p>
     * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
     * 输入：2
     * 输出：true
     * 解释：爱丽丝选择 1，鲍勃无法进行操作。
     *
     * @param n
     */
    public static boolean divisorGame(int n) {
        boolean res = false;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                n = n - i;
            }
            res = !res;
        }
        return res;
    }

    /**
     * 给出一个整数数组 A 和一个查询数组 queries。
     *
     * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
     *
     * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
     *
     * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
     *
     *
     *
     * 示例：
     *
     * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
     * 输出：[8,6,2,4]
     * 解释：
     * 开始时，数组为 [1,2,3,4]。
     * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
     * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
     * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
     * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
     * @param A
     * @param queries
     * @return
     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            A[queries[i][1]] += queries[i][0];
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                if(A[j] % 2 == 0){
                    sum += A[j];
                }
            }
            res[i] =sum;
        }
        return A;

    }

    public static void main(String[] args) {
        System.out.println(Solution.divisorGame(2));
    }
}
