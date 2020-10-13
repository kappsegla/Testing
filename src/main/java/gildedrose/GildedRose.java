package gildedrose;

import gildedrose.qualitystrategy.BackstageStrategy;
import gildedrose.qualitystrategy.DefaultStrategy;
import gildedrose.qualitystrategy.QualityStrategy;

import java.util.Map;

import static gildedrose.qualitystrategy.QualityStrategyFactory.getStrategy;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    @Deprecated
    public void updateQuality() {
        updateItems();
    }

    public void updateItems() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        QualityStrategy qualityStrategy = getStrategy(item);

        item.quality = qualityStrategy.calculateQuality(item);
        if( !item.name.equals("Sulfuras, Hand of Ragnaros"))
            item.sellIn--;
    }
}
