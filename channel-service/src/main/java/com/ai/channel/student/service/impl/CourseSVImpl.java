package com.ai.channel.student.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ai.channel.student.dao.CourseMapper;
import com.ai.channel.student.entity.Course;
import com.ai.channel.student.entity.CourseExample;
import com.ai.channel.student.service.interfaces.ICourseSV;
import com.github.pagehelper.PageHelper;

@Service
public class CourseSVImpl implements ICourseSV{
	@Resource
	private CourseMapper courseMapper;

	@Override
	public Course getCourseById(String id) {
		return courseMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Course> getCourses(CourseExample courseExample) {
		return courseMapper.selectByExample(courseExample);
	}

	@Override
	public int updateCourseById(Course course) {
		return courseMapper.updateByPrimaryKeySelective(course);
	}
	
	@Override
	public int updateCourse(Course course, CourseExample courseExample) {
		return courseMapper.updateByExampleSelective(course, courseExample);
	}

	@Override
	public int insertCourse(Course course) {
		return courseMapper.insertSelective(course);
	}

	@Override
	public int deleteCourseById(String id) {
		return courseMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public int deleteCourse(CourseExample courseExample) {
		return courseMapper.deleteByExample(courseExample);
	}
}
