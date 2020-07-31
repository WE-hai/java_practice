package com.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 班级表
 */
@Getter
@Setter
@ToString
public class Classes {
    
    private Integer id;

    /**
     * 班级名称
     */
    private String classesName;

    /**
     * 毕业年份，数据字典000001
     */
    private String classesGraduateYear;

    /**
     * 专业，数据字典000002
     */
    private String classesMajor;

    /**
     * 备注
     */
    private String classesDesc;

    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getClassesGraduateYear() {
        return classesGraduateYear;
    }

    public void setClassesGraduateYear(String classesGraduateYear) {
        this.classesGraduateYear = classesGraduateYear;
    }

    public String getClassesMajor() {
        return classesMajor;
    }

    public void setClassesMajor(String classesMajor) {
        this.classesMajor = classesMajor;
    }

    public String getClassesDesc() {
        return classesDesc;
    }

    public void setClassesDesc(String classesDesc) {
        this.classesDesc = classesDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", classesName='" + classesName + '\'' +
                ", classesGraduateYear='" + classesGraduateYear + '\'' +
                ", classesMajor='" + classesMajor + '\'' +
                ", classesDesc='" + classesDesc + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}