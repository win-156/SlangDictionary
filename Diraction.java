import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Diraction{

    private TreeMap<String,ArrayList<String>> _map;
    private TreeMap<String,String> _history;
    Scanner cinStr = new Scanner(System.in);
    Scanner cinInt = new Scanner(System.in);



    public void setHistory(TreeMap<String,String> history) {
        this._history = history;
    }
    public TreeMap<String,String> getHistory() {
        return _history;
    }



    public void setMap(TreeMap<String, ArrayList<String>> map) {
        this._map = map;
    }
    public TreeMap<String, ArrayList<String>> getMap() {
        return _map;
    }

    public Diraction() throws IOException{
        setHistory(readFileHistory("history.txt"));
        setMap(readFileSlang("slang.txt"));
    }

    public TreeMap<String,String> readFileHistory(String file) throws IOException{
        BufferedReader fi = new BufferedReader(new FileReader(file));
        String str = "";
        TreeMap<String,String> history = new TreeMap<String,String>();
        
        while((str = fi.readLine()) != null)
        {
            String[] splitStr = str.split("`");
            history.put(splitStr[0], splitStr[1]);
        }
        fi.close();
        return history;
    }
    public void writeHistory(String file) throws IOException{

        if(this._history == null)
            return;
        BufferedWriter fo = new BufferedWriter(new FileWriter(file));

        Set<String> keySet = this._history.keySet();
        for (String key : keySet) {
            fo.write(key + "`" + this._history.get(key) + "\n");
        }
        fo.close();
    }
    public TreeMap<String, ArrayList<String>> readFileSlang(String nameFile) throws IOException {
        BufferedReader fi = new BufferedReader(new FileReader(nameFile));
        String str = "";
        str = fi.readLine();
        TreeMap<String, ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();
        while((str = fi.readLine()) != null)
        {
            String[] splitStr = str.split("`");
            if(splitStr.length < 2)
            {
                continue;
            }
            String[] splitDefini = splitStr[1].split("\\| ");
            ArrayList<String> strings = new ArrayList<>(Arrays.asList(splitDefini));
            map.put(splitStr[0], strings);
        }
        fi.close();
        return map;
    }

    public void show() {

        if(this._map == null)
        {
            System.out.println("Dictionary empty!");
            return;
        }
        Set<String> keySet = this._map.keySet();
        for (String key : keySet) {
            System.out.println(key + " - " + this._map.get(key));
        }
    }

//Ex2
    public void findDefinition(String keyWord)
    {
        TreeMap<String, ArrayList<String>> map = getMap();
        Iterator<String> itr = map.keySet().iterator();
        while(itr.hasNext()){
            ArrayList<String> strGet = map.get(itr.next());
            int length = strGet.size();

            for(int i = 0; i < length; i++)
            {
                if(strGet.get(i).contains(keyWord))
                {
                    System.out.println(itr.next() + " - " + map.get(itr.next()));
                    break;
                }
            }
        }
    }
//EX1
    public void findSlangWord(String keyE){
        TreeMap<String, ArrayList<String>> map = getMap();
        System.out.println( keyE+" - "+ map.get(keyE));
        addHistory(keyE);
    }
    
//EX3
    public void addHistory(String slangWord){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());
        this._history.put(timeStamp,slangWord);
    }
    public void showHistory(){

        if(this._history == null){
            System.out.println("History empty!");
            return;
        }
        Set<String> keySet = this._history.keySet();
        for (String key : keySet) {
            System.out.println(key + " - " + this._history.get(key));
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
    public  void editSlang(String slangWord, String Definition)
    {
        TreeMap<String,ArrayList<String>> map = getMap();

        if(map.get(slangWord) == null)
        {   
            ArrayList<String> definition = new ArrayList<>();
            definition.add(Definition);
            map.put(slangWord, definition);
        }
        else
        {
            System.out.print("Đã tồn tại: " + slangWord + " (Duplication:1, override:2)");
            String choose = cinStr.nextLine();
            if(choose == "1")
            {
                map.get(slangWord).add(Definition);
            }
            else{
                map.put(slangWord, new ArrayList<String>(Arrays.asList(Definition)));
            }
        }
        setMap(map);
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
    public void resetSlang() throws IOException
    {
        setMap(readFileSlang("slang.txt"));
    }
    public String randomSlang(){

        TreeMap<String, ArrayList<String>> map = getMap();
        Random ran = new Random();
        int i = ran.nextInt(map.size()-1);

        return (String)map.keySet().toArray()[i];
    }
    // public boolean GameSlang(String option){
        
    //     String strSlang = randomSlang(), strDefini = map.get(strSlang);
    //     if (option == strDefini)
    //     {
    //         return true;
    //     }
        
    //     return true;


    // }

    public static void main(String []agrs) throws IOException
    {
        Diraction a = new Diraction();
        
        System.out.println("1) Hiển thị toàn bộ từ điển\n"
                           + "1) Tìm kiếm theo slang word\n"
                           + "2) tìm kiếm theo definition\n"
                           + "3) Hiển thị History!\n"
                           + "4) Add 1 slang words mới\n"
                           + "5) Edit 1 slang word\n"
                           + "6) Delete 1 slang word\n"
                           + "7) Reset danh sách slang words gốc\n"
                           + "8) Random 1 slang word\n"
                           + "9) Game slang word\n"
                           + "10) Game definition\n");  

        int chooseEx = a.cinInt.nextInt();
        String StrSearch;
        switch(chooseEx){
            case 1:
                System.out.print("input Slang Word:");
                StrSearch = a.cinStr.nextLine();
                a.findSlangWord(StrSearch);
                break;
            case 2:
                
            default:
                break;
        }

        a.showHistory();
        // a.writeHistory("history.txt");
        // a.show();

    }
}