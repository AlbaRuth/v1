package com.lw1;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lw1.entity.MyArrayClass.MyArrayImpl;
import com.lw1.entity.MyArrayClass.MyArray;
import com.lw1.service.MyArraySortMethods;

public class ArraySortMethodsTest {

	MyArray unsortedArray;
	MyArray acsSortedArray;
	MyArray descSortedArray;

	@BeforeTest
	public void initArrays(){
		unsortedArray = new MyArrayImpl();
		unsortedArray.add(3);
		unsortedArray.add(1);
		unsortedArray.add(6);
		unsortedArray.add(2);
		unsortedArray.add(-1);

		acsSortedArray = new MyArrayImpl();
		acsSortedArray.add(-1);
		acsSortedArray.add(1);
		acsSortedArray.add(2);
		acsSortedArray.add(3);
		acsSortedArray.add(6);

		descSortedArray = new MyArrayImpl();
		descSortedArray.add(6);
		descSortedArray.add(3);
		descSortedArray.add(2);
		descSortedArray.add(1);
		descSortedArray.add(-1);
	}

	@Test
	public void ascendingBubbleSortTest(){
		Assert.assertEquals(MyArraySortMethods.bubbleSort(unsortedArray, true), acsSortedArray);
	}

	@Test
	public void SelectiondingBubbleSortTest(){
		Assert.assertEquals(MyArraySortMethods.bubbleSort(unsortedArray, false), descSortedArray);
	}

	@Test
	public void ascendingInsertionSortTest(){
		Assert.assertEquals(MyArraySortMethods.insertionSort(unsortedArray, true), acsSortedArray);
	}

	@Test
	public void descendingInsertionSortTest(){
		Assert.assertEquals(MyArraySortMethods.insertionSort(unsortedArray, false), descSortedArray);
	}

	@Test
	public void ascendingQuickSortTest(){
		Assert.assertEquals(MyArraySortMethods.quickSort(unsortedArray, true), acsSortedArray);
	}

	@Test
	public void descendingQuickTest(){
		Assert.assertEquals(MyArraySortMethods.quickSort(unsortedArray, false), descSortedArray);
	}
}
