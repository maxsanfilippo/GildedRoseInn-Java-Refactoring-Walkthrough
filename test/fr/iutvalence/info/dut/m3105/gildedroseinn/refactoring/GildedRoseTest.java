package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;


public class GildedRoseTest 
{

	@Test
	public void updateQualitySellinForItemsShouldDecrementEachDay()
	{
		GildedRose gilded = new GildedRose();
		List <Item> items = null;
		items.add(new Item("Conjured Mana Cake", 3, 6));
		gilded.updateQualityAndSellInForAllItems(items);
		assertEquals(items.get(0).getSellIn(), 2);
		assertEquals(items.get(0).getQuality(), 5);
	}

}
