package amazonQA;
import java.util.*;
public class CourseRecommdation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseRecommdation c = new CourseRecommdation();
		c.rankedCourses("a");
	}
	// root friend a
	//a have friend {b,c ,d}
	public List<String> getDirectFriendsForUser(String user){
		if(user.equals("a")){
			return Arrays.asList(new String[]{"b","c","d"});
		}
		if(user.equals("b")){
			return Arrays.asList(new String[]{"a","e","f"});
		}
		if(user.endsWith("f")){
			return Arrays.asList(new String[]{"g","h"});
		}
		return new ArrayList<String>();
	}
	//b1,b2,b3,b4,b5,b6,b7
	public List<String> getAttendedCoursesForUser(String user){
		if(user.equals("a")){
			return Arrays.asList(new String[]{"b1","b2"});
		}
		if(user.equals("b")){
			return Arrays.asList(new String[]{"b1","b2","b3","b4"});
		}
		if(user.equals("c")){
			return Arrays.asList(new String[]{"b3","b4","b5"});
		}
		if(user.equals("g")){
			return Arrays.asList(new String[]{"b6","b7","b2"});
		}
		
		return new ArrayList<String>();
	}
	public List<String> rankedCourses(String userId){
		List<String> res = new ArrayList<String>();
		Queue<String> queue = new LinkedList<String>();
		Set<String> set = new HashSet<String>();//keep track of visited friend
		Map<String, Integer> map = new HashMap<String,Integer>();//store courses and its occurences
		queue.offer(userId);
		set.add(userId);
		int level = 0;
		while(!queue.isEmpty()&&level<=3){
			int size = queue.size();
			for(int i=0;i<size;i++){
				String user = queue.poll();//current user
				if(user!=userId){
					List<String> courses = getAttendedCoursesForUser(user);
					for(String j:courses){
						
						map.put(j, map.getOrDefault(j, 0)+1);
					}
				}
				//add user friend to queue exclude visited friend
				for(String friend:getDirectFriendsForUser(user)){
					if(!set.contains(friend)){
						queue.offer(friend);
					}
				}
				level++;
			}
		}
		//sort map
		List<Map.Entry<String , Integer>> list = new ArrayList<Map.Entry<String , Integer>>(map.entrySet());
		Collections.sort(list,(a,b)->b.getValue()-a.getValue());
		for(Map.Entry<String , Integer> entry : list){
			res.add(entry.getKey());
		}
		return res;
	}

}
