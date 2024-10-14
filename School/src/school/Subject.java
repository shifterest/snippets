/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

/**
 *
 * @author delmoro-ke
 */
public class Subject {
    private final String code;
    private final String description;
    private final float units;

    public Subject(String code, String description, float units) {
        this.code = code;
        this.description = description;
        this.units = units;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public float getUnits() {
        return units;
    }
}