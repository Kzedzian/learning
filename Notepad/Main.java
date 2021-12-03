package zadanko7;

//7. Troche grubsze zadanko stworzyc sobie program do przechowywania krotkich notatek.
//        Stworzyc klase Note z polami id, dataDodania, autor tresc
//        (na razie wszystkie moga byc stringiem).
//        przechowywac je wszystkie w mapie Map<String, Note> gdzie kluczem String Id.
//        uzytkownik moze dodawac sobie notatki, a potem je odczytac, przykładowa interakcja:
//        >Witam w notatniku! Co chcesz zrobic? Dodac notatke (1), przeczytac notatke (2)?
//        >dupa
//        >Musisz wybrac 1 albo 2
//        >1
//        >Podaj Id notatki
//        >ASD
//        >Podaj Date notatki
//        >2020-03-25
//        >Podaj autora notatki
//        >Moj stary
//        >Podaj tresc notatki
//        >uwielbiam pierogi
//        >Notatka dodana! Co chcesz zrobic? Dodac notatke (1), przeczytac notatke (2)?
//        >2
//        >Podaj id notatki (dostepne id: ASD)
//        >dupa
//        >Nie ma takiego ID notatki
//        >ASD
//        >data: 2020-03-25, autor: Moj stary, tresc: uwielbiam pierogi
//        >Co chcesz zrobic? Dodac notatke (1), przeczytac notatke (2)?
//        >(...)


import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Notepad notepad = new Notepad();

        try{
            ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("notepad.dat")));
            try{
                notepad = (Notepad) locFile.readObject();
            }
            catch(ClassNotFoundException ce){
                System.out.println(ce.getMessage());
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }


        notepad.printMenu();
        boolean notepadOn = true;
        while (notepadOn) {
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 0: {
                    try{
                        ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream
                                (new FileOutputStream("notepad.dat")));
                        locFile.writeObject(notepad);
                        locFile.close();
                    }
                    catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    notepadOn = false;
                    System.out.println("Do zobaczenia!");
                    break;
                }
                case 1: {
                    System.out.println("Podaj ID notatki");
                    String ID = scanner.nextLine();
                    notepad.readNote(ID);
                    break;
                }
                case 2: {
                    System.out.println("Podaj nowe ID");
                    String ID = scanner.nextLine();
                    System.out.println("Podaj datę");
                    String date = scanner.nextLine();
                    System.out.println("Podaj autora");
                    String author = scanner.nextLine();
                    System.out.println("Wpisz tekst notatki");
                    String text = scanner.nextLine();

                    notepad.addNote(ID, date, author, text);
                    break;
                }
                case 3: {
                    System.out.println("Podaj ID notatki do usunięcia");
                    String ID = scanner.nextLine();
                    notepad.deleteNote(ID);
                    break;
                }
                case 4: {
                    System.out.println("Podaj ID notatki do modyfikacji");
                    String ID = scanner.nextLine();
                    System.out.println("Podaj nowy tekst notatki");
                    String text = scanner.nextLine();
                    notepad.modifyNote(ID, text);
                    break;
                }
                case 5: {
                    notepad.printMenu();
                    break;
                }
                case 6: {
                    notepad.printAllNotesIds();
                    break;
                }
                default:
                    System.out.println("Zła komenda, spróbuj jeszcze raz");
                    notepad.printMenu();
            }
        }
    }
}
