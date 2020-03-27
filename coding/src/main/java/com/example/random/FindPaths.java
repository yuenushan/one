package com.example.random;

public class FindPaths {
    /**
     *
     给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。
     但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/out-of-boundary-paths
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param m
     * @param n
     * @param N
     * @param i
     * @param j
     * @return
     */

    private Long[][][] table;

    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) {
            return 0;
        }
        table = new Long[m][n][N + 1];
        return (int) findPathsCore(m, n, N, i, j);
    }

    private long findPathsCore(int m, int n, int N, int i, int j) {
        if (N <= 0) {
            return 0;
        }
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        if (table[i][j][N] != null) {
            return table[i][j][N];
        }
        long sum = 0;
        if (i - 1 < 0) {
            sum++;
        }
        if (i + 1 >= m) {
            sum++;
        }
        if (j - 1 < 0) {
            sum++;
        }
        if (j + 1 >= n) {
            sum++;
        }
        sum += findPathsCore(m, n, N - 1, i - 1, j) + findPathsCore(m, n, N - 1, i + 1, j)
                + findPathsCore(m, n, N - 1, i, j - 1) + findPathsCore(m, n, N - 1, i, j + 1);
        sum = (long) (sum % (Math.pow(10, 9) + 7));
        table[i][j][N] = sum;
        return sum;
    }

    public static void main(String[] args) {
//        int m = 2, n = 2, N = 200, i = 0, j = 0;
        int m = 8, n = 50, N = 23, i = 5, j = 26;
        System.out.println(new FindPaths().findPaths(m, n, N, i, j));
    }
}
