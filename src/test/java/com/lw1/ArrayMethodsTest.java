package com.lw1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lw1.entity.MyArrayClass.MyArrayImpl;
import com.lw1.entity.MyArrayClass.MyArray;
import com.lw1.service.MyArrayMethods;

public class ArrayMethodsTest {

	@Test
	public void getMinValueTest(){
		MyArray array = new MyArrayImpl();
		array.add(8);
		array.add(5);
		array.add(-1);
		Assert.assertEquals(MyArrayMethods.getMinValue(array), -1);
	}

	@Test
	public void getMaxValueTest(){
		MyArray array = new MyArrayImpl();
		array.add(8);
		array.add(5);
		array.add(-1);
		Assert.assertEquals(MyArrayMethods.getMaxValue(array), 8);
	}

	@Test
	public void averageOfValuesTest(){
		MyArray array = new MyArrayImpl();
		array.add(8);
		array.add(5);
		array.add(-1);
		Assert.assertEquals(MyArrayMethods.averageOfValues(array), 4);
	}

	@Test
	public void sumOfValuesTest(){
		MyArray array = new MyArrayImpl();
		array.add(8);
		array.add(5);
		array.add(-1);
		Assert.assertEquals(MyArrayMethods.sumOfValues(array), 12);
	}

	@Test
	public void countPositiveValuesTest(){
		MyArray array = new MyArrayImpl();
		array.add(8);
		array.add(5);
		array.add(-1);
		Assert.assertEquals(MyArrayMethods.countNegativeValues(array), 1);
	}

	@Test
	public void countNegativeValuesTest(){
		MyArray array = new MyArrayImpl();
		array.add(8);
		array.add(5);
		array.add(-1);
		Assert.assertEquals(MyArrayMethods.countPositiveValues(array), 2);
	}
}
