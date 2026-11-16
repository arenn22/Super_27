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

			Random r = new Random();

			for (int j = 0; j < i; j++) {
				nums[j] = r.nextInt(i);
			}

			//  Put your method between these two comments
			QuickSort(nums, 0, nums.length - 1);
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

	public static void LinearSearch(int[] nums, int target){
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return;
			}
		}
	}

	public static void MergeSort(int[] nums, int left, int right){
		if (left < right) {
			int mid = (left + right) / 2;

			MergeSort(nums, left, mid);
			MergeSort(nums, mid + 1, right);

			merge(nums, left, mid, right);
		}
	}

	public static void merge(int[] nums, int left, int mid, int right){
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = nums[left + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = nums[mid + 1 + j];
		}

		int i = 0, j = 0;
		int k = left;

		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				nums[k] = L[i];
				i++;
			} else {
				nums[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			nums[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			nums[k] = R[j];
			j++;
			k++;
		}
	}

	public static void QuickSort(int[] nums, int low, int high){
		if (low < high) {
			int pi = partition(nums, low, high);

			QuickSort(nums, low, pi - 1);
			QuickSort(nums, pi + 1, high);
		}
	}

	public static int partition(int[] nums, int low, int high){
		int pivot = nums[high];
		int i = (low - 1);

		for (int j = low; j < high; j++) {
			if (nums[j] < pivot) {
				i++;

				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}

		int temp = nums[i + 1];
		nums[i + 1] = nums[high];
		nums[high] = temp;

		return i + 1;
	}
}

