package gildedrose.qualitystrategy;

import gildedrose.Item;

public class ConjuredStrategy implements QualityStrategy {
    @Override
    public int calculateQuality(Item item) {
        var quality = item.quality -2;

        if( item.sellIn <= 0)
            quality-=2;
        return Math.max(quality, 0);
    }
}
