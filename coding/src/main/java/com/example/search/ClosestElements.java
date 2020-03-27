package com.example.search;

import java.util.ArrayList;
import java.util.List;

public class ClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int start = 0, end = arr.length-k;
        while(start<end){
            int mid = start + (end-start)/2;
            if(Math.abs(arr[mid]-x)>Math.abs(arr[mid+k]-x)){
                start = mid+1;
            } else {
                end = mid;
            }
        }
        for(int i=start; i<start+k; i++){
            res.add(arr[i]);
        }
        return res;
    }
}
