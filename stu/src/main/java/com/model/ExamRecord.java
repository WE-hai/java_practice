package com.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 学生考试记录
 */
@Getter
@Setter
@ToString
public class ExamRecord {
    
    private Integer id;

    /**
     * 考试成绩
     */
    private BigDecimal score;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 考试id
     */
    private Integer examId;

    /**
     * 考试记录备注
     */
    private String examRecordDesc;

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

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamRecordDesc() {
        return examRecordDesc;
    }

    public void setExamRecordDesc(String examRecordDesc) {
        this.examRecordDesc = examRecordDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ExamRecord{" +
                "id=" + id +
                ", score=" + score +
                ", studentId=" + studentId +
                ", examId=" + examId +
                ", examRecordDesc='" + examRecordDesc + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    private Exam exam;
    private Classes classes;
    private Course course;
    private Student student;

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}