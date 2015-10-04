package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	private static final int SELLIN_THRESHOLD_FOR_BACKSTAGE_ITEM_QUALITY_INCREASING_THREE_TIMES_AS_FAST = 5;

	private static final int SELLIN_THRESHOLD_FOR_BACKSTAGE_ITEM_QUALITY_INCREASING_TWICE_AS_FAST = 10;

	private static final int MAXIMUM_ITEM_QUALITY = 50;

	private static final int MINIMUM_ITEM_QUALITY = 0;
	
	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		updateQualityAndSellInForAllItems();
	}

	public static void updateQualityAndSellInForAllItems()
	{
		for (int itemIndex = 0; itemIndex < items.size(); itemIndex++)
		{
			Item item = items.get(itemIndex);
			
			updateItemQualityAndSellIn(item);
		}
	}

	private static void updateItemQualityAndSellIn(Item item)
	{
		updateItemSellIn(item);
		
		if ((!"Aged Brie".equals(item.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
		{
			if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
			{
				decreaseItemQuality(item);
			}
		}
		else
		{
			if (item.getQuality() < MAXIMUM_ITEM_QUALITY)
			{
				incrementItemQuality(item);

				if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
				{
					if (item.getSellIn() < SELLIN_THRESHOLD_FOR_BACKSTAGE_ITEM_QUALITY_INCREASING_TWICE_AS_FAST)
					{
						increaseItemQuality(item);
					}

					if (item.getSellIn() < SELLIN_THRESHOLD_FOR_BACKSTAGE_ITEM_QUALITY_INCREASING_THREE_TIMES_AS_FAST)
					{
						increaseItemQuality(item);
					}
				}
			}
		}

		if (item.getSellIn() < 0)
		{
			if (!"Aged Brie".equals(item.getName()))
			{
				if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
				{
					if (item.getQuality() > MINIMUM_ITEM_QUALITY)
					{
						if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
						{
							decrementItemQuality(item);
						}
					}
				}
				else
				{
					item.setQuality(item.getQuality() - item.getQuality());
				}
			}
			else
			{
				increaseItemQuality(item);
			}
		}
	}

	private static void updateItemSellIn(Item item)
	{
		if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
		{
			decrementItemSellIn(item);
		}
	}

	private static void increaseItemQuality(Item item)
	{
		if (item.getQuality() < MAXIMUM_ITEM_QUALITY)
		{
			incrementItemQuality(item);
		}
	}

	private static void decreaseItemQuality(Item item)
	{
		if (item.getQuality() > MINIMUM_ITEM_QUALITY)
		{
			decrementItemQuality(item);
		}
	}

	private static void incrementItemQuality(Item item)
	{
		item.setQuality(item.getQuality() + 1);
	}

	private static void decrementItemQuality(Item item)
	{
		item.setQuality(item.getQuality() - 1);
	}

	private static void decrementItemSellIn(Item item)
	{
		item.setSellIn(item.getSellIn() - 1);
	}

}