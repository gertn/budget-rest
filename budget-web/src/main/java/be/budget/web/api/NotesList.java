package be.budget.web.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="notes")
public class NotesList {

    private String result;

    public NotesList() {
    }

    public NotesList(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
