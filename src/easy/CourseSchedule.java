package easy;

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {
		CourseSchedule sche= new CourseSchedule();
		int[][] arr={{0,1}};
		sche.canFinish(2, arr);
	}

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
    	ArrayList[] graph = new ArrayList[prerequisites.length];
		for(int i=0;i<graph.length;i++){
			graph[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<prerequisites.length;i++){
			graph[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		boolean[] visited  = new boolean[numCourses];
		for(int i=0;i<numCourses;i++){
			if(!dfs(graph,i,visited)) return false;
		}
		return true;
		
    }
	private boolean dfs(ArrayList[] graph, int i, boolean[] visited) {
		if(visited[i]==true) return false;
		visited[i]=true;
		for(int j=0;i<graph[i].size();i++){
			if(!dfs(graph,(int)graph[i].get(j),visited)) return false;
		}
		visited[i]=false;
		return false;
	}

	private boolean dfs_cycle(Map<Integer, Set<Integer>> graph,boolean[] onpath, boolean[] visited, Integer key) {
		if(visited[key]) return false;
		visited[key] = true;
		onpath[key]=true;
		for(Integer neighbor : graph.get(key)){
			if(onpath[neighbor]||dfs_cycle(graph,onpath,visited,neighbor)) return true;
		}
		onpath[key] = false;
		return false;
	}
	public int[] canFinish(int numCourses, int[][] prerequisites){
		ArrayList<Integer> res =new ArrayList<Integer>();
		ArrayList[] graph = new ArrayList[numCourses];
		int[] indegree  = new int[numCourses];
		for(int i=0;i<graph.length;i++){
			graph[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<prerequisites.length;i++){
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
			indegree[prerequisites[i][0]]++;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<indegree.length;i++){
			if(indegree[i]==0){
				queue.offer(i);
			}
		}
		int count=0;
		while(!queue.isEmpty()){
			int course = queue.poll();
			res.add(course);
			count++;
			for(int i=0;i<graph[course].size();i++){
				int neighbor = (int) graph[course].get(i);
				indegree[neighbor]--;
				if(indegree[neighbor]==0){
					queue.offer(neighbor);
				}
			}
		}
		if(res.size()==numCourses){
			int[] arr = new int[res.size()];
			for(int i=0;i<arr.length;i++){
				arr[i]=res.get(i);
			}
			return arr;
		}else{
			return new int[0];
		}
		
	}

}
