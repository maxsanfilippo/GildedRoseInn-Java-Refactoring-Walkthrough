package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class GildedRoseTest 
{
	private GildedRose createNewGildedRose() 
	{
		GildedRose gilded = new GildedRose();
		return gilded;
	}

	@Test
	public void updateQualitySellinForItemsShouldDecrementEachDay()
	{
		GildedRose gilded = createNewGildedRose();
		List <Item> items = new ArrayList<Item>();
		items.add(new Item("Conjured Mana Cake", 3, 6));
		gilded.updateQualityAndSellInForAllItems(items);
		assertEquals(items.get(0).getSellIn(), 2);
		assertEquals(items.get(0).getQuality(), 5);
	}


	
	@Test
	public void updateQualitySellinForItemsShouldDecrementTwiceQualityWhenSellinNegative()
	{
		GildedRose gilded = createNewGildedRose();
		List <Item> items = new ArrayList<Item>();
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		gilded.updateQualityAndSellInForAllItems(items);
		assertEquals(items.get(0).getSellIn(), -1);
		assertEquals(items.get(0).getQuality(), 78);
	}
	
	@Test
	public void updateQualitySellinForItemsQualityNeverNegative()
	{
		GildedRose gilded = createNewGildedRose();
		List <Item> items = new ArrayList<Item>();
		items.add(new Item("Ceci est un objet inutile", 10, 0));
		gilded.updateQualityAndSellInForAllItems(items);
		assertEquals(items.get(0).getSellIn(), 9);
		assertEquals(items.get(0).getQuality(), 0);
	}
	
	@Test
	public void updateQualitySellinForAgedBrie()
	{
		GildedRose gilded = createNewGildedRose();
		List <Item> items = new ArrayList<Item>();
		items.add(new Item("Aged Brie", 5, 0));
		gilded.updateQualityAndSellInForAllItems(items);
		assertEquals(items.get(0).getSellIn(), 4);
		assertEquals(items.get(0).getQuality(), 1);
	}
	

}
