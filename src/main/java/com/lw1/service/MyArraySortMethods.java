package com.lw1.service;

import com.lw1.exceptions.ArrayHasNoElementsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lw1.entity.MyArrayClass.MyArray;

public class MyArraySortMethods {

	// Пузырьковая сортировка
	public static MyArray bubbleSort(MyArray array, boolean ascendingOrder) {

		MyArray sortedArray = array.copyArray();
		int temp;
		boolean swapped;
		for (int i = 0, n = sortedArray.size(); i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if ((ascendingOrder && sortedArray.get(j) > sortedArray.get(j + 1)) ||
						(!ascendingOrder && sortedArray.get(j) < sortedArray.get(j + 1))) {
					temp = sortedArray.get(j);
					sortedArray.set(j, sortedArray.get(j + 1));
					sortedArray.set(j + 1, temp);
					swapped = true;
				}
			}
			if (!swapped) break;
		}
		return sortedArray;
	}

	// Сортировка вставками
	public static MyArray insertionSort(MyArray array, boolean ascendingOrder) {

		MyArray sortedArray = array.copyArray();
		for (int i = 1; i < sortedArray.size(); i++) {
			int key = sortedArray.get(i);
			int j = i - 1;
			while (j >= 0 && ((ascendingOrder && sortedArray.get(j) > key) ||
					(!ascendingOrder && sortedArray.get(j) < key))) {
				sortedArray.set(j + 1, sortedArray.get(j));
				j--;
			}
			sortedArray.set(j + 1, key);
		}
		return sortedArray;
	}

	// Быстрая сортировка (QuickSort)
	public static MyArray quickSort(MyArray array, boolean ascendingOrder) {

		MyArray sortedArray = array.copyArray();
		quickSortRecursive(sortedArray, 0, sortedArray.size() - 1, ascendingOrder);
		return sortedArray;
	}

	private static void quickSortRecursive(MyArray array, int low, int high, boolean ascendingOrder) {

		if (low < high) {
			int pivotIndex = partition(array, low, high, ascendingOrder);
			quickSortRecursive(array, low, pivotIndex - 1, ascendingOrder);
			quickSortRecursive(array, pivotIndex + 1, high, ascendingOrder);
		}
	}

	private static int partition(MyArray array, int low, int high, boolean ascendingOrder) {
		int pivot = array.get(high);
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if ((ascendingOrder && array.get(j) < pivot) ||
					(!ascendingOrder && array.get(j) > pivot)) {
				i++;
				int temp = array.get(i);
				array.set(i, array.get(j));
				array.set(j, temp);
			}
		}
		int temp = array.get(i + 1);

		array.set(i + 1, array.get(high));
		array.set(high, temp);

		return i + 1;
	}
}
