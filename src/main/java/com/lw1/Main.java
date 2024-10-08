package com.lw1;

import com.lw1.exceptions.BadInputLineException;
import com.lw1.exceptions.FileNotFoundExeption;
import com.lw1.CreateFile.CreateArrayFromFile;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main( String[] args ){
        logger.info("Программа начала работу"); //&

        try (CreateArrayFromFile arrayCreator = new CreateArrayFromFile("input1.txt")) {
            while (arrayCreator.ready()) {
                try {
                    System.out.println(arrayCreator.nextArray());
                } catch (BadInputLineException e) {
                    System.out.println("Неверный формат: " + e.getMessage());
                }
            }
        } catch (FileNotFoundExeption e){
            logger.error("Ошибка при чтении файла: " + e.getMessage()); //&
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (IOException e){
            logger.error("There is problems with IO");
            e.printStackTrace();
        }
        
        logger.info("Программа завершила работу"); //&
    }
}
