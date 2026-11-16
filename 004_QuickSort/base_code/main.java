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

		QuickSort(males, 0, males.size() - 1);
		QuickSort(females, 0, females.size() - 1);

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

	private static void QuickSort(List<DayBirth> list, int left, int right) {
		if (left < right) {
			int pivotIndex = partition(list, left, right);
			QuickSort(list, left, pivotIndex - 1);
			QuickSort(list, pivotIndex + 1, right);
		}
	}

	private static int partition(List<DayBirth> list, int left, int right) {
		DayBirth pivot = list.get(right);
		int i = left - 1;

		for (int j = left; j < right; j++) {
			if (list.get(j).getBirths() <= pivot.getBirths()) {
				i++;
				Collections.swap(list, i, j);
			}
		}
		Collections.swap(list, i + 1, right);
		return i + 1;
	}
}
