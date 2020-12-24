package javaproject;
import java.util.LinkedList;
import java.io.*;

public class FileHandler {

    public LinkedList<Members> readFile(){
        LinkedList<Members> m = new LinkedList<>();
        String lineRead;
        String[] splitLine;
        Members mem;
        try (BufferedReader reader = new BufferedReader(new FileReader("//home//sergei//members.csv")))
        {
            lineRead = reader.readLine();
            while (lineRead != null){
                splitLine = lineRead.split(",");
                if (splitLine[0].equals("S")){
                    mem = (new SingleClubMember('S',Integer.parseInt(splitLine[1]),
                            splitLine[2],Double.parseDouble(splitLine[3]),Integer.parseInt(splitLine[4])));

                }else {
                    mem = (new MultiClubMember('M',Integer.parseInt(splitLine[1]),
                            splitLine[2],Double.parseDouble(splitLine[3]),Integer.parseInt(splitLine[4])));
                }
                m.add(mem);
                lineRead = reader.readLine();
            }
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return m;

    }
    public void appendFile(String mem){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("//home//sergei//members.csv",
                true))){
            writer.write(mem + "\n");

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void overWriteFile(LinkedList<Members> m){
        String s;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("//home//sergei//members.temp",false))){
            for (int i = 0; i < m.size();i++){
                s = m.get(i).toString();
                writer.write(s + "\n");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try {
            File f = new File("//home//sergei//members.csv");
            File tf = new File("//home//sergei//members.temp");

            f.delete();
            tf.renameTo(f);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
