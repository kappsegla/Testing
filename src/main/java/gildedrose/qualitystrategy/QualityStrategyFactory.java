package gildedrose.qualitystrategy;

import gildedrose.Item;

public class QualityStrategyFactory {

    public static  QualityStrategy getStrategy(Item item) {
        return switch (item.name) {
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstageStrategy();
            case "Aged Brie" -> new AgedBrieStrategy();
            case "Sulfuras, Hand of Ragnaros" -> new SulfurusStrategy();
            case "Conjured Mana Cake" -> new ConjuredStrategy();
            default -> new DefaultStrategy();
        };
    }
}
