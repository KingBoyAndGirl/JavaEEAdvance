package com.king.domain;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: com.king.domain
 * @ClassName: Province
 * @Author: 王团结
 * @Description:
 * @Date: 2019/8/6 19:47
 * @Version: 1.0
 */
public class Province {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
