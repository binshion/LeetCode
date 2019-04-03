public class SpiralMatrixII_59 {
    public static void main(String[] args) {
        Solution_59 solution = new Solution_59();
        int[][] result = solution.generateMatrix(4);
    }
}

/**
 * 填充方向循环遵循：右下左上
 * 右填充完成后，记录上方填充完1行
 * 下填充完成后，记录右方填充完1列
 * 左填充完成后，记录下方填充完1行
 * 上填充完成后，记录左方填充完1列
 * 当前位置索引需要在填充范围边界去比较
 */
class Solution_59{
    public int[][] generateMatrix(int n) {
        String[] sortDirection = new String[]{"right", "down", "left", "up"};  //右下左上填充方向
        int[] usedLine = new int[]{0, 0, 0 ,0};  // 右下左上已填充完成的行数或列数
        int[][] result = new int[n][n];


        int last = n * n;  //末尾值
        result[0][0] = 1;  //首位值
        int i= 0;  //当前填充索引行
        int j = 0;  //当前填充索引列

        String currentDtrection = "right";  //当前填充方向，首次为右填充
        int current = 2;  //下一个需要填充的数据，用于下次循环当成第一个填充位置点
        while (current <= last) {
            if (currentDtrection.equals(sortDirection[0])) {  //向右填充时
                while (++j < n - usedLine[0]) {  //列号在已填充右侧列数范围内
                    result[i][j] = current++;
                }
                usedLine[3] = usedLine[3] + 1;  //填充完成后标记上方已填充完一行
                currentDtrection = sortDirection[1];  //下一填充方向为下
                j--;  //内层while循环导致的数据增加，回退一次
            }

            if (currentDtrection.equals(sortDirection[1])) {  //向下填充时
                while (++i < n - usedLine[1]) {
                    result[i][j] = current++;
                }
                usedLine[0] = usedLine[0] + 1;
                currentDtrection = sortDirection[2];
                i--;
            }

            if (currentDtrection.equals(sortDirection[2])) {  //向左填充时
                while (--j >= usedLine[2]) {
                    result[i][j] = current++;
                }
                usedLine[1] = usedLine[1] + 1;
                currentDtrection = sortDirection[3];
                j++;
            }

            if (currentDtrection.equals(sortDirection[3])) {  //向上填充时
                while (--i >= usedLine[3]) {
                    result[i][j] = current++;
                }
                usedLine[2] = usedLine[2] + 1;
                currentDtrection = sortDirection[0];
                i++;
            }
        }
        return result;
    }
}
