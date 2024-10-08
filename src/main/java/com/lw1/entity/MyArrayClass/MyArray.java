package com.lw1.entity.MyArrayClass;

import com.lw1.exceptions.BadInputLineException;
import com.lw1.exceptions.OutOfBoundException;

public abstract class MyArray {

	protected int[] array = null;
	protected int size = 0;

	public int get(int index) {
		if(index < 0 || index >= size)
			throw new OutOfBoundException("Выход за границы массива");
		return array[index];
	}

	public void set(int index, int value){
		array[index] = value;
	}

	public abstract void add(int value);
	public abstract void addFromString(String str) throws BadInputLineException;

	public abstract int remove(int index);
	public abstract void replace(int value1, int value2);

	public abstract MyArray copyArray();

	public abstract int size();
}
