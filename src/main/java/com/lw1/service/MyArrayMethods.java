package com.lw1.service;

import com.lw1.entity.MyArrayClass.MyArray;
import com.lw1.exceptions.DivisionByZeroException;

public class MyArrayMethods {

	public static int getMinValue(MyArray array){
		int min = array.get(0);
		for(int i = 0, n = array.size(); i < n; i++){
			if(array.get(i) < min) min = array.get(i);
		}
		return min;
	}

	public static int getMaxValue(MyArray array){
		int max = array.get(0);
		for(int i = 0, n = array.size(); i < n; i++){
			if(array.get(i) > max) max = array.get(i);
		}
		return max;
	}

	public static double averageOfValues(MyArray array) {
		try {
			if (array.size() == 0) {
				throw new DivisionByZeroException("Невозможно вычислить среднее значение: размер массива равен нулю.");
			}
			return sumOfValues(array) / array.size();
		} catch (DivisionByZeroException e) {
			System.err.println(e.getMessage());
			return 0;
		}
	}

	public static int sumOfValues(MyArray array){
		int summOfAll = 0;
		for(int i = 0, n = array.size(); i < n; i++){
			summOfAll += array.get(i);
		}
		return summOfAll;
	}

	public static int countPositiveValues(MyArray array){
		int positiveCounter = 0;
		for(int i = 0, n = array.size(); i < n; i++){
			if(array.get(i) > 0) positiveCounter++;
		}
		return positiveCounter;
	}

	public static int countNegativeValues(MyArray array){
		int negativeCounter = 0;
		for(int i = 0, n = array.size(); i < n; i++){
			if(array.get(i) < 0) negativeCounter++;
		}
		return negativeCounter;	}
}
