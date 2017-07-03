package amazonQA;
import java.util.*;
public class MovieNetwork {

	public class Movie{
		int movieId;
		float rating;
		List<Movie> similarMovie;
	}
	public static void main(String[] args) {
		
	}
	//bfs + priorityQueue
	public static List<Movie> getNearest(Movie movie, int numSimilar){
		List<Movie> list = new ArrayList<Movie>();
		Queue<Movie> queue = new LinkedList<Movie>();
		PriorityQueue<Movie> heap = new PriorityQueue<Movie>(4, (a,b)->Float.compare(a.rating, b.rating));
		queue.offer(movie);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0;i<size;i++){
				Movie m = queue.poll();
				//add to heap
				if(m.movieId!=movie.movieId){
					heap.offer(m);
					//maintain heap size to 4
					if(heap.size()>4){
						heap.poll();
					}
				}
				//add child to queue
				for(Movie child: m.similarMovie){
					queue.offer(child);
				}
			}
		}
		for(Movie m : heap){
			list.add(m);
		}
		return list;
		
	}

}
