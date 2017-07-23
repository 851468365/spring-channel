package com.ai.channel.student.service.interfaces;

import java.util.List;
import com.ai.channel.student.entity.Teacher;
import com.ai.channel.student.entity.TeacherExample;

/**
 * 	教师管理
 */
public interface ITeacherSV {
	/**
	 * 根据ID查询教师信息
	 * @param id 教师ID
	 * @return 教师实体
	 */
	public Teacher getTeacherById(String id);

	/**
	 * 查询教师信息
	 * @param teacherExample 查询条件
	 * @return 教师列表
	 */
	public List<Teacher> getTeachers(TeacherExample teacherExample);

	/**
	 * 根据ID更新教师信息
	 * @param teacher 教师信息
	 * @return 更新数量
	 */
	public int updateTeacherById(Teacher teacher); 
	
	/**
	 * 根据条件更新教师信息
	 * @param teacher  教师信息
	 * @param teacherExample  查询条件
	 * @return 更新数量
	 */
	public int updateTeacher(Teacher teacher, TeacherExample teacherExample); 
	
	/**
	 * 根据ID删除教师信息
	 * @param id 教师ID
	 * @return 删除数量
	 */
	public int deleteTeacherById(String id);
	
	/**
	 * 根据条件删除教师信息
	 * @param teacherExample 查询条件
	 * @return 删除数量
	 */
	public int deleteTeacher(TeacherExample teacherExample);
	
	/**
	 * 新增教师信息
	 * @param teacher 教师信息
	 * @return 新增数量
	 */
	public int insertTeacher(Teacher teacher);
	
}


