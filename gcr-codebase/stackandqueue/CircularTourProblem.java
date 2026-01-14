package week03.gcrcodebase.stackandqueue;

class CircularTourProblem {
	static int findStart(int[] petrol, int[] distance) {
        int total = 0, curr = 0, start = 0;

        for (int i = 0; i < petrol.length; i++) {
            int diff = petrol[i] - distance[i];
            total += diff;
            curr += diff;

            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
	
	public static void main(String[] args) {
        int[] petrol = {6, 3, 7};
        int[] distance = {4, 6, 3};

        int start = findStart(petrol, distance);

        if (start != -1)
            System.out.println("Start tour at petrol pump index: " + start);
        else
            System.out.println("No possible circular tour");
    }
}
