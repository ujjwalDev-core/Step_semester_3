package string_array_basics.class_problems;

public class BmiCalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int index = 0; index < heights.length; index++) {
            double bmi = weights[index] / (heights[index] * heights[index]);
            System.out.printf("%d | %.2f | %.1f | %.2f | %s%n",
                    index + 1, heights[index], weights[index], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        printWellnessReport(new double[]{1.75, 1.60, 1.82}, new double[]{70, 90, 82});
    }
}
