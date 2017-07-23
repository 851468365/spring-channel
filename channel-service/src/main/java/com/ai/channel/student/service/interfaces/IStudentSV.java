package com.ai.channel.student.service.interfaces;

import java.util.List;
import java.util.Map;

import com.ai.channel.student.entity.Student;
import com.ai.channel.student.entity.StudentExample;

/**
 * 	学生管理
 */
public interface IStudentSV {
	
	/**
	 * 获取学生考试分数信息
	 */
    List<Map> selectStudentScore(Map sno);
	/**
	 * 根据ID查询学生信息
	 * @param id 学生ID
	 * @return 学生实体
	 */
	public Student getStudentById(String id);

	/**
	 * 查询学生信息
	 * @param studentExample 查询条件
	 * @return 学生列表
	 */
	public List<Student> getStudents(StudentExample studentExample);

	/**
	 * 根据ID更新学生信息
	 * @param student 学生信息
	 * @return 更新数量
	 */
	public int updateStudentById(Student student); 
	
	/**
	 * 根据条件更新学生信息
	 * @param student  学生信息
	 * @param studentExample  查询条件
	 * @return 更新数量
	 */
	public int updateStudent(Student student, StudentExample studentExample); 
	
	/**
	 * 根据ID删除学生信息
	 * @param id 学生ID
	 * @return 删除数量
	 */
	public int deleteStudentById(String id);
	
	/**
	 * 根据条件删除学生信息
	 * @param studentExample 查询条件
	 * @return 删除数量
	 */
	public int deleteStudent(StudentExample studentExample);
	
	/**
	 * 新增学生信息
	 * @param student 学生信息
	 * @return 新增数量
	 */
	public int insertStudent(Student student);
	
}


