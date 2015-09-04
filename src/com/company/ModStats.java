package com.company;

/**
 * @author pkolmykov
 */
public class ModStats {
    private String name;
    private int amount;
    private int dps;

    public ModStats(final String name, final int amount, final int dps) {
        this.name = name;
        this.amount = amount;
        this.dps = dps;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getDps() {
        return dps;
    }
}
