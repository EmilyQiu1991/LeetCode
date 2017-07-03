package easy;

public class ComputeArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computeArea(-2, -2, 2, 2, 1, -3, 3, -1));
	}

	// image ractangle ABCD is not moving, moving ractangle EFGH from
	// left-bottom to right-top,
	// then right-bottom to left top, how many situations?
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		if (C < A || D < B || G < E || H < F)
			return 0;
		int I, J, K, L = 0; // indicate overlapping ractangle
		// compute area for each ractangle
		int area1 = (C - A) * (D - B);
		int area2 = (G - E) * (H - F);
		// if 2 ractangles don't have any overlapping
		if (E > C || A > G || B > H || F > D) {
			return area1 + area2;
		} else {// there is overlapping, the point is identity the 2 points(left
				// bottom, right top) coordinate of overlapped ranctangle
			I = (E >= A ? E : A);// Math.max
			J = (F >= B ? F : B);// Math.max
			K = (G <= C ? G : C);// Math.min
			L = (H <= D ? H : D);// Math.min
			return area1 + area2 - Math.abs(K - I) * Math.abs(L - J);
		}
	}

}
