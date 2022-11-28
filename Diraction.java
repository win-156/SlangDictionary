package SlangDictionary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;


public class Diraction{
    JFrame Jcontain, frameEx1, frameEx2,frameEx3,frameEx4,frameEx5,frameEx6,frameEx7,frameEx8,frameEx9,frameEx10;
    JButton bt1, bt2, bt3, bt4, bt5,bt6,bt7,bt8,bt9, bt10;
    JPanel jp1, jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9,jp10;
    JLabel jl1, jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;

    public TreeMap<String, ArrayList<String>> getMap() {
        return map;
    }

    private TreeMap<String, ArrayList<String>> map;

    public void setMap(TreeMap<String, ArrayList<String>> map) {
        this.map = map;
    }

    public Diraction(){
        Jcontain = new JFrame();
        Jcontain.setSize(500,500);
        Jcontain.setLayout(new GridLayout(5, 5));
        Jcontain.setDefaultCloseOperation(Jcontain.EXIT_ON_CLOSE);
        bt1 = new JButton("Execise 1");
        bt2 = new JButton("Execise 2");
        bt3 = new JButton("Execise 3");
        bt4 = new JButton("Execise 4");
        bt5 = new JButton("Execise 5");
        bt6 = new JButton("Execise 6");
        bt7 = new JButton("Execise 7");
        bt8 = new JButton("Execise 8");
        bt9 = new JButton("Execise 9");
        bt10 = new JButton("Execise 10");

        Jcontain.add(bt1);
        Jcontain.add(bt2);
        Jcontain.add(bt3);
        Jcontain.add(bt4);
        Jcontain.add(bt5);
        Jcontain.add(bt6);
        Jcontain.add(bt7);
        Jcontain.add(bt8);
        Jcontain.add(bt9);
        Jcontain.add(bt10);

        Jcontain.setVisible(true);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok");
            }
        });
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok");
            }
        });
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok");
            }
        });
        bt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok");
            }
        });
        bt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok");
            }
        });
        bt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok");
            }
        });
        bt7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok");
            }
        });
        bt8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok");
            }
        });
        bt9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok");
            }
        });
        bt10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setMap(readFile("SlangDictionary/slang.txt"));
                    show(getMap());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Execise1();
            }
        });
    }

    public void show(TreeMap<String, ArrayList<String>> map) {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " - " + map.get(key));
        }
    }
    public void Execise1() {
        frameEx1 = new JFrame();
        frameEx1.setLayout(new FlowLayout());
        frameEx1.setTitle("Execise 1");

        JPanel frameEx1Child = new JPanel();
        frameEx1Child.setLayout(new GridLayout(1,1));
        JTextField jSlang = new JTextField();
        JButton jSearchSlang = new JButton("Search");

        frameEx1Child.add(jSlang);
        frameEx1Child.add(jSearchSlang);
        frameEx1.add(frameEx1Child);

        jSearchSlang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TreeMap<String, ArrayList<String>> map = getMap();
                String []headerStr = {"Key", "Value"};
                String [][]data = {{"1","2"},{"1","2"}};
                DefaultTableModel model = new DefaultTableModel(data, headerStr);
                JTable table = new JTable(model);
                JButton j = new JButton("okla");
//                model.insertRow(0, headerStr);
//                model.insertRow(1, map.get(jSlang.getText()).toArray());

                frameEx1.add(j);
                frameEx1.add(table);
                System.out.println(map.get(jSlang.getText()));
            }
        });

        frameEx1.setSize(500, 500);
        frameEx1.setVisible(true);

    }

    public TreeMap<String, ArrayList<String>> readFile(String nameFile) throws IOException {
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
//            System.out.println(str);
            ArrayList<String> strings = new ArrayList<>(Arrays.asList(splitDefini));
            map.put(splitStr[0], strings);
        }
        return map;
    }
    public static void main(String []ags)
    {
        new Diraction();
        
    }
}
