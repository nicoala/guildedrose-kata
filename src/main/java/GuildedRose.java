class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {

                qualityEvolution(item);

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    concertComingSoon(item);
                }

                sellinDecrease(item);

                itemIsExpired(item);
            }
        }
    }

    private void qualityEvolution(Item item) {
        if(item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            qualityIncrease(item);
        } else {
            qualityDecrease(item);
            conjuredQualityDecrease(item);
        }
    }

    private void conjuredQualityDecrease(Item item) {
        if(item.name.contains("Conjured")) {
            qualityDecrease(item);
        }
    }

    private void sellinDecrease(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void qualityIncrease(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void qualityDecrease(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void concertComingSoon(Item item) {
        passQualityIncreaseIf(item, 11);
        passQualityIncreaseIf(item, 6);
    }

    private void passQualityIncreaseIf(Item item, int sellinLeft) {
        if (item.sellIn < sellinLeft) {
            qualityIncrease(item);
        }
    }

    private void itemIsExpired(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            } else if (item.name.equals("Aged Brie")) {
                qualityIncrease(item);
            } else {
                qualityDecrease(item);
                conjuredQualityDecrease(item);
            }
        }
    }

}