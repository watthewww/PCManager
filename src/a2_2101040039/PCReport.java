package a2_2101040039;

import java.util.Arrays;

public class PCReport {
    public static String displayReport(PC[] objs) {
        StringBuilder line = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        line.append("-".repeat(99));
        String header = String.format("%56s", "PCPROG REPORT");
        String pc = Arrays.toString(objs);
        String report = String.valueOf(sb.append(line).append(header).append(line));
    return report;
    }
}
