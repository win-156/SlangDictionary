import javax.swing.*;


import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;;
public class Diraction{


    public static void readFile(String nameFile) throws IOException
    {
        BufferedReader fi = new BufferedReader(new FileReader(nameFile));
        String str = "";
        str = fi.readLine();
        TreeMap<String, String> map = new TreeMap<String, String>();
        while((str = fi.readLine()) != null)
        {
            String[] splitStr = str.split("`");
            if(splitStr.length < 2)
            {
                continue;
            }
            map.put(splitStr[0], splitStr[1]);
        }

        show(map);
        // findDefinition(map, "aaaaaaa");
        // findKey(map, "Anything");
    }
    public static void show(TreeMap<String, String> map) {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " - " + map.get(key));
        }
    }
    public static void findDefinition(TreeMap<String, String> map,String keyE){

        System.out.println(map.get(keyE));

    }
    public static void findKey(TreeMap<String, String> map, String keyWord)
    {
        String strGet;
        Iterator<String> itr = map.keySet().iterator();
        while(itr.hasNext()){
            strGet = map.get(itr.next());
            if(strGet.contains(keyWord))
                System.out.println(strGet);
        }
    }
    public static void addSlang(TreeMap<String, String>map, String slangWord, String Definition)
    {
        if(map.get(slangWord) == null)
        {
            map.put(slangWord, Definition);
        }
        else
        {
            System.out.println("Da ton tai!");
        }
    }
    public static void editSlang(TreeMap<String, String>map, String slangWord, String Definition)
    {
        if(map.get(slangWord) != null)
        {
            map.put(slangWord, Definition);
        }
        else
        {
            System.out.println("Khong ton tai");
        }
    }

    public static void deleteSlang(TreeMap<String, String>map, String slangWord)
    {
        if(map.get(slangWord) != null)
        {
            map.remove(slangWord);
        }
        else
        {
            System.out.println("Khong ton tai");
        }
    }
    public static void resetSlang(TreeMap<String, String>map) throws IOException
    {
        map.clear();
        readFile("slang.txt");
    }
    public static void randomSlang(TreeMap<String, String>map){
        
    }

    public static void main(String []agrs) throws IOException
    {
        readFile("slang.txt");

    }
}