package a2_2101040039;

public class PCReport {

    public String displayReport(PC[] objs) {
        StringBuilder info = new StringBuilder();
        StringBuilder line = new StringBuilder("-".repeat(99));
        String header = String.format("%56s", "PCPROG REPORT");
        info.append(line);
        info.append(System.getProperty("line.separator"));
        info.append(header);
        info.append(System.getProperty("line.separator"));
        info.append(line);
        info.append(System.getProperty("line.separator"));
        for (int i = 0; i < objs.length; i++) {
            PC pc = objs[i];
            String comps = pc.getComps().toString().replace("Set", "").replace("{", "[").replace("}", "]").replace(",", ", ");
            String temp = String.format("%3s %20s %6s %15s %-55s %n", i + 1, pc.getModel(), pc.getYear(), pc.getManufacturer(), comps);
            info.append(temp);
        }
        info.append(line);
        return info.toString();
    }
}
