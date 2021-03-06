package p100.p0074;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * <p>
 * Copyright: Copyright (c) 2020/7/6 22:34
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 *
 * @author yunmeng.li@successchannel.com
 * @version 1.0.0
 */
public class Solution {

    /**
     * 思路：数据是排过序的，考虑用二分法。
     * 数组是二维的，先找row的mid，在mid的row上找col的mid，如果一个col上都没有找到，根据比较大小改变row的大小。
     * 运行结果 -> 时间击败100% Java，空间94%. :)
     * 一开始其实没有清晰的思路实现二维二分法，想着先做个一维的二分练练手，再去看答案。做着做着发现有思路了，所以不要想太多，
     * 有思路了就先敲代码，遇到具体的问题再解决。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int leftRow = 0;
        int rightRow = row - 1;
        while (leftRow <= rightRow) {
            int midRow = leftRow + (rightRow - leftRow) / 2;
            int leftCol = 0;
            int rightCol = col - 1;
            boolean bigger = false;
            while (leftCol <= rightCol) {
                int midCol = leftCol + (rightCol - leftCol) / 2;
                int matrix1 = matrix[midRow][midCol];
                if (matrix1 == target) {
                    return true;
                } else if (matrix1 > target) {
                    rightCol = midCol - 1;
                    bigger = true;
                } else {
                    leftCol = midCol + 1;
                    bigger = false;
                }
            }

            if (bigger) {
                rightRow = midRow - 1;
            } else {
                leftRow = midRow + 1;
            }
        }
        return false;
    }
}
