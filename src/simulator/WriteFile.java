package simulator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static WriteFile writefile;
    BufferedWriter bw;
    FileWriter fw;

    public WriteFile() {
        try{
            fw = new FileWriter("simulation.txt");
            bw = new BufferedWriter(fw);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static WriteFile getWriteFile(){
        if (writefile == null)
            writefile = new WriteFile();
        return writefile;
    }

    public void WriteToFile(String content)
    {
        try {
            bw.write(content);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public void closeFile()
    {
        try {
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}