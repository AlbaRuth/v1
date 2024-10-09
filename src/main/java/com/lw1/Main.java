package com.lw1;

import com.lw1.exceptions.BadInputLineException;
import com.lw1.exceptions.FileNotFoundExeption;
import com.lw1.service.MyArraySortMethods;
import com.lw1.entity.MyArrayClass.MyArray;
import com.lw1.CreateFile.CreateArrayFromFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static com.lw1.service.MyArrayMethods.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Программа начала работу");

        try (CreateArrayFromFile arrayCreator = new CreateArrayFromFile("test3.txt")) {
            while (arrayCreator.ready()) {
                try {
                    MyArray array = arrayCreator.nextArray();

                    System.out.println("Исходный массив: " + array);

                    array = MyArraySortMethods.bubbleSort(array, true);

                    System.out.println("Отсортированный массив (по возрастанию): " + array);

                    array.remove(3);
                    System.out.println("Массив без третьего элемента " + array);
                    array.add(14);
                    array.add(15);
                    array.add(116);
                    array.add(117);
                    array.replace(116, 16);
                    array.replace(12, 7);
                    System.out.println(array);
                    System.out.println("Минимальное значение:" + getMinValue(array));
                    System.out.println("Максимальное значение:" + getMaxValue(array));
                    System.out.println("Среднее значение:" + averageOfValues(array));

                } catch (BadInputLineException e) {
                    logger.warn("Неверный формат строки: {}", e.getMessage());
                    System.out.println("Неверный формат строки: " + e.getMessage());
                }
            }
        } catch (FileNotFoundExeption e) {
            // Обработка ошибки отсутствия файла
            logger.error("Ошибка при чтении файла: {}", e.getMessage());
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (IOException e) {
            // Обработка ошибок при закрытии файла или других IO-ошибок
            logger.error("Произошла IO-ошибка: {}", e.getMessage(), e);
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
        logger.info("Программа завершила работу");
    }
}
