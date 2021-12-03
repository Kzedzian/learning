package zadanko7;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Notepad implements Serializable {
    Map<String, Note> allNotes;
    private final long serialVersionUID = 2317L;

    public Notepad() {
        this.allNotes = new HashMap<>();
    }



    public void addNote(String ID, String date, String author, String text) {
        Note note = new Note(ID, date, author, text);
        if (this.allNotes.containsKey(ID)) {
            System.out.println("Notatka o takim ID już istnieje!");
        } else {
            this.allNotes.put(ID, note);
            System.out.println("Notatka o ID " + note.getID() + " dodana!");
            System.out.println("Masz zapisane " + this.allNotes.size() + " notatek");
        }
    }

    public void readNote(String ID) {
        if (!this.allNotes.containsKey(ID)) {
            System.out.println("Nie ma takiej notatki!");
            System.out.println("Dostępne notatki o ID: " + this.allNotes.keySet());
        } else {
            Note noteToRead = this.allNotes.get(ID);
            System.out.println("Notatka utworzona "+ noteToRead.getDate()+" przez "+ noteToRead.getAuthor());
            System.out.println("########################");
            System.out.println(noteToRead.getText());
            System.out.println("########################");
        }

    }

    public void deleteNote(String ID) {
        if (!this.allNotes.containsKey(ID)) {
            System.out.println("Nie ma takiej notatki!");
            System.out.println("Dostępne notatki o ID: " + this.allNotes.keySet());
        } else {
            Note noteToDelete = this.allNotes.get(ID);
            allNotes.remove(ID);
            System.out.println("Usunięto notatkę o ID " + noteToDelete.getID() + " napisaną przez "
                    + noteToDelete.getAuthor() + " w dniu " + noteToDelete.getDate());
        }

    }

    public void modifyNote(String ID, String newText) {
        if (!this.allNotes.containsKey(ID)) {
            System.out.println("Nie ma takiej notatki!");
            System.out.println("Dostępne notatki o ID: " + this.allNotes.keySet());
        } else {
            Note noteToModify = this.allNotes.get(ID);
            noteToModify.setText(newText);
            System.out.println("Zmodyfikowano notatkę");
        }

    }

    public void printAllNotesIds(){
        System.out.println("Dostępne notatki o ID: " + this.allNotes.keySet());
    }

    public void printMenu() {
        System.out.println("Witaj w Twoim osobistym notatniku!");
        System.out.println("Masz zapisanych " + this.allNotes.size() + " notatek");
        System.out.println("Co chcesz zrobić?");
        System.out.println("Przeczytać notatkę = 1");
        System.out.println("Dodać notatkę = 2");
        System.out.println("Usunąć notatkę = 3");
        System.out.println("Zmienić tekst notatki = 4");
        System.out.println("Zobaczyć menu = 5");
        System.out.println("Dostępne notatki = 6");
        System.out.println("Zakończyć = 0");
    }
}
