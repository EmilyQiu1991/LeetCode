package medium;

import java.util.Arrays;

public class VlidateIPAddress {

	public static void main(String[] args) {
		VlidateIPAddress v = new VlidateIPAddress();
		System.out.println(v.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
	}
	public String validIPAddress(String IP) {
        if(isIpv4(IP)){
        	return "IPv4";
        }else if(isIpv6(IP)){
        	return "IPv6";
        }else{
        	return "Neither";
        }
    }
	public boolean isIpv4(String ip){
		if(ip==null||ip.length()==0){
			return false;
		}
		//for this edge case 2001:0db8:85a3:0:0:8A2E:0370:7334:
		if(ip.charAt(ip.length()-1)=='.'){
			return false;
		}
		String[] strs = ip.split("\\.");
		if(strs.length!=4){
			return false;
		}
		//check each number
		for(String s : strs){
			//no leading zeros, not empty
			if(s.length()==0||s.length()>3){
				return false;
			}
			if(s.length()>1&&s.charAt(0)=='0'){
				return false;
			}
			//range from 0-255
			for(char c: s.toCharArray()){
				if(c<'0'||c>'9'){
					return false;
				}
			}
			if(Integer.parseInt(s)>255){
				return false;
			}
		}
		return true;
	}
	public boolean isIpv6(String ip){
		if(ip==null||ip.length()==0){
			return false;
		}
		//for this edge case 2001:0db8:85a3:0:0:8A2E:0370:7334:
				if(ip.charAt(ip.length()-1)==':'){
					return false;
				}
		String[] strs = ip.split(":");
		if(strs.length!=8){
			return false;
		}
		for(int i=0;i<strs.length;i++){
			String s = strs[i];
			if(s.length()==0||s.length()>4){
				return false;
			}
			for(char c : s.toCharArray()){
				if(!isDigit(c)&&!ishexLetter(c)){
					return false;
				}
			}
			//first group no leading zeros
			if(i==0&&s.length()>1&&s.charAt(i)=='0'){
				return false;
			}
		}
		return true;
	}
	public boolean isDigit(char c){
		return Character.isDigit(c);
	}
	public boolean ishexLetter(char c){
		return (c>='a'&&c<='f')||(c>='A'&&c<='F');
	}

}
