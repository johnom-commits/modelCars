package ru.job4j.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "engines")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private double volume;

    @Column(nullable = false)
    private double power;

    public static Engine of(String model, double volume, double power) {
        Engine engine = new Engine();
        engine.model = model;
        engine.volume = volume;
        engine.power = power;
        return engine;
    }

    public Engine() {
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

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return id == engine.id &&
                Double.compare(engine.volume, volume) == 0 &&
                Double.compare(engine.power, power) == 0 &&
                Objects.equals(model, engine.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, volume, power);
    }
}
