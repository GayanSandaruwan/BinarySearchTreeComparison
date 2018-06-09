package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader {


    public ArrayList<Long> read(String filePath) {
        BufferedReader bufferedReader = null;
        String stringLine;

        ArrayList<Long> numbers = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));

            while ((stringLine = bufferedReader.readLine()) != null) {
                String[] strDataArr = stringLine.split("\\,");

                for (String strData : strDataArr) {
                    numbers.add(Long.valueOf(strData));
                }

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return numbers;
    }
}
