package com.sort;

public class BinarySearch {
    public int binnarySearch(int [] a,int left,int right,int target){
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
}
