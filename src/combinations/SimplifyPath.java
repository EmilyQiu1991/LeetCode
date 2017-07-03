package combinations;
import java.util.*;
public class SimplifyPath {

	public static void main(String[] args) {
		SimplifyPath s = new SimplifyPath();
		s.simplifyPath2("/a/./b/../../c/");
	}
	 public String simplifyPath(String path) {
	        String result = "/";
	        String[] stubs = path.split("/+");
	        ArrayList<String> paths = new ArrayList<String>();
	        for (String s : stubs){
	        	//if we met two dots, go to upper directory ,we can remove last directory
	            if(s.equals("..")){
	                if(paths.size() > 0){
	                    paths.remove(paths.size() - 1);
	                }
	            }
	            //if we met . , means current direcory , do nothing
	            else if (!s.equals(".") && !s.equals("")){
	                paths.add(s);
	            }
	        }
	        for (String s : paths){
	            result += s + "/";
	        }
	        if (result.length() > 1)
	            result = result.substring(0, result.length() - 1);
	        return result;
	    }
	 public String simplifyPath2(String path) {
	        if(path==null||path.length()==0){
	            return path;
	        }
	        //  /a/./b/../../c/
	        String[] stub = path.split("/");//{"",a,.,b,..,..,c}
	        Stack<String> stack = new Stack<String>();
	        for(String s: stub){
	        	if(s.equals("..")){
		        	if(!stack.empty()){
		        		stack.pop();
		        	}else{
		        		stack.push(s);
		        	}
		        }
		        if(s.length()>0 && !s.equals(".")&&!s.equals("..")){
		        	stack.push(s);
		        }   
	        }
	        String res = "";
	        while(!stack.isEmpty()){
	        	res= stack.pop()+"/"+res;
	        }
	        res = "/"+res;
	        System.out.println(res);
	        return res.length()>1?res.substring(0, res.length()-1):"/";
	    }
}
