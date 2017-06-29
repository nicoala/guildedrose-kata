import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private void expectedItemIsEqualToOutput(Item item, Item expectedItem) {
        assertEquals(expectedItem.name, item.name);
        assertEquals(expectedItem.quality, item.quality);
        assertEquals(expectedItem.sellIn, item.sellIn);
    }

    @Test
    public void sulfuras_is_not_changed() throws Exception {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        Item[] items = new Item[] {sulfuras};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();

        Item expectedItem = new Item("Sulfuras, Hand of Ragnaros", -1, 80);

        expectedItemIsEqualToOutput(app.items[0], expectedItem);

    }

    @Test
    public void regular_item_has_quality_and_sellin_decreasing() throws Exception {
        Item elixir = new Item("Elixir of the Mongoose", 5, 7);
        Item[] items = new Item[] {elixir};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item expectedItem = new Item("Elixir of the Mongoose", 4, 6);

        expectedItemIsEqualToOutput(app.items[0], expectedItem);
    }

    @Test
    public void regular_item_has_quality_and_sellin_decreasing_during_two_days() throws Exception {
        Item elixir = new Item("Elixir of the Mongoose", 5, 7);
        Item[] items = new Item[] {elixir};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();

        Item expectedItem = new Item("Elixir of the Mongoose", 3, 5);

        expectedItemIsEqualToOutput(app.items[0], expectedItem);
    }

    @Test
    public void regular_item_quality_decrease_two_times_faster_when_sellin_over() throws Exception {
        Item elixir = new Item("Elixir of the Mongoose", -1, 7);
        Item[] items = new Item[] {elixir};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item expectedItem = new Item("Elixir of the Mongoose", -2, 5);

        expectedItemIsEqualToOutput(app.items[0], expectedItem);
    }

    @Test
    public void regular_item_quality_stays_at_0() throws Exception {
        Item elixir = new Item("Elixir of the Mongoose", -1, 0);
        Item[] items = new Item[] {elixir};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item expectedItem = new Item("Elixir of the Mongoose", -2, 0);

        expectedItemIsEqualToOutput(app.items[0], expectedItem);
    }

    @Test
    public void aged_brie_gains_quality_when_sellin_reaches_minus10() throws Exception {
        Item elixir = new Item("Aged Brie", 9, 5);
        Item[] items = new Item[] {elixir};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item expectedItem = new Item("Aged Brie", 8, 6);

        expectedItemIsEqualToOutput(app.items[0], expectedItem);
    }

    @Test
    public void aged_brie_gains_quality_twice_when_sellin_reaches_minus0() throws Exception {
        Item elixir = new Item("Aged Brie", -10, 5);
        Item[] items = new Item[] {elixir};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item expectedItem = new Item("Aged Brie", -11, 7);

        expectedItemIsEqualToOutput(app.items[0], expectedItem);
    }

    @Test
    public void backstage_passes_gains_quality_twice_when_sellin_reaches_minus10() throws Exception {
        Item elixir = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 5);
        Item[] items = new Item[] {elixir};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item expectedItem = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 7);

        expectedItemIsEqualToOutput(app.items[0], expectedItem);
    }

    @Test
    public void backstage_passes_gains_quality_by_three_when_sellin_reaches_minus5() throws Exception {
        Item elixir = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5);
        Item[] items = new Item[] {elixir};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item expectedItem = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 8);

        expectedItemIsEqualToOutput(app.items[0], expectedItem);
    }

    @Test
    public void backstage_passes_loses_quality_when_sellin_reaches_minus_0() throws Exception {
        Item elixir = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5);
        Item[] items = new Item[] {elixir};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item expectedItem = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0);

        expectedItemIsEqualToOutput(app.items[0], expectedItem);
    }

}