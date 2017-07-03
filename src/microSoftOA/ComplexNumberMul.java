package microSoftOA;

public class ComplexNumberMul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexNumberMul c = new ComplexNumberMul();
		c.complexNumberMultiply("1+1i", "1+1i");
	}
	public String complexNumberMultiply(String a, String b) {
        String[] aStr = a.split("\\+");
        int realA1 = Integer.valueOf(aStr[0]);
        int realA2 = Integer.valueOf(aStr[1].substring(0,aStr[1].length()-1));
        
        String[] bStr = b.split("\\+");
        int realB1 = Integer.valueOf(bStr[0]);
        int realB2 = Integer.valueOf(bStr[1].substring(0,bStr[1].length()-1));
        //(a+bi)(c+di)=(ac-bd)+(bc+ad)i.
        int resReal1 = realA1*realB1-realA2*realB2;
        int resReal2 = realA2*realB1+realA1*realB2;
        return resReal1+"+"+resReal2;
    }

}
