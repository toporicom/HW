package HW2;

public class Cars {
    private String mark;
    private Integer age;
    private String serial;

    public String getMark() {
        return mark;
    }

    public Integer getAge() {
        return age;
    }

    public String getSerial() {
        return serial;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Cars(String mark, Integer age, String serial) {
        this.mark = mark;
        this.age = age;
        this.serial = serial;
    }

    @Override
    public String toString() {
        return mark + " " + age + " " + serial;
    }
}
