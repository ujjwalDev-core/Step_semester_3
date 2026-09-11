package access_modifiers_encapsulation_object_modeling.class_problems;

import java.util.Arrays;

public class PatientVitals {
    private final double[] readings = new double[500];
    private int readingCount;

    public PatientVitals(double[] initialReadings) {
        if (initialReadings != null) {
            for (double reading : initialReadings) {
                recordReading(reading);
            }
        }
    }

    public void recordReading(double reading) {
        if (reading > 0 && reading <= 45 && readingCount < readings.length) {
            readings[readingCount++] = reading;
        }
    }

    public double getAverage() {
        if (readingCount == 0) {
            return 0.0;
        }
        double total = 0;
        for (int index = 0; index < readingCount; index++) {
            total += readings[index];
        }
        return total / readingCount;
    }

    public double[] getAllReadings() {
        return Arrays.copyOf(readings, readingCount);
    }

    public static void main(String[] args) {
        PatientVitals vitals = new PatientVitals(new double[]{36.5, -2, 37.1});
        System.out.println(Arrays.toString(vitals.getAllReadings()));
        System.out.println(vitals.getAverage());
    }
}
