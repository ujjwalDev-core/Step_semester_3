package constructors_and_java_keywords.class_problems;

public class BusRoute {
    private final String routeCode, routeName;
    private final int priority;
    public BusRoute(String routeCode, String routeName, int priority) { this.routeCode = routeCode; this.routeName = routeName; this.priority = priority; }
    public BusRoute(String routeCode, String routeName) { this(routeCode, routeName, 2); }
    public int compareTo(BusRoute other) {
        int result = Integer.compare(other.priority, this.priority);
        if (result == 0) result = this.routeCode.compareToIgnoreCase(other.routeCode);
        if (result == 0) result = Integer.compare(this.routeName.length(), other.routeName.length());
        return result;
    }
    public static BusRoute[] rankRoutes(BusRoute[] routes) {
        BusRoute[] ranked = routes.clone();
        for (int i = 0; i < ranked.length - 1; i++) for (int j = 0; j < ranked.length - 1 - i; j++) if (ranked[j].compareTo(ranked[j + 1]) > 0) { BusRoute temp = ranked[j]; ranked[j] = ranked[j + 1]; ranked[j + 1] = temp; }
        return ranked;
    }
    public String getRouteCode() { return routeCode; }
    public static void main(String[] args) { for (BusRoute route : rankRoutes(new BusRoute[]{new BusRoute("RT205L", "Airport Express", 3), new BusRoute("rt201j", "City Central", 4), new BusRoute("RT299T", "Night Service")})) System.out.println(route.getRouteCode()); }
}
