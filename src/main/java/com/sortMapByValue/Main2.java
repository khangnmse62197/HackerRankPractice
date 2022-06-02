package main.java.com.sortMapByValue;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {

    public static final String PATH_TO_FILE = "src/main/java/com/sortMapByValue/myFile.dat";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyObj myObj = new MyObj("aaaa", 1);
        MyObj myObj2 = new MyObj("abz", 1);
        MyObj myObj3 = new MyObj("aab", 1);

        List<MyObj> myObjList = new ArrayList<>(Arrays.asList(myObj, myObj2, myObj3));

        serializeDataOut(myObjList);

        System.out.println(serializeDataIn());
    }

    public static void serializeDataOut(List<MyObj> myObjList)throws IOException{
        FileOutputStream fos = new FileOutputStream(PATH_TO_FILE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(myObjList);
        oos.close();
    }

    public static List<MyObj> serializeDataIn() throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(PATH_TO_FILE);
        ObjectInputStream ois = new ObjectInputStream(fin);
        List<MyObj> iHandler= (List<MyObj>) ois.readObject();
        ois.close();
        return iHandler;
    }
}
