import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RLEIterator_900 {
    int[] A;
    int indexOfPosition;
    int usedTime;
    public RLEIterator_900(int[] A) {
        this.A = A;
        indexOfPosition = 0;
        usedTime = 0;
    }

    public int next(int n) {
        int currentPosition = indexOfPosition;
        if (indexOfPosition + 1 >= A.length || A[indexOfPosition + 1] < 0) {  //奇数位没有数据或者奇数位数据为负整数
            return -1;
        }

        int lastUsedTime = A[currentPosition] - usedTime;
        int currentLast = n;
        while (currentLast > 0) {
            if (lastUsedTime == 0) {
                if (currentPosition < A.length && A[currentPosition] >= 0) {  //+3表示下一个坐标位的取数，是否存在
                    currentPosition += 2;
                    if (currentPosition < A.length) {
                        lastUsedTime = A[currentPosition];
                    } else {
                        return -1;
                    }

                } else {
                    return -1;
                }
            } else {
                if (currentLast - lastUsedTime > 0) {  //剩余次数在当前下标处理不完，需要切换到下一个坐标
                    currentLast -= lastUsedTime;
                    lastUsedTime = 0;
                } else if (currentLast - lastUsedTime < 0) {
                    lastUsedTime -= currentLast;
                    currentLast = 0;

                    indexOfPosition = currentPosition;
                    usedTime = A[indexOfPosition] - lastUsedTime;
                } else {
                    usedTime = A[indexOfPosition];
                    indexOfPosition = currentPosition;
                    currentLast = 0;
                }
            }
        }

        return A[currentPosition + 1];
    }

    public static void main(String[] args) {
//        RLEIterator_900 rleIterator = new RLEIterator_900(new int[]{923381016,843,898173122,924,540599925,391,705283400,275,811628709,850,895038968,590,949764874,580,450563107,660,996257840,917,793325084,82});
//        int[] a = new int[]{612783106,486444202,630147341,845077576,243035623,731489221,117134294,220460537,794582972,332536150,815913097,100607521};

//        RLEIterator_900 rleIterator = new RLEIterator_900(new int[]{3,8,0,9,2,5});
//        int[] a = new int[]{2,6,1,8};


        RLEIterator_900 rleIterator = new RLEIterator_900(new int[]{635,606,576,391,370,981,36,21,961,185,
                                                                    124,210,801,937,22,426,101,260,221,647,
                                                                    350,180,504,39,101,989,199,358,732,839,
                                                                    919,169,673,967,58,676,846,342,250,597,
                                                                    442,174,472,410,569,509,311,357,838,251});
        int[] a = new int[]{5039,62,3640,671,67,395,262,839,74,43,
                            42,77,13,6,3,1,1,1,1,1,
                            1,1,1,1,1,1,1,1,1,1,
                            1,1,1,1,1,1,1,1,1,1,
                            1,1,1,1,1,1,1,1,1,1};


        List result = new ArrayList();
        result.add(null);
        for (int i = 0; i < a.length; i++) {
            int temp = rleIterator.next(a[i]);
            result.add(temp);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}

class RLEIterator {
    int[] A;
    int i, q;

    public RLEIterator(int[] A) {
        this.A = A;
        i = q = 0;
    }

    public int next(int n) {
        while (i < A.length) {
            if (q + n > A[i]) {
                n -= A[i] - q;
                q = 0;
                i += 2;
            } else {
                q += n;
                return A[i+1];
            }
        }

        return -1;
    }
}
