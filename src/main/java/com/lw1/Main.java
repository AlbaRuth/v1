package com.lw1;

import com.lw1.exceptions.BadInputLineException;
import com.lw1.exceptions.FileNotFoundExeption;
import com.lw1.CreateFile.CreateArrayFromFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Программа начала работу");

        try (CreateArrayFromFile arrayCreator = new CreateArrayFromFile("input1.txt")) {
            while (arrayCreator.ready()) {
                try {
                    // Печать массива в консоль
                    System.out.println(arrayCreator.nextArray());
                } catch (BadInputLineException e) {
                    // Логирование ошибки неверного формата строки
                    logger.warn("Неверный формат строки: {}", e.getMessage());
                    System.out.println("Неверный формат: " + e.getMessage());
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
