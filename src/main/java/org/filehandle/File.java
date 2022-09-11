package org.filehandle;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class File {
    private List<String> notes;

    public void readNotes(String filename) {
        notes = new ArrayList<>();
        try{
            java.io.File file  = new java.io.File(filename);
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String note = reader.nextLine();
                notes.add(note);
            }
        }catch(FileNotFoundException e){
            System.out.println("Could not find and/or read the file!");
            e.printStackTrace();
        }
    }

    public boolean isEmpty(){
        if(this.notes.isEmpty()){
            System.out.println("Your notes seems to be empty, you can add some if you want!");
            return true;
        }
        return false;

    }

    public void addNotes(String str){
        notes.add(str);
    }

    public boolean deleteNotes(int index){
        if(index > this.notes.size()){
            return false;
        }
        this.notes.remove(index-1);
        return true;

    }

    public void writeNotes(String filename){
        try{
            FileWriter writer = new FileWriter(filename);
            for(String note : this.notes){
                writer.write(note);
            }
            writer.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
