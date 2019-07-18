package inMemorySystem;
import java.util.*;
public class InMemoryFileSystem {
    public Directory root; // Directory "/"
	public static void main(String[] args) {
		String input = "/a/";
		String[] parts = input.split("/");
		
		System.out.println(Arrays.toString(parts));
		System.out.println(parts.length);
	}
	public List<String> ls(String path) throws Exception{
		List<String> res = new ArrayList<String>();
		String[] parts = path.split("/");
		if(parts.length ==0 ) {
			res.addAll(root.subDirectories.keySet());
			res.addAll(root.files.keySet());
			res.sort(String::compareToIgnoreCase);
			return res;
		}
		
		Directory current = root;
		
		for(int i =  1; i< parts.length; i++) {
			// a , root.a
			// parts[i] is a sub directory of current
			if (current.subDirectories.containsKey(parts[i])) {
				current = current.subDirectories.get(parts[i]);
				if(i == parts.length-1)
				{
					res.addAll(root.subDirectories.keySet());
					res.addAll(root.files.keySet());
					res.sort(String::compareToIgnoreCase);
					return res;
				}
				continue;
			}
			// parts[i] is not a sub directory of current, could be a file
			if(current.files.containsKey(parts[i])) {
				if(i!= parts.length-1) {
					// parts[i] is not the end of path, not valid path
					throw new Exception("Invalid path");
				}
				// parts[i] is a valid file path
				res.add(current.files.get(parts[i]).name);
				return res;
			}
			// both files and subDirectories do not contains this name parts[i]
			throw new Exception("Invalid path");
		}
		return res;
	}

}
