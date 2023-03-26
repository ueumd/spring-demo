package net.biancheng.www.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 *
 * @Component 将JavaBean对象添加到容器中
 * @Value
 * 当我们只需要读取配置文件中的某一个配置时，可以通过 @Value 注解获取。
 *
 * @ConfigurationProperties：支持所有类型数据的封装，例如 Map、List、Set、以及对象等；
 * @Value：只支持基本数据类型的封装，例如字符串、布尔值、整数等类型。
 */

@Component
public class PersonValue {
    @Value("${person2.lastName}")
    private String lastName;

    @Value("${person2.age}")
    private Integer age;

    @Value("${person2.boss}")
    private Boolean boss;

    @Value("${person2.birth}")
    private Date birth;
    private Map<String, Object> maps;

    private List<String> lists;
    private Dog dog;

    public PersonValue(){}

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return this.maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<String> getLists() {
        return this.lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return this.dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public PersonValue(String lastName, Integer age, Boolean boss, Date birth, Map<String, Object> maps, List<String> lists, Dog dog) {
        this.lastName = lastName;
        this.age = age;
        this.boss = boss;
        this.birth = birth;
        this.maps = maps;
        this.lists = lists;
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
