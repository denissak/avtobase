package by.epam.jwd.sak.avtobase.bean;

import lombok.Builder;

import java.io.Serializable;
import java.util.Objects;

@Builder

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private Role role;

    public User() {
    }

    public User(Integer id, String login, String password, String name, String surname, String phoneNumber, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User ");
        sb.append(" id  =");
        sb.append(id);
        sb.append(", login = ");
        sb.append(login);
        sb.append(", password = ");
        sb.append(password);
        sb.append(", name = ");
        sb.append(name);
        sb.append(", surname = ");
        sb.append(surname);
        sb.append(", phoneNumber = ");
        sb.append(phoneNumber);
        sb.append(", role = ");
        sb.append(role);
        return sb.toString();
    }
}
