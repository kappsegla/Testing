package gildedrose.qualitystrategy;

import gildedrose.Item;

public class BackstageStrategy implements QualityStrategy {
    private static final int MAX_QUALITY = 50;

    @Override
    public int calculateQuality(Item item) {
        int quality = item.quality;
        quality++;

        if (item.sellIn < 11 && quality < MAX_QUALITY)
            quality++;

        if (item.sellIn < 6 && quality < MAX_QUALITY)
            quality++;

        if( item.sellIn <= 0)
            quality = 0;

        return quality;
    }
}
