package edu.kh.test;

import java.util.Arrays;

public class prograners {
	public static void main(String[] args) {
	}



}

class Solution {
    public int solution(int[] sides) {
    	int max = 0;
    	int sum = 0;
    	for (int i : sides) {
    		sum += i;
			if (i > max) {
				max = i;
			}
		}
    	sum -= max;
    	if (max > sum) {
			return 1;
		}
    	return 2;
    }
}