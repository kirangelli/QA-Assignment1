package TestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import JavaClasses.Item;
import JavaClasses.OrderPlacing;

class AnyInvalidItem {

	static Item[] item;
	OrderPlacing op;
	@BeforeAll
	public static void setup()
	{
		item = new Item[2];
		item[0] = new Item();
		item[1] = new Item();
		item[0].setPartNumber(12);
		item[0].setquantity(2);
		item[1].setPartNumber(44);
		item[1].setquantity(655);
		
	}
	@Test
	@DisplayName(" anyInValidItem method validation - "
			+ "valid items")
	void test1() {
		op = new OrderPlacing();
		assertEquals(false,op.anyInValidItem(item));
	}
	
	@Test
	@DisplayName(" anyInValidItem method validation - "
			+ "invalid items")
	void test2() {
		item[1].setPartNumber(-44);
		item[1].setquantity(655);
		op = new OrderPlacing();
		assertEquals(true,op.anyInValidItem(item));
	}

}
