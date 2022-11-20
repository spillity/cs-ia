package compscia.Controller;

import compscia.word.DictionaryStore;

import java.io.*;

public class FileHandler {
    public static void writeFile(){
        Object obj = MainWindowController.getDictionary();
        FileOutputStream f = null;
        try {
            f = new FileOutputStream(new File("dictionary.dat")); //creates new .dat save file if none detected
            ObjectOutputStream o = new ObjectOutputStream(f);
            // write objects to file
            o.writeObject(obj);
            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("");
        } catch (IOException e) {
            System.out.println("");
        }
    }
    public static DictionaryStore readFromFile(){
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(new File("dictionary.dat"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            // reads objects
            DictionaryStore savedStore = (DictionaryStore) oi.readObject();
            oi.close();
            fi.close();
            return savedStore;
        } catch (FileNotFoundException e) {
            System.out.println("");
        } catch (IOException e) {
            System.out.println("");
        } catch (ClassNotFoundException e) {
            System.out.println("");
        }
        return null;
    }
}