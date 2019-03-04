public class ProductOfArrayExceptSelf_238 {
    public static void main(String[] args) {
        Solution_238 solution = new Solution_238();
        int[] result = solution.productExceptSelf(new int[]{0,0});

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

/**
 * 计算除自己外的数组乘积
 * 1.不含0时，总积 / 当前元素
 * 2.含一个0 时，为0 的位置结果不为零，其他都为0
 * 3.含一个以上的0时，全部为0；
 */
class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        int products = 1;  //乘积
        int numOfZero = 0;  //元素为0的个数
        int productsWithOneZero = 1;  //元素为0的个数为1时，其他元素的乘积
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numOfZero++;
                productsWithOneZero = products;
            }

            if (numOfZero > 1) {  //含1个以上的0 时，全部为0，退出循环
                products = 0;
                break;
            }

            if (numOfZero == 1 && nums[i] != 0) {  //含一个0时计算除此以外的累乘
                productsWithOneZero *= nums[i];
            }
            products *= nums[i];
        }

        if (numOfZero == 1 && nums.length == 1) {  //数组只有一个元素且为0，  条件已经说明nums.length > 1
            productsWithOneZero = 0;
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[i] = products / nums[i];
            } else {
                if (numOfZero == 1) {
                    result[i] = productsWithOneZero;
                } else {
                    result[i] = 0;
                }
            }
        }

        return result;
    }
}
