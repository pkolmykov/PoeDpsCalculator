package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pkolmykov
 */
public class Item {

    private String ign;
    List<ModStats> statsList = new ArrayList<>();

    public String getIgn() {
        return ign;
    }

    public void setIgn(final String ign) {
        this.ign = ign;
    }

    public List<ModStats> getStatsList() {
        return statsList;
    }

    public void setStatsList(final List<ModStats> statsList) {
        this.statsList = statsList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("-------------------------------------------\n");
        sb.append("ign: ").append(ign).append('\n');
        for (final ModStats modStats : statsList) {
            sb.append(modStats.getName())
                    .append(": ")
                    .append(modStats.getAmount())
                    .append(" | ")
                    .append(modStats.getDps())
                    .append("%\n");
        }
        return sb.toString();
    }
}
