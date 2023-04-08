package a2_2101040039;

public class PCReport {
    PCReport() {
    }

    public static String displayReport(PC[] objs) {
        StringBuilder line = new StringBuilder();
        StringBuilder info = new StringBuilder();
        line.append("-".repeat(99));
        String header = String.format("%56s", "PCPROG REPORT");
        info.append(line);
        info.append(System.getProperty("line.separator"));
        info.append(header);
        info.append(System.getProperty("line.separator"));
        info.append(line);
        info.append(System.getProperty("line.separator"));

        for (int i = 0; i < objs.length; i++) {
            PC pc = objs[i];
            String temp = String.format("%3s %20s %6s %15s %-55s %n", i + 1, pc.getModel(), pc.getYear(), pc.getManufacturer(), pc.getComps());
            info.append(temp);
            //System.out.format("%3s %20s %6s %15s %-55s", i + 1, pc.getModel(), pc.getYear(), pc.getManufacturer(), pc.getComps());
        }
        return info.toString();
    }
}
