package by.epam.jwd.sak.avtobase.dao;

import by.epam.jwd.sak.avtobase.bean.Car;

import java.util.List;

public interface CarDao {

    List<Car> findAll();

    Car save(Car entity);
}
