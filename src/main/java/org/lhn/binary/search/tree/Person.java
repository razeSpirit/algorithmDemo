package org.lhn.binary.search.tree;

/**
 * description:特殊复杂对象
 *
 * @author:LiHaiNan
 * @date:2018/7/18 0018 下午 7:38
 */
public class Person{
    private Integer id;
    private String name;
    private String sex;

    public Person() {
    }

    public Person(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
