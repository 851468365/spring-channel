package com.ai.channel.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.channel.student.entity.Course;
import com.ai.channel.student.entity.CourseExample;
import com.ai.channel.student.service.interfaces.ICourseSV;
import com.ai.channel.util.exception.CommonException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private ICourseSV courseSV;
	
	private static Logger logger = LoggerFactory.getLogger(CourseController.class);  
	
	@ResponseBody
	@RequestMapping(value="getCourseById")
	public Map getCourseById(String id, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		Map map = new HashMap();
		try {
			Course course = courseSV.getCourseById(id);
			map.put("course", course);
			map.put("result", "success");
			map.put("promptMsg", "查询成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "查询失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("查询课程信息失败。", e);
		}
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping(value="getCoursesByPage")
	public Map getCourses(Course course, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		Map map = new HashMap();
		try {
			/**
			 * 如下为两种分页处理方式（注意分页处理一定要在执行sql语句前进行设置！！）：
			 * 分页处理方式一：假设请求参数中包含分页参数pageNum和pageSize
			 * int pageNum = Integer.valueOf(request.getParameter("pageNum"));
			 * int pageSize = Integer.valueOf(request.getParameter("pageSize"));
			 * Page<Object> page = PageHelper.startPage(pageNum, pageSize);
			 */
			
	        /**
			 * 分页处理方式二：这种方式中请求参数名必须为pageNum,pageSize两个参数
			 * Page<Object> page = PageHelper.startPage(request);
			 */
			Page<Object> page = PageHelper.startPage(request);
			/**
			 * 自行定制，Where条件！！！！！！！！！！
			 */
			CourseExample courseExample = new CourseExample();
			/*courseExample.createCriteria().andNameEqualTo("zhangfei").andCodeEqualTo(course.getCode());
			courseExample.setDistinct(true);
			courseExample.setOrderByClause("id desc");*/
			List<Course> courses = courseSV.getCourses(courseExample);
			
			/**
			 * 1、获取分页信息方式：
			 * System.out.println("符合条件的记录总数："+page.getTotal());
			 * System.out.println("每页记录数："+page.getPageSize());
			 * System.out.println("总页数："+page.getPages());
			 * 
			 * 2、如果希望获取更详细的分页信息可以使用PageInfo的方式，PageInfo中会包含更详细的分页相关信息：
			 * PageInfo<Student> pageInfo = new PageInfo<Student>(students);
			 */
			map.put("courses", courses);
			map.put("result", "success");
			map.put("promptMsg", "查询成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "查询失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("查询课程信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="updateCourseById")
	public Map updateCourseById(Course course, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		//course对象中封装所有需要update的属性信息。
		Map map = new HashMap();
		int count = 0;
		try {
			count = courseSV.updateCourseById(course);
			map.put("result", "success");
			map.put("promptMsg", "更新成功!");
			if (count != 1) {
				map.put("result", "failed");
				map.put("promptMsg", "更新课程信息失败!");
			}
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "更新课程信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("更新课程信息失败。", e);
		}
		return map;
	}
	

	@ResponseBody
	@RequestMapping(value="updateCourse")
	public Map updateCourse(Course course, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		//course对象中封装所有需要update的属性信息。
		Map map = new HashMap();
		int count = 0;
		try {
			/**
			 * 自行定制，Where条件！！！！！！！！！！
			 */
			CourseExample courseExample = new CourseExample();
			/*
			 * courseExample.createCriteria().andNameEqualTo("zhangfei");
			 */
			count = courseSV.updateCourse(course, courseExample);
			map.put("result", "success");
			map.put("promptMsg", "更新成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "更新课程信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("更新课程信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteCourseById")
	public Map deleteCourseById(String id, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		Map map = new HashMap();
		int count = 0;
		try {
			count = courseSV.deleteCourseById(id);
			map.put("result", "success");
			map.put("promptMsg", "删除成功!");
			if (count != 1) {
				map.put("result", "failed");
				map.put("promptMsg", "删除课程信息失败!");
			}
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "删除课程信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("删除课程信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteCourse")
	public Map deleteCourse(Course course, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		Map map = new HashMap();
		int count = 0;
		try {
			/**
			 * 自行定制，Where条件！！！！！！！！！！
			 */
			CourseExample courseExample = new CourseExample();
			/*
			 * courseExample.createCriteria().andNameEqualTo("zhangfei");
			 */
			count = courseSV.deleteCourse(courseExample);
			map.put("result", "success");
			map.put("promptMsg", "删除成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "删除课程信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("删除课程信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="insertCourse")
	public Map insertCourse(Course course, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		//course对象中封装所有需要insert的属性信息。
		Map map = new HashMap();
		int count = 0;
		try {
			count = courseSV.insertCourse(course);
			map.put("result", "success");
			map.put("promptMsg", "新增成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "新增课程信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("新增课程信息失败。", e);
		}
		return map;
	}
	

}
