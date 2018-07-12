package simulator.aircrafts;

import simulator.WriteFile;

public class main {

    public static void main(String[] args)
    {
        Coordinates coordinates = new Coordinates(1, 1, 1);

//        Aircraft obj1 = new Aircraft("Name", coordinates);
//        Aircraft obj2 = new Aircraft("just",coordinates);
//        Aircraft obj3 = new Aircraft("nom", coordinates);
//
//        System.out.println(obj1.nextId());
//        System.out.println(obj2.nextId());
//        System.out.println(obj3.nextId());

        WriteFile writeFile = new WriteFile();

        writeFile.WriteToFile("1");

    }
}
