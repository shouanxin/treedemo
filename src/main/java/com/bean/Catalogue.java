package com.bean;

import java.io.Serializable;

/**
 * 目录结构bean文件
 */
public class Catalogue implements Serializable{

    private int id;//目录id
    private String name;//目录名称
    private int pid;//上级目录id

    /**
     * 无参构造
     */
    public Catalogue() {
    }

    /**
     * 三个参数的构造函数
     * @param id
     * @param name
     * @param pid
     */
    public Catalogue(int id, String name, int pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;
    }

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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                '}';
    }
}
