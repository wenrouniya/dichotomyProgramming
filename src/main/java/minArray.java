import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。你可以假设数组中不存在重复元素。
 * 分析：思路二分查找
 *
 *
 */
public class minArray {

    public static int result(int[] nums){
        int len=nums.length;
        int left=0;
        int right=len-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]>nums[right]){//mid及mid以左边的元素都是大于mid的 所以mid的 所以mid以左不可能是数组的最小值
                left=mid+1;
            }else if(nums[mid]==nums[right]){ //有重复的情况跳过这些值
                right--;
            }else{
                right=mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int [] nums1={4,5,6,7,0,1,2};
        int [] nums={4,5,6,7,7,7,7,0,1,2,3};
        int result = result(nums);
        System.out.println(result);


    }
}
