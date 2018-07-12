package simulator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WriteFileTest {

    @Test
    void writeToFile() {
        WriteFile writeFile = WriteFile.getWriteFile();
        writeFile.WriteToFile("Annoying");
        writeFile.WriteToFile("First time for everything");
        writeFile.WriteToFile("My first time was a long time ago");
        writeFile.closeFile();
    }
}