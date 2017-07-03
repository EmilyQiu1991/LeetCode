package easy;

public class ShortestDistance {

	public static void main(String[] args) {
		ShortestDistance s = new ShortestDistance();
		String[] strs = {"a","b","c","d","d"};
		s.shortestDistance(strs, "a", "d");
	}
	public int shortestDistance(String[] words, String word1, String word2) {
        int p1=-1, p2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){
                p1=i;
            }
            if(words[i].equals(word2)){
                p2=i;
            }
            //there are duplicates of word1 or word2 corner case
            if(p1!=-1&&p2!=-1)
            min = Math.min(Math.abs(p1-p2),min);
        }
         return min;
    }
   

}
