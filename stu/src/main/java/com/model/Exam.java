package com.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 考试信息
 */
@Getter
@Setter
@ToString
public class Exam extends DictionaryTag {
    
    private Integer id;

    /**
     * 考试名称
     */
    private String examName;

    /**
     * 考试备注
     */
    private String examDesc;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 班级id
     */
    private Integer classesId;

    /**
     * 创建时间
     */
    private Date createTime;

    private Classes classes;

    private Course course;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamDesc() {
        return examDesc;
    }

    public void setExamDesc(String examDesc) {
        this.examDesc = examDesc;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", examDesc='" + examDesc + '\'' +
                ", courseId=" + courseId +
                ", classesId=" + classesId +
                ", createTime=" + createTime +
                ", classes=" + classes +
                ", course=" + course +
                '}';
    }
}