import pkg.*;
import java.util.*;
import java.time.*;
import java.io.IOException;
import java.io.PrintWriter;
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
			MergeSort(nums, 0, nums.length - 1);
			//
			s.stop();
			System.out.println("Duration: " + Stopwatch.readable(s.read()));
			System.out.println("");
		}
	}

	public static void MergeSort(int[] nums, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;

			MergeSort(nums, left, mid);
			MergeSort(nums, mid + 1, right);

			merge(nums, left, mid, right);
		}
	}

	public static void merge(int[] nums, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; ++i) {
			L[i] = nums[left + i];
		}

		for (int j = 0; j < n2; ++j) {
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
}
