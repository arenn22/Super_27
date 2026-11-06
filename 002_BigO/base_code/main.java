import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;


class main {
	public static void main(String args[]) {
		int [] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
		int [] nums = new int[100];
		Stopwatch s = new Stopwatch();

		System.out.println("-------------------Test-------------------");
		System.out.println("");
		for(int i : times){
			System.out.println("Interval: " + i);
			s.start();	
			nums = new int[i];
			//  Put your method between these two comments
			BubbleSort(nums);
			//
			s.stop();
			System.out.println("Duration: " + Stopwatch.readable(s.read()));
			System.out.println("");
		}
	}

	public static void BubbleSort(int[] nums){
		int n = nums.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
	}

	public static void InsertionSort(int[] nums){
		int n = nums.length;

		for (int i = 1; i < n; i++) {
			int key = nums[i];
			int j = i - 1;

			while (j >= 0 && nums[j] > key) {
				nums[j + 1] = nums[j];
				j = j - 1;
			}

			nums[j + 1] = key;
		}
	}

	public static void SelectionSort(int[] nums){
		int n = nums.length;

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < n; j++) {
				if (nums[j] < nums[minIndex]) {
					minIndex = j;
				}
			}

			int temp = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = temp;
		}
	}
}

