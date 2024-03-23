package DZ4;

import java.io.*;

public class Car implements Externalizable {
    public String name;
    public String mark;
    public Integer age;
    public Integer mass;
    public Integer length;

    public Car(String name, String mark, Integer age, Integer mass, Integer length) {
        this.name = name;
        this.mark = mark;
        this.age = age;
        this.mass = mass;
        this.length = length;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getMass() {
        return mass;
    }

    public Integer getLength() {
        return length;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.getMark());
        out.writeObject(this.getAge());
        out.writeObject(this.getMass());
        out.writeObject(this.getLength());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
        this.mark = (String) in.readObject();
        this.age = (Integer) in.readObject();
        this.mass = (Integer) in.readObject();
        this.length = (Integer) in.readObject();
    }

    @Override
    public String toString() {
        return "Имя: " + name + " Марка: " + mark + " Год: " + age + " Масса: " + mass + " Длина: " + length;
    }

}
