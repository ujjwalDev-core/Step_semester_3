package constructors_and_java_keywords.assigment_problems;

public class Canteen {
    private final String canteenCode, canteenName;
    private final int trustScore;
    public Canteen(String canteenCode, String canteenName, int trustScore) { this.canteenCode = canteenCode; this.canteenName = canteenName; this.trustScore = trustScore; }
    public Canteen(String canteenCode, String canteenName) { this(canteenCode, canteenName, 3); }
    public int compareTo(Canteen other) { int result = Integer.compare(other.trustScore, this.trustScore); if (result == 0) result = this.canteenCode.compareToIgnoreCase(other.canteenCode); if (result == 0) result = Integer.compare(this.canteenName.length(), other.canteenName.length()); return result; }
    public static Canteen[] rankCanteens(Canteen[] canteens) { Canteen[] ranked = canteens.clone(); for (int i = 0; i < ranked.length - 1; i++) for (int j = 0; j < ranked.length - 1 - i; j++) if (ranked[j].compareTo(ranked[j + 1]) > 0) { Canteen temp = ranked[j]; ranked[j] = ranked[j + 1]; ranked[j + 1] = temp; } return ranked; }
    public String getCanteenCode() { return canteenCode; }
    public static void main(String[] args) { for (Canteen canteen : rankCanteens(new Canteen[]{new Canteen("HB3-C", "Spice Junction", 3), new Canteen("hb1-c", "Grand Mess", 5), new Canteen("HB2-C", "Southern Treats")})) System.out.println(canteen.getCanteenCode()); }
}
