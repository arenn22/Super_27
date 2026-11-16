import pkg.*;
import java.util.*;
import java.time.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;


class main {
	public static void main(String args[]) {
		List<DayBirth> dayBirths = readCSV("births.csv");

		List<DayBirth> males = new ArrayList<>();
		List<DayBirth> females = new ArrayList<>();

		for (DayBirth d : dayBirths) {
			if (d.getGender() == 'M') males.add(d);
            else if (d.getGender() == 'F') females.add(d);
		}

		MergeSort(males, 0, males.size() - 1);
		MergeSort(females, 0, females.size() - 1);

		writeCSV("males_sorted.csv", males);
		writeCSV("females_sorted.csv", females);
	}

	private static List<DayBirth> readCSV(String fileName) {
		List<DayBirth> dayBirths = new ArrayList<>();

		try (Scanner scanner = new Scanner(new java.io.File(fileName))) {
			if (scanner.hasNextLine()) scanner.nextLine();

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();

				if (line.isEmpty()) continue;

				dayBirths.add(DayBirth.fromCSV(line));
			}
		} catch (java.io.FileNotFoundException e) {
			System.err.println("File not found: " + fileName);
		}

		return dayBirths;
	}

	private static void writeCSV(String fileName, List<DayBirth> dayBirths) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println("year,month,day,gender,births");
			
            for (DayBirth d : dayBirths) {
				out.println(d.toString());
            }
        } catch (IOException e) {
            System.err.println("Could not write " + fileName + ": " + e.getMessage());
        }
	}

	private static void MergeSort(List<DayBirth> list, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			MergeSort(list, left, mid);
			MergeSort(list, mid + 1, right);

			merge(list, left, mid, right);
		}
	}

	private static void merge(List<DayBirth> list, int left, int mid, int right) {
		List<DayBirth> L = new ArrayList<>(list.subList(left, mid + 1));
		List<DayBirth> R = new ArrayList<>(list.subList(mid + 1, right + 1));

		int i = 0, j = 0;
		int k = left;

		while (i < L.size() && j < R.size()) {
			if (L.get(i).getBirths() <= R.get(j).getBirths()) {
				list.set(k, L.get(i));
				i++;
			} else {
				list.set(k, R.get(j));
				j++;
			}
			k++;
		}

		while (i < L.size()) {
			list.set(k, L.get(i));
			i++;
			k++;
		}

		while (j < R.size()) {
			list.set(k, R.get(j));
			j++;
			k++;
		}
	}
}
