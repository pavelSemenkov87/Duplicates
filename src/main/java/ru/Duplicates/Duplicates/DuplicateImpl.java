package ru.Duplicates.Duplicates;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class DuplicateImpl implements Duplicate {
    public DuplicateImpl() {
    }

    @Override
    public boolean process(File firstFile, File secondFile) {
        Map<String, Integer> map = new TreeMap<String, Integer>(); //использовал TreeMap, так как он автоматом сортирует по ключу + позволяет хранить только уникальные значения ключа
        String line = null; //временная переменная для хранения строк из файла sourceFile
        try (BufferedReader br = new BufferedReader(new FileReader(firstFile)); //использую try-with-resources для автозакрытия потоков
             FileWriter fw = new FileWriter(secondFile, true)) { //создаю 2 потока, на чтение и на запись с возможность дописывать файл
            if (!firstFile.exists())
                throw new FileNotFoundException(); //проверяю существование файла sourceFile, если его нету выбрасываю FileNotFoundException и возвращаю false
            if (!secondFile.exists())
                secondFile.createNewFile(); //проверяю существование файла targetFile, если его нету создаю новый

            while ((line = br.readLine()) != null) { //считываем построчно данные из sourceFile
                if (!map.containsKey(line)) { //проверяем не содержит ли мапка ключ со значением строки
                    map.put(line, 1); //так как данного ключа нет ложим в мапу и ставим value 1
                } else {
                    map.replace(line, map.get(line).intValue() + 1); // иначе берем наш мап с текущим ключом и инкрементируем value
                }
            }
            for (Map.Entry<String, Integer> lines : map.entrySet()) { //бежим по мапе и пишем в файл
                fw.write(lines.getKey() + "[" + lines.getValue() + "]\n");
            }
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Файла first.txt не существует!, проверьте директорию папки interfaces!");
            return false;
        } catch (Exception ex) {
            return false;
        }
    }
}
