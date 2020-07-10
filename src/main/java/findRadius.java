import org.junit.Test;
import org.omg.PortableInterceptor.HOLDING;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 冬季已经来临。你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 */
public class findRadius {

    /**
     * 房屋数组中存放的就是房屋所在的位置
     * 暖气数组中存放的是暖气所在的位置 不一定有序
     * 找到在每一个位置上 距离这个位置最近的供暖器 最后返回所有需要的半径中的最大值
     * 查找每个位置需要的最小半径 可以使用二分查找法
     * @param houses
     * @param heaters
     * @return
     */
    public int result(int [] houses,int [] heaters){
        int res=0;
        int n=heaters.length;
        Arrays.sort(heaters);
        for(int house:houses){
            int left=0;
            int right=n;
            while (left < right) {//通过二分查找一直逼近到当前房屋最近的加热器值
                int mid=left+(right-left)/2;
                if(house<heaters[mid]){
                    left=mid+1;
                }else{ ///当房屋所在位置小于或者等于加热器所在位置 right=mid 所以最终 最接近房屋位置的加热器一定是right或者right-1
                    right=mid;
                }
            }
            //考虑到right在最左或者最右的情况
            int dist1=right==0?Integer.MAX_VALUE:Math.abs(house-heaters[right-1]);
            int dist2= right==n? Integer.MAX_VALUE:Math.abs(house-heaters[right]);
            res=Math.max(res,Math.min(dist1,dist2));//返回结果是所有距离中的最长距离
        }

        return res;

    }


    @Test
    public void test(){


        int [] houses={1,2,3};
        int [] heaters={2};
        int result = result(houses, heaters);
        System.out.println(result);

    }
}
