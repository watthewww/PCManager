package a2_2101040039;

public class PCFactory {
    private PCFactory() {
    }
    public static PC createObjects(String model, int year, String manufacturer, Set<String> comps) {
            return new PC(model, year, manufacturer, comps);
    }
}
