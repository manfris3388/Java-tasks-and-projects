package lt.codeacademy.model;

public class People {
    private final int ID;
    private final String NAME;
    private final String surname;

    public People(int id, String name, String surname) {
        this.ID = id;
        this.NAME = name;
        this.surname = surname;
    }

    public int getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" +
                ", name='" + NAME + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
