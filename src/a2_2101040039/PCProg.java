package a2_2101040039;

import static a2_2101040039.PCFactory.getFactory;
import static utils.TextIO.getln;
import static utils.TextIO.putln;
import static utils.TextIO.writeFile;
import static utils.TextIO.writeStandardOutput;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.TextIO;

/**
 * @author dmle
 * @overview PCProg is a program that captures data about PC objects and displays a report about them on the console.
 * @attributes objs Set<PC>
 * @object A typical PCProg is {c1,...,cn} where c1,...,cn are pcs
 * @abstract_properties mutable(objs)=true /\ optional(objs)=false
 */
public class PCProg {
    private static final Object YES = "Y";
    @DomainConstraint(mutable = true, optional = false)
    private static Set<PC> objs;

    /**
     * @effects initialise this to have an empty set of PCs
     */
    public PCProg() {
        objs = new Set<>();
    }

    /**
     * @effects if objs is not empty display to the standard console a text-based tabular report on objs return this
     * report else display nothing and return null
     */
    public void createObjects() {
        Scanner sc = new Scanner(System.in);
        Set<String> setComps = new Set<>();
        TextIO.put("Enter model name: ");
        String model = sc.nextLine();
        int year = 0;
        boolean valid = false;
        TextIO.put("Enter year: ");
        while (!valid) {
            try {
                year = sc.nextInt();
                valid = true;

            } catch (InputMismatchException e) {
                TextIO.putln("Invalid type. Please try again.");
                sc.next();
            }
        }

        sc.nextLine();
        TextIO.put("Enter manufacturer: ");
        String manufacturer = sc.nextLine();
        TextIO.put("Enter components: ");
        String comps;
        do {
            comps = sc.nextLine();
            setComps.insert(comps);
        } while (!comps.isBlank());
        PCFactory factory = getFactory();
        //catch
        PC pc = factory.createObject(model, year, manufacturer, setComps);
        if (!pc.repOK()) {
            createObjects();
        } else {
            objs.insert(pc);
            TextIO.putln("Continue? [Y/N]");
            String option = sc.nextLine();
            do {
                if (option.equals("Y")) {
                    createObjects();
                } else if (!option.equals("N")) {
                    TextIO.putln("Invalid. Please try again.");
                    TextIO.putln("Continue? [Y/N]");
                    option = sc.nextLine();
                }
            } while (!option.equals("N"));
        }

    }

    public Set<PC> getObjects() {
        return objs;
    }

    public String displayReport() {
        if (objs.size() > 0) {
            Vector<PC> pcs = getObjects().getElements();
            PCReport reportObj = new PCReport();
            return reportObj.displayReport(pcs.toArray(new PC[pcs.size()]));
        } else {
            return null;
        }
    }

    /**
     * @effects save report to a file pcs.txt in the same directory as the program's
     */
    public void saveReport(String report) {
        String fileName = "pcs.txt";
        writeFile(fileName);
        putln(report);
        writeStandardOutput();
    }

    /**
     * The run method
     *
     * @effects initialise an instance of PCProg create objects from data entered by the user display a report on the
     * objects prompt user to save report to file if user answers "Y" save report else end
     */
    public static void main(String[] args) {

        PCProg prog = new PCProg();

        // create objects
        try {
            prog.createObjects();
            // display report
            String report = prog.displayReport();
            System.out.println(report);
            if (report != null) {
                // prompt user to save report
                putln("Save report to file? [Y/N]");
                String toSave = getln();
                if (toSave.equals("Y")) {
                    prog.saveReport(report);
                    putln("report saved");
                }
            }
        } catch (NotPossibleException e) {
            System.err.printf("%s: %s%n", e, e.getMessage());
        }
        putln("~END~");
    }

}

