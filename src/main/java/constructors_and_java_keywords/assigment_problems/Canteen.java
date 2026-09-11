package constructors_and_java_keywords.assigment_problems;

/** Ranks canteens by trust score, code, and then name length. */
public class Canteen {
    private final String canteenCode;
    private final String canteenName;
    private final int trustScore;

    public Canteen(String canteenCode, String canteenName, int trustScore) {
        this.canteenCode = canteenCode;
        this.canteenName = canteenName;
        this.trustScore = trustScore;
    }

    public Canteen(String canteenCode, String canteenName) {
        this(canteenCode, canteenName, 3);
    }

    public int compareTo(Canteen other) {
        int result = Integer.compare(other.trustScore, this.trustScore);

        if (result == 0) {
            result = this.canteenCode.compareToIgnoreCase(other.canteenCode);
        }
        if (result == 0) {
            result = Integer.compare(this.canteenName.length(), other.canteenName.length());
        }
        return result;
    }

    public static Canteen[] rankCanteens(Canteen[] canteens) {
        Canteen[] ranked = canteens.clone();

        for (int outer = 0; outer < ranked.length - 1; outer++) {
            for (int inner = 0; inner < ranked.length - 1 - outer; inner++) {
                if (ranked[inner].compareTo(ranked[inner + 1]) > 0) {
                    Canteen temporary = ranked[inner];
                    ranked[inner] = ranked[inner + 1];
                    ranked[inner + 1] = temporary;
                }
            }
        }
        return ranked;
    }

    public String getCanteenCode() {
        return canteenCode;
    }

    public static void main(String[] args) {
        Canteen[] canteens = {
            new Canteen("HB3-C", "Spice Junction", 3),
            new Canteen("hb1-c", "Grand Mess", 5),
            new Canteen("HB2-C", "Southern Treats")
        };

        for (Canteen canteen : rankCanteens(canteens)) {
            System.out.println(canteen.getCanteenCode());
        }
    }
}
