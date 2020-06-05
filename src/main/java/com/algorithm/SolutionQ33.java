package com.algorithm;

public class SolutionQ33 {
    public static int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        int smallest = findSmallest(nums);
        System.out.println("最小的数位置是："+smallest+"其值是："+nums[smallest]);
        if(nums[0]==target)
            return 0;
        else if(smallest==0)
            return binnarySearch(nums,0,nums.length-1,target);
        else if(nums[0]<target)
            return binnarySearch(nums,0,smallest-1,target);
        else if(nums[0]>target)
            return binnarySearch(nums,smallest,nums.length-1,target);
        return -1;
    }

    public static int binnarySearch(int [] a,int left,int right,int target){
       while(left<=right){
            int middle = (left+right)/2;
            if(a[middle]==target)
                return middle;
            else if(a[middle]<target){
                left = middle+1;
            }
            else if(a[middle]>target){
                right = middle-1;
            }

        }
        return -1;
    }
    public static int findSmallest(int []a){
        int left = 0;
        int right = a.length-1;
        while(left+1<right){
            int middle = (left+right)/2;
            if(a[middle]>a[left])
                left = middle;
            else if(a[middle]<right)
                right = middle;
        }
        if(a[left]<a[right])
            return left;
        else return right;

    }
}
