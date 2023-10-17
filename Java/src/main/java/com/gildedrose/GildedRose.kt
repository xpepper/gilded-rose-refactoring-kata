package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
      for (Item item : items)
          extracted(item);
    }

    private static void extracted(Item item) {
        String name = item.getName();
        if (!name.equals("Aged Brie")
            && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (item.getQuality() > 0) {
            if (!name.equals("Sulfuras, Hand of Ragnaros")) {
              item.setQuality(item.getQuality() - 1);
            }
          }
        } else {
          if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);

            if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
              if (item.getSellIn() < 11) {
                if (item.getQuality() < 50) {
                  item.setQuality(item.getQuality() + 1);
                }
              }

              if (item.getSellIn() < 6) {
                if (item.getQuality() < 50) {
                  item.setQuality(item.getQuality() + 1);
                }
              }
            }
          }
        }

        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
          item.setSellIn(item.getSellIn() - 1);
        }

        if (item.getSellIn() < 0) {
          if (!name.equals("Aged Brie")) {
            if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
              if (item.getQuality() > 0) {
                if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                  item.setQuality(item.getQuality() - 1);
                }
              }
            } else {
              item.setQuality(item.getQuality() - item.getQuality());
            }
          } else {
            if (item.getQuality() < 50) {
              item.setQuality(item.getQuality() + 1);
            }
          }
        }
    }
}
