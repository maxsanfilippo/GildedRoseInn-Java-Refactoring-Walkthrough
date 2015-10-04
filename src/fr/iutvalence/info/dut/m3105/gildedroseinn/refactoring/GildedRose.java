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

		updateItemQuality(item);
	}

	private static void updateItemQuality(Item item)
	{
		switch (item.getName())
		{
		case "Sulfuras, Hand of Ragnaros":
			return;

		case "Aged Brie":
		{
			increaseItemQuality(item);

			if (item.getSellIn() < 0)
			{
				increaseItemQuality(item);
			}
			break;
		}
		case "Backstage passes to a TAFKAL80ETC concert":
		{
			increaseItemQuality(item);

			if (item.getSellIn() < SELLIN_THRESHOLD_FOR_BACKSTAGE_ITEM_QUALITY_INCREASING_TWICE_AS_FAST)
			{
				increaseItemQuality(item);
			}

			if (item.getSellIn() < SELLIN_THRESHOLD_FOR_BACKSTAGE_ITEM_QUALITY_INCREASING_THREE_TIMES_AS_FAST)
			{
				increaseItemQuality(item);
			}

			if (item.getSellIn() < 0)
			{
				item.setQuality(item.getQuality() - item.getQuality());
			}

			break;
		}
		default:
			decreaseItemQuality(item);

			if (item.getSellIn() < 0)
			{
				if (item.getQuality() > MINIMUM_ITEM_QUALITY)
				{
					decrementItemQuality(item);
				}
			}
			break;

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