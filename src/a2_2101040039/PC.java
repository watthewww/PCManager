package a2_2101040039;
import utils.*;

/**
 * @overview represents a PC specs
 * @attributes model            String year             Integer     int manufacturer     String comps Set<String>
 * @object a typical PC is pc=<mo, y, ma, c>, where model(mo), year(y), manufacturer(m), comps(c)
 * @abstract_properties mutable(model)=true /\ optional(model)=false /\ length(model)=20 /\ mutable(year)=false /\
 * optional(year)=false /\ min(year)=1984 /\ mutable(manufacturer)=false /\ optional(manufacturer)=false /\
 * length(manufacturer)=15 mutable(comps)=true /\ optional(comps)=false
 */

public class PC {
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 20)
    private String model;
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1984)
    private int year;
    @DomainConstraint(type = "String", mutable = false, optional = false, length = 15)
    private String manufacturer;
    @DomainConstraint(type = "Set<String>", mutable = true, optional = false)
    private Set<String> comps;

    //constructor

    /**
     * @effects <pre>
     *     if model, year, manufacturer, comps are valid
     *      initialize this as <model, year, manufacturer, comps>
     *     else
     *      throw NotPossibleException
     * </pre>
     */
    public PC(@AttrRef("model") String model, @AttrRef("year") int year, @AttrRef("manufacturer") String manufacturer
            , @AttrRef("comps") Set<String> comps) throws NotPossibleException {
        if (validateModel(model) && validateYear(year) && validateManufacturer(manufacturer) && validateComps(comps)) {
            this.model = model;
            this.year = year;
            this.manufacturer = manufacturer;
            this.comps = comps;
        } else {
            throw new NotPossibleException("Invalid data");
        }
    }
//observers (optional = false)

    /**
     * @effects return this.model
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("model")
    public String getModel() {
        return this.model;
    }

    /**
     * @effects return this.year
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("year")
    public int getYear() {
        return this.year;
    }

    /**
     * @effects return this.manufacturer
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("manufacturer")
    public String getManufacturer() {
        return this.manufacturer;
    }

    /**
     * @effects return this.comps
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("comps")
    public Set<String> getComps() {
        return this.comps;
    }

//mutators (true)

    /**
     * @effects <pre>
     *     if newModel is valid
     *      set this.model = newModel
     *      return true
     *     else
     *      return false
     * </pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("model")
    public boolean setModel(String newModel) {
        if (validateModel(newModel)) {
            this.model = newModel;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @effects <pre>
     *     if newComps is valid
     *      set this.comps = newComps
     *      return true
     *     else
     *      return false
     * </pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("comps")
    public boolean setComps(Set<String> newComps) {
        if (validateComps(newComps)) {
            this.comps = newComps;
            return true;
        } else {
            return false;
        }
    }

//*helpers
//validators

    /**
     * @effects <pre>
     *     if model is valid
     *      return true
     *     else
     *      return false
     * </pre>
     */
    public boolean validateModel(String model) {
        return (model != null && !model.equals("") && model.length() <= 20);
    }

    /**
     * @effects <pre>
     *     if year is valid
     *      return true
     *     else
     *      return false
     * </pre>
     */
    public boolean validateYear(int year) {
        return year >= 1984;
    }

    /**
     * @effects <pre>
     *     if manufacturer is valid
     *      return true
     *     else
     *      return false
     * </pre>
     */
    public boolean validateManufacturer(String manufacturer) {
        return (manufacturer != null && !manufacturer.equals("") && manufacturer.length() <= 15);
    }

    /**
     * @effects <pre>
     *     if comps is valid
     *      return true
     *     else
     *      return false
     * </pre>
     */
    public boolean validateComps(Set<String> comps) {
        return (comps != null);
    }

    //repOK
    public boolean repOK() {
        return validateModel(this.model) && validateYear(this.year) && validateManufacturer(this.manufacturer) && validateComps(this.comps);
    }

    //default
    @Override
    public String toString() {
        return "PC<" + model + "," + year + "," + manufacturer + "," + comps + ">";
    }


    @Override
    public boolean equals(Object pc1) {
        if (pc1 == this) {
            return true;
        }
        if (!(pc1 instanceof PC)) {
            return false;
        }
        PC pc2 = (PC) pc1;
        return (model.equalsIgnoreCase(pc2.model)) && (year == pc2.year) && manufacturer.equalsIgnoreCase(pc2.manufacturer) && (comps.equals(pc2.comps));
    }
}