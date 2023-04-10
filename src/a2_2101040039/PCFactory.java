package a2_2101040039;

public class PCFactory {
    private static PCFactory factory;

    public static PCFactory getFactory() {
        if(factory == null) {
            factory = new PCFactory();
        }
        return factory;
    }

    public PC createObject(String model, int year, String manufacturer, Set<String> comps) {
        return new PC(model, year, manufacturer, comps);
    }

}
