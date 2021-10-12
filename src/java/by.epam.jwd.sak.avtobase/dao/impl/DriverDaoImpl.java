package by.epam.jwd.sak.avtobase.dao.impl;

import by.epam.jwd.sak.avtobase.bean.Driver;
import by.epam.jwd.sak.avtobase.dao.DriverDao;

import java.util.List;
import java.util.Optional;

public class DriverDaoImpl implements DriverDao {

    @Override
    public Optional<Driver> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Driver> findAll() {
        return null;
    }

    @Override
    public Driver save(Driver entity) {
        return null;
    }
}
