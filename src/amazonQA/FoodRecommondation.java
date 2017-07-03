package amazonQA;
import java.util.*;
/*given 2 list*/
public class FoodRecommondation {

	public static void main(String[] args) {
		Map<String,String> peference = new HashMap<String,String>();
		Map<String,Set<String>> dish = new HashMap<String,Set<String>>();
		peference.put("a", "1");
		peference.put("b", "2");
		Set<String> food = new HashSet<String>();
		food.add("aa");
		food.add("bb");
		dish.put("1", food);
		Set<String> food2 = new HashSet<String>();
		food2.add("cc");
		food2.add("dd");
		dish.put("1", food);
		dish.put("2", food2);
		FoodRecommondation f = new FoodRecommondation();
		f.getRecommadation(peference, dish);
	}
	public Map<String, Set<String>> getRecommadation(Map<String,String> peference, Map<String,Set<String>> dish){
		Map<String, Set<String>> res = new HashMap<String,Set<String>>();
		for(Map.Entry<String, String> entry:peference.entrySet()){
			String cusine = entry.getValue();
			Set<String> recom = new HashSet<String>();
			recom.addAll(dish.get(cusine));
			res.put(entry.getValue(), recom);
		}
		return res;
	}

}
