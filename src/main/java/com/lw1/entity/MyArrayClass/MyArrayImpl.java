package com.lw1.entity.MyArrayClass;

import java.util.Arrays;
import com.lw1.exceptions.BadInputLineException;
import com.lw1.exceptions.ValueNotFoundException;
import com.lw1.exceptions.OutOfBoundException;


public class MyArrayImpl extends MyArray{

	public MyArrayImpl(){
		array = new int[0];
		this.size = 0;
	}

	public MyArrayImpl(int arraySize){
		array = new int[arraySize];
		this.size = arraySize;
	}

	public MyArrayImpl(int[] array){
		this.array = Arrays.copyOf(array, array.length);
		this.size = array.length;
	}

	@Override
	public void add(int value) {
		int[] newArray = new int[size + 1];
        if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);
		newArray[size] = value;
		array = newArray;
		size++;
	}

	public void addFromString(String values) throws BadInputLineException {
		String[] stringArray = values.split(", ");
		int[] newArray = new int[size + stringArray.length];
		for(int i = 0; i < size; i++){
			newArray[i] = array[i];
		}
		try {
			for(int i = 0; i < stringArray.length; i++) {
				newArray[size + i] = Integer.parseInt(stringArray[i].trim());
			}
		} catch (NumberFormatException e) {
			throw new BadInputLineException("Неверный формат строки: " + values);
		}
		array = newArray;
		size += stringArray.length;
	}

	@Override
	public int remove(int index) {
		if(index < 0 || index >= size)
			throw new OutOfBoundException("Выход за границы массива");

		int removedValue = array[index];
		int[] newArray = new int[size - 1];

		for (int i = 0; i < index; i++) {
			newArray[i] = array[i];
		}

		for (int i = index; i < size - 1; i++) {
			newArray[i] = array[i + 1];
		}
		array = newArray;
		size--;
		return removedValue;
	}


	public void replace(int oldValue, int newValue) {
		boolean replaced = false;
		for (int i = 0; i < size; i++) {
			if (array[i] == oldValue) {
				array[i] = newValue;
				replaced = true;
			}
		}
		if (!replaced)
			throw new ValueNotFoundException("Значение " + oldValue + " не содержится в массиве.");
	}


	public MyArray copyArray() {
		MyArray newArray = new MyArrayImpl(size);
		for(int i = 0; i < size; i++){
			newArray.set(i, array[i]);
		}
		return newArray;
	}

	@Override
	public boolean equals(Object object){
		if(this == object)
			return true;
		MyArray comparableArray = (MyArray) object;
		if(this.size != comparableArray.size)
			return false;
		for(int i = 0, n = this.size; i < n; i++){
			if(array[i] != comparableArray.get(i))
				return false;
		}
		return true;
	}

	public int size() {return size;}

	@Override
	public String toString() {
		return "MyArray: " + Arrays.toString(array);
	}

}
