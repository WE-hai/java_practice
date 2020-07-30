package com.dao;

import com.model.DictionaryTag;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static List<DictionaryTag> queryAsDict(int id) {
        List<DictionaryTag> tags = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c=DBUtil.getConnection();
            String sql = "select id,student_name from student where classes_id=?";
            ps=c.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                DictionaryTag tag = new DictionaryTag();
                tag.setDictionaryTagKey(String.valueOf(rs.getInt("id")));
                tag.setDictionaryTagValue(rs.getString("student_name"));
                tags.add(tag);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询学生数据字典出错",e);
        }
        return tags;
    }
}
