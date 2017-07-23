package com.ai.channel.student.service.interfaces;

import java.util.List;
import com.ai.channel.student.entity.Course;
import com.ai.channel.student.entity.CourseExample;

/**
 * 	课程管理
 */
public interface ICourseSV {
	/**
	 * 根据ID查询课程信息
	 * @param id 课程ID
	 * @return 课程实体
	 */
	public Course getCourseById(String id);

	/**
	 * 查询课程信息
	 * @param courseExample 查询条件
	 * @return 课程列表
	 */
	public List<Course> getCourses(CourseExample courseExample);

	/**
	 * 根据ID更新课程信息
	 * @param course 课程信息
	 * @return 更新数量
	 */
	public int updateCourseById(Course course); 
	
	/**
	 * 根据条件更新课程信息
	 * @param course  课程信息
	 * @param courseExample  查询条件
	 * @return 更新数量
	 */
	public int updateCourse(Course course, CourseExample courseExample); 
	
	/**
	 * 根据ID删除课程信息
	 * @param id 课程ID
	 * @return 删除数量
	 */
	public int deleteCourseById(String id);
	
	/**
	 * 根据条件删除课程信息
	 * @param courseExample 查询条件
	 * @return 删除数量
	 */
	public int deleteCourse(CourseExample courseExample);
	
	/**
	 * 新增课程信息
	 * @param course 课程信息
	 * @return 新增数量
	 */
	public int insertCourse(Course course);
	
}


