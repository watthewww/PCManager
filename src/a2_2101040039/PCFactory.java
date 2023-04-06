package a2_2101040039;

public class PCFactory {
    private static PC instance;
    private PCFactory() {
    }
    public static PC createObjects(String name, int year, String manufacturer, Set<String> comps) {
        if (instance == null) {
            instance = new PC(name, year, manufacturer, comps);
        }
            return instance;
    }
}
