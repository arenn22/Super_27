package pkg;

public class DayBirth {
    private final int year;
    private final int month;
    private final String day;
    private final Gender gender;
    private final int births;

    public DayBirth(int year, int month, String day, Gender gender, int births) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.gender = gender;
        this.births = births;
    }

    public static DayBirth fromCSV(String line) {
        String[] parsed = line.trim().split(",");

        return new DayBirth(
            Integer.parseInt(parsed[0].trim()),
            Integer.parseInt(parsed[1].trim()),
            parsed[2].trim(),
            Gender.valueOf(parsed[3].trim().toUpperCase()),
            Integer.parseInt(parsed[4].trim())
        );
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public char getGender() {
        return gender.name().charAt(0);
    }

    public int getBirths() {
        return births;
    }

    @Override
    public String toString() {
        return year + "," + month + "," + day + "," + gender.name() + "," + births;
    }
}
