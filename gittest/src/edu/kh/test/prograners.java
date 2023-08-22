package edu.kh.test;

import java.util.Arrays;

class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int a = i; a <= j ; a++){
            String str = a+"";
            for(int b = 0; b < str.length(); b++){
                if((char)k+'0' == str.charAt(b)) answer++;
            }
        }
        return answer;
    }
}