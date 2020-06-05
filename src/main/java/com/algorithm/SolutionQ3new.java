package com.algorithm;

import java.util.HashMap;

public class SolutionQ3new {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null)
            return 0;
        HashMap<Character,Integer> map =new HashMap<Character, Integer>();
        int length = 0;
        int maxLength = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                length++;
                map.put(s.charAt(i),i);
                if(maxLength<length)
                    maxLength = length;
            }
            else {
                if(maxLength<length)
                    maxLength = length;
                int k = map.get(s.charAt(i));
                for(int j=start;j<=k;j++)
                    map.remove(s.charAt(j));
                start = k+1;
                length = i-start+1;
                map.put(s.charAt(i),i);
            }
        }
        return maxLength;
    }
}
