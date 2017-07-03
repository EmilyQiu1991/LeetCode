package easy;
import java.util.*;
/**
 * @author qiuyu
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges
 * write a function to find the number of connected components in an undirected graph
 */
public class NumberOfConnectedGraph {

	public static void main(String[] args) {
		int[][] edges ={{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		int n=10;
		System.out.println(canFinish(n,edges));

	}
	public static Map<Integer,Set<Integer>> initializeGraph(int n,int[][] edges){
		
		Map<Integer,Set<Integer>> neighbors= new HashMap<Integer,Set<Integer>>();
		for(int i=0;i<n;i++){
			neighbors.put(i, new HashSet<Integer>());
		}
		for(int i=0;i<edges.length;i++){
			neighbors.get(edges[i][0]).add(edges[i][1]);		
		}
		return neighbors;
	}
	public static int numberOfConnectedGraph(int n,int[][] edges){
		if(edges==null||edges.length==0) return 0;
		Map<Integer,Set<Integer>> neighbors= initializeGraph(n,edges);
		Queue<Integer[]> queue= new LinkedList<Integer[]>();
		queue.offer(new Integer{1,2});
		boolean[] visited=new boolean[n];
		int count=0;
		for(int i=0;i<){
			count++;
			while(!queue.isEmpty()){
				int node= queue.poll();
				
				for(int neighbor:neighbors.remove(node)){
					if(neighbors.containsKey(neighbor)){
						queue.offer(neighbor);
					}
				}
			}
		}
		return count;
	}
	public boolean courseSchedule(int n,int[][] prerequistites){
		Map<Integer,Set<Integer>> neighbors= initializeGraph(n,prerequistites);
		boolean[] visited= new boolean[n];
		Queue<Integer> queue= new LinkedList<Integer>();
		
		for(int i=0;i<n;i++){
			if(!visited[i]){
				queue.offer(i);
				while(!queue.isEmpty()){
					int node= queue.poll();
					for(int neighbor:neighbors.get(node)){
						if(visited[neighbor]){
							return false;
						}else{
							queue.offer(neighbor);
						}
					}
				}
			}
		}
	
		return true;
	}
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Set<Integer>> neighbors= initializeGraph(numCourses,prerequisites);
		Queue<Integer> queue= new LinkedList<Integer>();
		for(int i=0;i<numCourses;i++){
			if(neighbors.containsKey(i)){
				queue.offer(i);
			
				while(!queue.isEmpty()){
					int node= queue.poll();
					
					for(int neighbor:neighbors.remove(node)){
						if(neighbors.containsKey(neighbor)){
							queue.offer(neighbor);
						}else{
						    return false;
						}
					}
				}
			}
		}
	
	
		return true;
    }
}
