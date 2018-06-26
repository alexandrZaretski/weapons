package model.entity;

public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String adress;
    private String password;
    private int id_role;

    public User(String name, String email, String phone, String adress, String password, int id_role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
        this.id_role = id_role;
        this.password = password;
    }

    public User(int id, String name, String email, String phone, String adress, String password, int id_role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
        this.id_role = id_role;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", password='" + password + '\'' +
                ", id_role=" + id_role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id_role != user.id_role) return false;
        if (!name.equals(user.name)) return false;
        if (!email.equals(user.email)) return false;
        if (!phone.equals(user.phone)) return false;
        if (!adress.equals(user.adress)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + adress.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + id_role;
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdress() {
        return adress;
    }

    public int getId_role() {
        return id_role;
    }
}
