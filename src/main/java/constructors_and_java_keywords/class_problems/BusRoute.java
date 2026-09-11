package constructors_and_java_keywords.class_problems;

/** Ranks routes by priority, then code, then route-name length. */
public class BusRoute {
    private final String routeCode;
    private final String routeName;
    private final int priority;

    public BusRoute(String routeCode, String routeName, int priority) {
        this.routeCode = routeCode;
        this.routeName = routeName;
        this.priority = priority;
    }

    public BusRoute(String routeCode, String routeName) {
        this(routeCode, routeName, 2);
    }

    public int compareTo(BusRoute other) {
        int result = Integer.compare(other.priority, this.priority);

        if (result == 0) {
            result = this.routeCode.compareToIgnoreCase(other.routeCode);
        }
        if (result == 0) {
            result = Integer.compare(this.routeName.length(), other.routeName.length());
        }
        return result;
    }

    public static BusRoute[] rankRoutes(BusRoute[] routes) {
        BusRoute[] ranked = routes.clone();

        for (int outer = 0; outer < ranked.length - 1; outer++) {
            for (int inner = 0; inner < ranked.length - 1 - outer; inner++) {
                if (ranked[inner].compareTo(ranked[inner + 1]) > 0) {
                    BusRoute temporary = ranked[inner];
                    ranked[inner] = ranked[inner + 1];
                    ranked[inner + 1] = temporary;
                }
            }
        }
        return ranked;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public static void main(String[] args) {
        BusRoute[] routes = {
            new BusRoute("RT205L", "Airport Express", 3),
            new BusRoute("rt201j", "City Central", 4),
            new BusRoute("RT299T", "Night Service")
        };

        for (BusRoute route : rankRoutes(routes)) {
            System.out.println(route.getRouteCode());
        }
    }
}
