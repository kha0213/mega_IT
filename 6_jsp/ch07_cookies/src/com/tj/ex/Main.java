package com.tj.ex;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	
	
	
	 public String solution(String[] participant, String[] completion) {
	        Arrays.sort(participant);
	        Arrays.sort(completion);
	        for(int i=0;i<completion.length;i++) {
	        	if(!participant[i].equals(participant[i])) {
	        		return participant[i];
	        	}
	        }
	        
			
	        return participant[participant.length-1];
	    }
}
