package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	private static final int SELLIN_THRESHOLD_FOR_BACKSTAGE_ITEM_QUALITY_INCREASING_THREE_TIMES_AS_FAST = 5;

	private static final int SELLIN_THRESHOLD_FOR_BACKSTAGE_ITEM_QUALITY_INCREASING_TWICE_AS_FAST = 10;

	private static final int MAXIMUM_ITEM_QUALITY = 50;

	private static final int MINIMUM_ITEM_QUALITY = 0;


	/**
	 * @param args
	 */
	/*public static void main(String[] args)
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
	}*/

	public void updateQualityAndSellInForAllItems(List <Item> items)
	{
		for (int itemIndex = 0; itemIndex < items.size(); itemIndex++)
		{
			Item item = items.get(itemIndex);

			updateItemQualityAndSellIn(item);
		}
	}

	private void updateItemQualityAndSellIn(Item item)
	{
		updateItemSellIn(item);

		updateItemQuality(item);
	}

	private void updateItemQuality(Item item)
	{
		if (item.getSellIn()<0)
			item.setQuality(item.getQuality()-2);
		else 
			item.setQuality(item.getQuality()-1);
	}

	private void updateItemSellIn(Item item) 
	{
		item.setSellIn(item.getSellIn()-1);
	}

	
}