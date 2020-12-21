package nds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class N1 {
	
	public static void main(String[] args) {
		String[] movie = {"spy", "ray", "spy", "room", "once", "ray", "spy", "once"};
		
//        return ans;
		Map<String, Integer> movies = new TreeMap<>();
		for (int i = 0; i < movie.length; i++) {
			if(!movies.containsKey(movie[i])) {
				movies.put(movie[i], 1);
			}else {
				int cnt = movies.get(movie[i]);
				movies.put(movie[i], cnt+1);
			}
		}
		List<Entry<String, Integer>> movie_list = new ArrayList<Entry<String, Integer>>(movies.entrySet());
		Collections.sort(movie_list, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
			{
				// 내림 차순으로 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		String[] ans = new String[movie_list.size()];
		for (int i = 0; i < movie_list.size(); i++) {
			ans[i] = movie_list.get(i).getKey();
		}
		System.out.println(Arrays.toString(ans));
		for(Entry<String, Integer> entry : movie_list) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
//		Object[] ans = movies.keySet().toArray();
//		Arrays.sort(ans);
//		System.out.println(Arrays.toString(ans));
		
		for (String key : movies.keySet()) {
			int value = movies.get(key);
			System.out.println(key+" "+value);
		}
		
//        System.out.println(Arrays.toString(movie));
//        System.out.println();
	}
}
