package a2_2101040039;

import utils.DomainConstraint;

/**
 * @overview represents a PC specs
 * @attributes
 * model            String
 * year             Integer     int
 * manufacturer     String
 * comps            Set<String>
 * @object a typical PC is pc=<mo, y, ma, c>, where model(mo), year(y), manufacturer(m), comps(c)
 * @abstract_properties
 * mutable(model)=true /\ optional(model)=false /\ length(model)=20 /\
 * mutable(year)=false /\ optional(year)=false /\ min(year)=1984 /\
 * mutable(manufacturer)=false /\ optional(manufacturer)=false /\ length(manufacturer)=15
 * mutable(comps)=true /\ optional(comps)=false
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
}
