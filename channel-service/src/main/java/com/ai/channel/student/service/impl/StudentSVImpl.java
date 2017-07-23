package com.ai.channel.student.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ai.channel.student.dao.StudentMapper;
import com.ai.channel.student.entity.Student;
import com.ai.channel.student.entity.StudentExample;
import com.ai.channel.student.service.interfaces.IStudentSV;
import com.github.pagehelper.PageHelper;

@Service
public class StudentSVImpl implements IStudentSV{
	@Resource
	private StudentMapper studentMapper;
	
	
	@Override
	public List<Map> selectStudentScore(Map sno) {
		return studentMapper.selectStudentScore(sno);
	}

	@Override
	public Student getStudentById(String id) {
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Student> getStudents(StudentExample studentExample) {
		return studentMapper.selectByExample(studentExample);
	}

	@Override
	public int updateStudentById(Student student) {
		return studentMapper.updateByPrimaryKeySelective(student);
	}
	
	@Override
	public int updateStudent(Student student, StudentExample studentExample) {
		return studentMapper.updateByExampleSelective(student, studentExample);
	}

	@Override
	public int insertStudent(Student student) {
		return studentMapper.insertSelective(student);
	}

	@Override
	public int deleteStudentById(String id) {
		return studentMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public int deleteStudent(StudentExample studentExample) {
		return studentMapper.deleteByExample(studentExample);
	}



}
