package ru.job4j.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "drivers")
public class Driver {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(nullable = false)
   private String name;

   @ManyToMany(mappedBy = "drivers")
   private Set<Car> cars = new HashSet<>();

   public static Driver of(String name) {
      Driver driver = new Driver();
      driver.name = name;
      return driver;
   }

   public Driver() {}

   public Set<Car> getCars() {
      return cars;
   }

   public void setCar(Car car) {
      cars.add(car);
   }

   public int getId() {
      return id;
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
      Driver driver = (Driver) o;
      return id == driver.id &&
              Objects.equals(name, driver.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name);
   }
}
