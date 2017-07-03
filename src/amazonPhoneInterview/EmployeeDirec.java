package amazonPhoneInterview;
import java.util.*;

import easy.TreeNode;
public class EmployeeDirec {
	Employee ceo;
	private class Employee{
		String name;
		List<Employee> reporters;
	}
	public static void main(String[] args) {
	
	}
	/**
	 * @return BFS
	 */
	public Employee findFurthestEmploy(){
		if(ceo == null) return null;
		Queue<Employee> queue = new LinkedList<Employee>();
		queue.offer(ceo);
		Employee res = ceo;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0;i<size;i++){
				Employee e = queue.poll();
				ceo = e;
				for(Employee reporter : e.reporters){
					queue.offer(reporter);
				}
			}
		}
		return res;
	}
	
	/**
	 * @return DFS
	 */
	public Employee findFurthestEmployee2(Employee e){
		if(e==null) return null;
		int maxHeight=0;
		for(Employee reporter:e.reporters){
			getDepth(reporter)
		}
	}
	
	public int getDepth(Employee e){
		if(e==null) return 0;
		int maxDepth=0;
		for(Employee reporter: e.reporters){
			int h=getDepth(reporter);
			if(h>maxDepth){
				maxDepth=h;
			}
		}
		return maxDepth+1;
	}
	public int getDepth(TreeNode node){
		if(node == null) return 0;
		int leftDepth =getDepth(node.left);
		int rightDepth= getDepth(node.right);
		return 1+ Math.max(leftDepth, rightDepth);
	}
	
	

}
