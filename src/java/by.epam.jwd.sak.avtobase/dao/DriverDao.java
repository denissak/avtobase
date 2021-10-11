package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.Driver;

import java.util.List;

public interface DriverDao {

    List<Driver> findAll();

    Driver save(Driver entity);
}
