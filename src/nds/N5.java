package nds;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class N5 {

	public static void main(String[] args) {
		int K = 1;
		String[] user_scores = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
		
		int answer = 0;
        LinkedList<Info> list = new LinkedList<>();
        
        for (int i = 0, len = user_scores.length; i < len; i++) {
           StringTokenizer st = new StringTokenizer(user_scores[i], " ");
           String name = st.nextToken();
           int score = Integer.parseInt(st.nextToken());
           
           if (i == 0) {
              list.add(new Info(name, score));
              K--;
              answer++;
              continue;
           }
           
           int nameIdx = 0, scoreIdx = 0;
           boolean nameFlag = false, scoreFlag = false;
           
           for (int j = 0, size = list.size(); j < size; j++) {
        	   if (nameFlag && scoreFlag) break;
              
	            if (!scoreFlag && list.get(j).score < score) {
	               scoreFlag = true;
	               scoreIdx = j;
	            }
	            
	            if (list.get(j).name.equals(name)) {
	               nameFlag = true;
	               nameIdx = j;
	            }
           }
           
           if (nameFlag && scoreFlag && nameIdx >= scoreIdx) {
              list.remove(nameIdx);
              list.add(scoreIdx, new Info(name, score));

              if (nameIdx != scoreIdx) answer++;
           } else if (!nameFlag && scoreFlag) {
              list.add(scoreIdx, new Info(name, score));
              K--;
              
              if (K < 0) {
                 list.remove(list.size()-1);
                 K++;
              }
              
              answer++;
           } else if (!nameFlag && !scoreFlag && K > 0) {
              list.add(new Info(name, score));
              K--;
              
              answer++;
           }
      }
        
     System.out.println(answer);
    }
    
    public class Info {
       String name;
       int score;
       
       public Info(String name, int score) {
          this.name = name;
          this.score = score;
       }
    }
}