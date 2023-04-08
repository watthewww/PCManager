package a2_2101040039;

public class PCReport {
    public static void displayReport(PC[] objs) {
        StringBuilder line = new StringBuilder();
        line.append("-".repeat(99));
        String header = String.format("%56s", "PCPROG REPORT");
        System.out.println(line);
        System.out.println(header);
        System.out.println(line);
        for (int i = 0; i < objs.length; i++) {
            PC pc = objs[i];
            System.out.format("%3s %20s %6s %15s %-55s", i + 1, pc.getModel(), pc.getYear(), pc.getManufacturer(),
                    pc.getComps());
            System.out.println();
        }
    }
}
