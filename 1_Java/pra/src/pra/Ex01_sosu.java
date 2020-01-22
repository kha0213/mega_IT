package pra;



public class Ex01_sosu {
	public static void main(String[] args) {
		Ex01_sosu ex = new Ex01_sosu();

		String[] a = { "leo", "kiki", "eden"};
		String[] b = { "eden", "kiki"};
		
		
		
		StringBuilder sb = new StringBuilder("leokikieden");
		sb.delete(sb.indexOf("kiki"), sb.indexOf("kiki")+4);
		sb.delete(sb.indexOf("eden"), sb.indexOf("eden")+4);
		System.out.println(sb.indexOf("dl")+" "+sb.toString());
		
//		System.out.println(ex.solution(a, b));
	}

	 public String solution(String[] participant, String[] completion) {
	     StringBuilder sPar = new StringBuilder("");   
	     for(int i=0;i<participant.length;i++) {
	     sPar.append(participant[i]);
	     }
	     for(int i=0;i<completion.length;i++) {
	    	 if(sPar.indexOf(completion[i])==-1) {
	    		 return completion[i];
	    	 }else {
	    		 sPar.delete(sPar.indexOf(completion[i]), sPar.indexOf(completion[i])+completion.length-1);
	    	 }
	     }
	     return sPar.toString();
	    }

}
