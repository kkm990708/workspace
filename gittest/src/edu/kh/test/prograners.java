package edu.kh.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;



class Solution {
    public int[] solution(int n) {
        TreeSet<Integer> NTreeSet = new TreeSet<Integer>();
        
        for (int i = 2; i <= n; i++) {
 			if (n % i == 0) {
				NTreeSet.add(i);
				if (i == n) break;
				n /= i;
				i = 2;
			}
		}
        
        ArrayList<Integer> temp2 = new ArrayList<>(NTreeSet);
        Arrays.sort(temp2);
        Object[] temp = NTreeSet.toArray();
        int[] answer = new int[temp.length];
        
        for (int i = 0; i < answer.length; i++) {
			answer[i] = (int)temp[i];
		}
        return answer;
        
    }
}