package org.terminaloutput;

import org.filehandle.File;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Interface {

    private String fileName;
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private File file;

    public Interface(String fileName){
        this.fileName = fileName;
        this.file = new File();
        this.file.readNotes(fileName);
    }

    public void printNotes(){
        int size = this.file.getSize();
        List<String> notes = file.getNotes();
        for(int i=0; i<size; i++){
            String note = notes.get(i);
            String noteToPrint = Integer.toString(i+1).concat(". ").concat(note);
            System.out.println(ANSI_GREEN + noteToPrint + ANSI_RESET);
        }
    }

    public void addNotes(){
        System.out.println("Add some notes! When you are done, enter s to quit to stop entering notes!");
        Scanner reader = new Scanner(System.in);
        while(true){
            String input = reader.nextLine();
            if(input.equals("s")){
                break;
            }
            file.addNotes(input);
        }
    }

    public void deleteNotes(){
        System.out.println("Enter the number next to the note you want to delete, enter s to stop deleting!");
        Scanner reader = new Scanner(System.in);
        while(true){
            String input = reader.nextLine();
            if(input.equals("s")){
                break;
            }
            int index;
            try{
                index = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("Enter a valid integer!");
                continue;
            }
            // deleteNotes in File.java checks if the index is valid
            if(!file.deleteNotes(index)){
               System.out.println("Enter a valid index!");
            }
        }
    }

    public void quit(){
        // write to the file and exit
        this.file.writeNotes(this.fileName);
        System.out.println(ANSI_PURPLE + "Thank you for using termnote!" + ANSI_RESET);
        System.exit(0);
    }

    public void start(){
        System.out.println(ANSI_PURPLE + "Welcome to termnote!" + ANSI_RESET);
        if(this.file.isEmpty()){
            System.out.println(ANSI_RED +  "Looks like do not have any notes. " + ANSI_RESET);
        }
        getUserInput();
    }

    public void getUserInput(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a to add notes, d to delete them, p to see your notes, and q to quit!");
        String input;
        while (true){
            input = reader.nextLine();
            if(!input.equals("a") && !input.equals("d") && !input.equals("p") && !input.equals("q")){
                System.out.println("Invalid input!");
                continue;
            }
            break;
        }
        processInput(input);
    }

    public void processInput(String str){
        switch (str){
            case "a": addNotes();
            break;
            case "p": printNotes();
            break;
            case "d": deleteNotes();
            break;
            case "q": quit();
            break;
            default: break;
        }
        getUserInput();
    }


}
