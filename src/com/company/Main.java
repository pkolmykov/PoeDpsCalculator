package com.company;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    private static Map<String, Double> mods = new LinkedHashMap<>();


    static {
        mods.put("#Adds #-# Fire Damage to Spells", 2.5);
        add("$#% increased Spell Damage", 7400, 7100, 20);
        add("##% increased Fire Damage", 7800, 7600, 20);
        add("##% increased Cast Speed@", 7800, 6000, 46);
    }

    private static void add(final String mod, final double hiDps, final double lowDps, final double amount) {
        mods.put(mod, ((hiDps / lowDps - 1) * 100) / amount);
    }


    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://poe.trade/search/aumotumominauh").get();
        Elements elements = doc.select(".item");
        for (final Element element : elements) {
            Item item = new Item();
            item.setIgn(element.attr("data-ign"));
            for (final String mod : mods.keySet()) {
                String value = element.select("[data-name=" + mod + "]").attr("data-value");
                if(!value.isEmpty()){
                    Integer intValue = Double.valueOf(value).intValue();
                    item.getStatsList().add(new ModStats(mod, intValue, (int) (intValue * mods.get(mod))));
                }
            }
            System.out.println(item);
        }
//        System.out.println(mods);
    }

}
