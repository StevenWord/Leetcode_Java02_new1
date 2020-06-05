package com.algorithm;

import java.util.Arrays;

public class InterviewQ40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int [] ans = new int [k];
        for(int i=0;i<k;i++){
            ans[i]=arr[i];
        }
        return ans;
    }

}
