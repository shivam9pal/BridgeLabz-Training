package week03.gcrcodebase.binarystrinbuilder;

class FirstNegativeSearch {
	public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] numbers = {5, 12, 8, 0, 3, -7, 9, -2};

        int result = findFirstNegative(numbers);

        if (result != -1) {
            System.out.println("First negative number found at index: " + result);
            System.out.println("Value: " + numbers[result]);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }
}
