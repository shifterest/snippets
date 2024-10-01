/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college;

/**
 *
 * @author Delmoro-Ke
 */
public class Fee {
    String fee;
    double rate;
    
    public Fee (String fee, double rate) {
        this.fee = fee;
        this.rate = rate;
    }

    public String getFee() {
        return fee;
    }
    public double getRate() {
        return rate;
    }
    
    public double calculateFee (double m) {
        return rate * m;
    }
}
