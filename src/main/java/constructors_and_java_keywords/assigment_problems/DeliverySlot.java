package constructors_and_java_keywords.assigment_problems;

public class DeliverySlot {
    private final String orderId;
    private final String timeSlot;

    public DeliverySlot(String orderId, String timeSlot) {
        this.orderId = orderId;
        this.timeSlot = timeSlot;
    }

    // The no-slot version delegates to the full constructor.
    public DeliverySlot(String orderId) {
        this(orderId, "ASAP");
    }

    public boolean isPeakHour() {
        return timeSlot.equals("12:00-13:00")
                || timeSlot.equals("13:00-14:00")
                || timeSlot.equals("19:00-20:00")
                || timeSlot.equals("20:00-21:00");
    }

    public static void main(String[] args) {
        DeliverySlot peakSlot = new DeliverySlot("ORD101", "13:00-14:00");
        DeliverySlot asapSlot = new DeliverySlot("ORD102");

        System.out.println(peakSlot.isPeakHour());
        System.out.println(asapSlot.isPeakHour());
    }
}
