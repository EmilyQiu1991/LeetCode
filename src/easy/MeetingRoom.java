package easy;
import java.util.*;
public class MeetingRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		 }
	//[0, 30],[5, 10],[15, 20]
	 public boolean canAttendMeetings(Interval[] intervals) {
	        Arrays.sort(intervals,(a,b)->a.start-b.start);//sort intervals based on start 
	        int latestEnd = intervals[0].end;
	        for(int i =1; i<intervals.length;i++){
	        	
	        	if(intervals[i].start<latestEnd){
	        		return false;
	        	}
	        	latestEnd = Math.max(latestEnd, intervals[i].end);
	        }
	        return true;
	        
	 }
	 public List<Interval> merge(List<Interval> intervals) {
		 List<Interval> res = new ArrayList<Interval>();
	        //[1,3],[2,6],[8,10],[15,18]
		 Collections.sort(intervals,(a,b)->a.start-b.start);
		 Interval pre = intervals.get(0);
		 for(int i=1;i<intervals.size();i++){
			 if(intervals.get(i).start<=pre.end){
				 pre.end= Math.max(pre.end, intervals.get(i).end);
			 }else{
				 res.add(pre);
				 pre = intervals.get(i);
			 }
		 }
		 //don't forget add pre to res
		 res.add(pre);
		 return res;
	 }

}
