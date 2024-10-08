package com.lw1;

import com.lw1.exceptions.ArrayHasNoElementsException;
import com.lw1.exceptions.BadInputLineException;
import com.lw1.exceptions.ValueNotFoundException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lw1.entity.MyArrayClass.MyArray;
import com.lw1.entity.MyArrayClass.MyArrayImpl;
import com.lw1.exceptions.OutOfBoundException;

public class ArrayImplTest {

	@Test(priority = 1, enabled = true)
	public void getTest(){
		MyArray array = new MyArrayImpl(new int[]{2, 4, 8});
		Assert.assertEquals(array.get(0), 2);
		Assert.assertEquals(array.get(1), 4);
		Assert.assertEquals(array.get(2), 8);
	}

	@Test(expectedExceptions = OutOfBoundException.class)
	public void getOutOfBoundExceptionTest(){
		MyArray array = new MyArrayImpl(2);
		array.get(3);
	}

	@Test
	public void addElementTest(){
		MyArray array = new MyArrayImpl();
		array.add(10);

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(array.size(), 1);
		softAssert.assertEquals(array.get(0), 10);
		softAssert.assertAll();
	}

	@Test
	public void sizeTest(){
		MyArray array = new MyArrayImpl(3);
		Assert.assertEquals(array.size(), 3);
	}

	@Test(expectedExceptions = ArrayHasNoElementsException.class)
	public void getArrayHasNoElementsExceptionTest(){
		MyArray array = new MyArrayImpl();
		array.size();
	}

	@Test
	public void copyArrayTest(){
		MyArray array = new MyArrayImpl(new int[]{2, 4, 8});
		MyArray copiedArray = array.copyArray();
		Assert.assertEquals(array, copiedArray);
	}

	@Test
	public void removeTest() {
		MyArray array = new MyArrayImpl(new int[]{5, 10, 15, 20});
		int removedValue = array.remove(1);

		Assert.assertEquals(removedValue, 10);

		Assert.assertEquals(array.size(), 3);

		Assert.assertEquals(array.get(0), 5);
		Assert.assertEquals(array.get(1), 15);
		Assert.assertEquals(array.get(2), 20);

		Assert.assertThrows(OutOfBoundException.class, () -> array.get(3));
	}

	@Test
	public void addMultipleValuesTest() throws BadInputLineException {
		MyArray array = new MyArrayImpl();
		array.addFromString("10, 20, 30, 40");

		Assert.assertEquals(array.size(), 4);
		Assert.assertEquals(array.get(0), 10);
		Assert.assertEquals(array.get(1), 20);
		Assert.assertEquals(array.get(2), 30);
		Assert.assertEquals(array.get(3), 40);
	}

	// Тест для метода replace
	@Test
	public void replaceValueTest() {
		MyArray array = new MyArrayImpl(new int[]{10, 20, 30, 20});
		array.replace(20, 99);

		Assert.assertEquals(array.get(1), 99);
		Assert.assertEquals(array.get(3), 99);
		Assert.assertEquals(array.size(), 4);
	}

	@Test (expectedExceptions = ValueNotFoundException.class)
	public void ValueNotFoundExceptionTest(){
		MyArray array = new MyArrayImpl();
		array.add(10);
		array.replace(40, 5);
	}

}
