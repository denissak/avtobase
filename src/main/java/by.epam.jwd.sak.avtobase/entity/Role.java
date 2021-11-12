
package by.epam.jwd.sak.avtobase.entity;

import lombok.Builder;

import java.io.Serializable;
import java.util.Objects;

@Builder
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public Role() {
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id.equals(role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Role id = ");
        sb.append(id);
        sb.append(", role name = ");
        sb.append(name);
        return sb.toString();
    }
}
