package microSoftOA;
import java.util.*;
public class CourseSchedule1 {

	public static void main(String[] args) {
		int[][] pres = {{1,0},{2,0},{3,1},{3,2}};
		CourseSchedule1 c  = new CourseSchedule1();
		c.canFinish(4, pres);
	}
	public boolean canFinish(int numCourses, int[][] pres){
		//because courses is continugous numbers from 0 to numCourses-1,
		//so here we can use list , index is the key of course number
		//for other situation, key can not repsentated as array index,
		//can use Map
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		for(int i=0;i<numCourses;i++){
			graph.add(new ArrayList<Integer>());
		}
		for(int[] pre : pres){
			graph.get(pre[0]).add(pre[1]);
		}
		boolean[] visited = new boolean[numCourses];
		boolean[] checkedVertex = new boolean[numCourses];
	    for(int i=0;i<numCourses;i++){		
	    	if(!checkedVertex[i]&&hasCircle(graph,i,visited,checkedVertex)){
	    		return false;
	    	}
	    }
	    return true;
	}
	private boolean hasCircle(List<List<Integer>> graph, int i,boolean[] visited,boolean[] checkedVertex) {
		//if i has been visited during current recurision , then current recursion forms a circle
		if(visited[i]){
			return true;
		}
		//i has not been visited yet, so far so good ,continue recursion
		visited[i] = true;
		checkedVertex[i] = true;
		for(int neighbor:graph.get(i)){
			if(!checkedVertex[neighbor]&&hasCircle(graph,neighbor,visited,checkedVertex)){
				return true;
			}
		}
		//end of current recursion and no circle found so far, reset visited for next recursipn
		visited[i] = false;
		return false;
	}
	public void topologicalSort(int numCourses, int[][] pres){
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		for(int i=0;i<numCourses;i++){
			graph.add(new ArrayList<Integer>());
		}
		for(int[] pre : pres){
			graph.get(pre[0]).add(pre[1]);
		}
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[numCourses];
		for(int i=0;i<numCourses;i++){
			if(!visited[i])
			topologicalSortDFS(graph, i, visited, stack);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	public void topologicalSortDFS(List<List<Integer>> graph, int vertex, boolean[] visited, Stack<Integer> stack){
		visited[vertex] = true;
		for(int neighbor : graph.get(vertex)){
			if(!visited[neighbor])
			topologicalSortDFS(graph,neighbor,visited,stack);
		}
		stack.push(vertex);
	}

}
