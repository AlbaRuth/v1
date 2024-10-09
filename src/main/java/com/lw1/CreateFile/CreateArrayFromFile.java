package com.lw1.CreateFile;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import com.lw1.exceptions.FileCloseException;
import com.lw1.exceptions.FileNotReadyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lw1.entity.MyArrayClass.MyArrayImpl;
import com.lw1.entity.MyArrayClass.MyArray;
import com.lw1.exceptions.BadInputLineException;
import com.lw1.exceptions.FileNotFoundExeption;

import static com.lw1.CreateFile.InputCfg.INPUT_PATH;
import static com.lw1.CreateFile.InputCfg.DELIMITER;

public class CreateArrayFromFile implements Closeable {

	private static final Logger logger = LogManager.getLogger(CreateArrayFromFile.class);

	private final Path filePath;
	private BufferedReader fileReader;


	public CreateArrayFromFile(String fileName) throws FileNotFoundExeption {
		logger.info("Инициализация CreateArrayFromFile для файла: {}", fileName);

		filePath = INPUT_PATH.resolve(fileName);
	}

	private void initFileReader() throws FileNotFoundExeption {
		if (!filePath.toFile().exists()) {
			throw new FileNotFoundExeption("Файл " + filePath + " не существует.");
		}

		try {
			fileReader = new BufferedReader(new FileReader(filePath.toFile()));
		} catch (IOException e) {
			throw new FileNotFoundExeption("Не удалось открыть файл: " + filePath);
		}
	}

	public MyArray nextArray() throws IOException, BadInputLineException {
		if (fileReader == null) {
			initFileReader();
		}

		logger.info("Чтение строки из файла.");

		String inputLine = fileReader.readLine();
		if (inputLine == null) {
			logger.info("Файл пуст или достигнут конец файла.");
			return null;
		}

		if (CreateArrayValidator.RegExpValidator(inputLine)) {
			MyArray newArray = new MyArrayImpl();
			String[] values = inputLine.split(DELIMITER);
			for (String value : values) {
				newArray.add(Integer.parseInt(value));
			}
			logger.info("Создан новый массив.");
			return newArray;
		} else {
			throw new BadInputLineException("Неверный формат строки: " + inputLine);
		}
	}

	public boolean ready() throws IOException {
		if (fileReader == null) {
			initFileReader();
		}
		return fileReader.ready();
	}

	@Override
	public void close() throws IOException {
		logger.info("Закрытие ресурса CreateArrayFromFile.");
		if (fileReader != null) {
			fileReader.close();
		}
	}
}
