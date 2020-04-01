package algorithm;

import java.util.HashMap;
import java.util.Iterator;

public class Ex11 {
	
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		Ex11 ex = new Ex11();
		System.out.println(ex.solution(clothes));
	}
	
	
	
	public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> ans = new HashMap<String, Integer>();
        ans.put(clothes[0][1], 1);
        for(int i=1;i<clothes.length;i++) {
        	if(ans.containsKey(clothes[i][1])) {
        		ans.put(clothes[i][1], ans.get(clothes[i][1])+1);
        	}else {
        		ans.put(clothes[i][1], 1);
        	}
        }
        int[] dap = new int[ans.size()];
        Iterator<String> key = ans.keySet().iterator();
        int i=0;
        while(key.hasNext()) {
        	String temp = key.next();
        	dap[i++]=ans.get(temp);
        }
        for(int j=0;j<dap.length;j++) {
        	answer += dap[j];
        }
      
        
        
        
        return answer;
    }
}
