package Agenti;

public class Agenti {
    private int id;
    private String firstname;
    private String lastname;
    private String sex;

    public Agenti(int id, String firstname, String lastname, String sex) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Agenti(){}

    @Override
    public String toString() {
        return "Agenti{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
