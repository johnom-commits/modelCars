package ru.job4j.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String model;

    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "history_owner", joinColumns = {
            @JoinColumn(name = "car_id", nullable = false, updatable = false, foreignKey = @ForeignKey(name = "CAR_ID_FK"))},
            inverseJoinColumns = {@JoinColumn(name = "driver_id",
                    nullable = false, updatable = false, foreignKey = @ForeignKey(name = "DRIVER_ID_FK"))})
    private Set<Driver> drivers = new HashSet<>();

        public static Car of(String model, Engine engine) {
        Car car = new Car();
        car.model = model;
        car.engine = engine;
        return car;
    }

    public Car() {}

    public void addDrivers(Driver driver) {
        drivers.add(driver);
        driver.getCars().add(this);
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Driver driver) {
        drivers.add(driver);
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                Objects.equals(model, car.model) &&
                Objects.equals(engine, car.engine) &&
                Objects.equals(drivers, car.drivers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, engine, drivers);
    }
}
