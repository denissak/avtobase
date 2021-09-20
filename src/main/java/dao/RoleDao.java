package dao;

import bean.Role;

import java.util.List;
import java.util.Optional;

public class RoleDao implements Dao<Integer, Role>{

    private static final RoleDao INSTANCE = new RoleDao();

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Role entity) {

    }

    @Override
    public Role save(Role entity) {
        return null;
    }

    public static RoleDao getInstance() {
        return INSTANCE;
    }
}
