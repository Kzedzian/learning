package zadanko7;


import java.io.Serializable;

public class Note implements Serializable {
    private final String ID;
    private final String date;
    private final String author;
    private String text;
    private final long serialVersionUID = 420L;

    public Note(String ID, String date, String author, String text) {
        this.ID = ID;
        this.date = date;
        this.author = author;
        this.text = text;
    }

    public String getID() {
        return ID;
    }


    public String getDate() {
        return date;
    }


    public String getAuthor() {
        return author;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
