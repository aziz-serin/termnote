package org.termnote;
import org.terminaloutput.Interface;

public class Main {
    public static void main(String[] args) {
        String filePath = "";
        try {
            filePath = args[0];
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please give the path for notes.txt file!");
            e.printStackTrace();
            System.exit(-1);
        }
        Interface anInterface = new Interface(filePath);
        anInterface.start();
    }
}