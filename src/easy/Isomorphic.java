package easy;

public class Isomorphic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isIsomorphic("abb","egg");
	}
	public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] map1 = new int[256];
        System.out.println(map1[0]);
        int n = s.length();
        //injection from s to t
        for(int i=0;i<n;i++){
            if(map1[s.charAt(i)]!=0){
                if(map1[s.charAt(i)]!=t.charAt(i))
                    return false;
            }else{
                map1[s.charAt(i)]=t.charAt(i);
            }
        }
        return true;
    }

}
