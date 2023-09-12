package edu.kh.test;

import java.util.ArrayList;  
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;



class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int count = 1;
        int number = 0;
        while(true){
            if(number > numbers.length)
            
            
            

            if(count == k) {
                answer = number;    
            }
            number += 2;
            count++;
        }   
        return answer;
    }
}