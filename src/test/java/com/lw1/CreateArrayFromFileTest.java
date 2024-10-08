package com.lw1;

import com.lw1.CreateFile.CreateArrayFromFile;
import com.lw1.entity.MyArrayClass.MyArray;
import com.lw1.exceptions.BadInputLineException;
import com.lw1.exceptions.FileNotFoundExeption;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateArrayFromFileTest {

    // Тест для корректного создания массива из файла
    @Test
    public void createArrayFromFile_ValidFile_Test() throws IOException, FileNotFoundExeption, BadInputLineException {
        CreateArrayFromFile arrayFromFile = new CreateArrayFromFile("test1.txt");

        Assert.assertTrue(arrayFromFile.ready(), "Файл должен быть готов к чтению");

        MyArray array = arrayFromFile.nextArray();
        Assert.assertNotNull(array, "Массив должен быть создан");

        Assert.assertEquals(array.size(), 5, "Размер массива должен быть 5");
        Assert.assertEquals(array.get(0), 1);
        Assert.assertEquals(array.get(1), 2);
        Assert.assertEquals(array.get(2), 3);
        Assert.assertEquals(array.get(3), 4);
        Assert.assertEquals(array.get(4), 5);

        arrayFromFile.close();
    }

    // Тест для случая, когда файл не существует
    @Test(expectedExceptions = FileNotFoundExeption.class)
    public void createArrayFromFile_FileNotFound_Test() throws IOException, FileNotFoundExeption {
        // Попытка открыть несуществующий файл
        new CreateArrayFromFile("asdasfd;klawekfeqwl;k.txt");
    }

    // Тест для случая, когда строка в файле содержит некорректные данные
    @Test(expectedExceptions = BadInputLineException.class)
    public void createArrayFromFile_InvalidInput_Test() throws IOException, FileNotFoundExeption, BadInputLineException {
        CreateArrayFromFile arrayFromFile = new CreateArrayFromFile("test2.txt");

        // Пытаемся создать массив из некорректной строки, что должно вызвать исключение
        arrayFromFile.nextArray();

        arrayFromFile.close();
    }

    // Тест для проверки готовности файла к чтению
    @Test
    public void createArrayFromFile_Ready_Test() throws IOException, FileNotFoundExeption {
        CreateArrayFromFile arrayFromFile = new CreateArrayFromFile("test3.txt");
        Assert.assertTrue(arrayFromFile.ready(), "Файл должен быть готов к чтению");
        arrayFromFile.close();
    }

    // Тест для закрытия файла и проверки поведения после закрытия
    @Test(expectedExceptions = IOException.class)
    public void createArrayFromFile_Close_Test() throws IOException, FileNotFoundExeption {
        CreateArrayFromFile arrayFromFile = new CreateArrayFromFile("test3.txt");

        arrayFromFile.close();

        arrayFromFile.ready();
    }
}
