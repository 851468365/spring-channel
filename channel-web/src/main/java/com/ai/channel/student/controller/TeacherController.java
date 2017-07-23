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

import com.ai.channel.student.entity.Teacher;
import com.ai.channel.student.entity.TeacherExample;
import com.ai.channel.student.service.interfaces.ITeacherSV;
import com.ai.channel.util.exception.CommonException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private ITeacherSV teacherSV;
	
	private static Logger logger = LoggerFactory.getLogger(TeacherController.class);  
	
	@ResponseBody
	@RequestMapping(value="getTeacherById")
	public Map getTeacherById(String id, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		Map map = new HashMap();
		try {
			Teacher teacher = teacherSV.getTeacherById(id);
			map.put("teacher", teacher);
			map.put("result", "success");
			map.put("promptMsg", "查询成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "查询失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("查询教师信息失败。", e);
		}
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping(value="getTeachersByPage")
	public Map getTeachers(Teacher teacher, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
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
			TeacherExample teacherExample = new TeacherExample();
			/*teacherExample.createCriteria().andNameEqualTo("zhangfei").andCodeEqualTo(teacher.getCode());
			teacherExample.setDistinct(true);
			teacherExample.setOrderByClause("id desc");*/
			List<Teacher> teachers = teacherSV.getTeachers(teacherExample);
			
			/**
			 * 1、获取分页信息方式：
			 * System.out.println("符合条件的记录总数："+page.getTotal());
			 * System.out.println("每页记录数："+page.getPageSize());
			 * System.out.println("总页数："+page.getPages());
			 * 
			 * 2、如果希望获取更详细的分页信息可以使用PageInfo的方式，PageInfo中会包含更详细的分页相关信息：
			 * PageInfo<Student> pageInfo = new PageInfo<Student>(students);
			 */
			map.put("teachers", teachers);
			map.put("result", "success");
			map.put("promptMsg", "查询成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "查询失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("查询教师信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="updateTeacherById")
	public Map updateTeacherById(Teacher teacher, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		//teacher对象中封装所有需要update的属性信息。
		Map map = new HashMap();
		int count = 0;
		try {
			count = teacherSV.updateTeacherById(teacher);
			map.put("result", "success");
			map.put("promptMsg", "更新成功!");
			if (count != 1) {
				map.put("result", "failed");
				map.put("promptMsg", "更新教师信息失败!");
			}
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "更新教师信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("更新教师信息失败。", e);
		}
		return map;
	}
	

	@ResponseBody
	@RequestMapping(value="updateTeacher")
	public Map updateTeacher(Teacher teacher, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		//teacher对象中封装所有需要update的属性信息。
		Map map = new HashMap();
		int count = 0;
		try {
			/**
			 * 自行定制，Where条件！！！！！！！！！！
			 */
			TeacherExample teacherExample = new TeacherExample();
			/*
			 * teacherExample.createCriteria().andNameEqualTo("zhangfei");
			 */
			count = teacherSV.updateTeacher(teacher, teacherExample);
			map.put("result", "success");
			map.put("promptMsg", "更新成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "更新教师信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("更新教师信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteTeacherById")
	public Map deleteTeacherById(String id, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		Map map = new HashMap();
		int count = 0;
		try {
			count = teacherSV.deleteTeacherById(id);
			map.put("result", "success");
			map.put("promptMsg", "删除成功!");
			if (count != 1) {
				map.put("result", "failed");
				map.put("promptMsg", "删除教师信息失败!");
			}
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "删除教师信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("删除教师信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteTeacher")
	public Map deleteTeacher(Teacher teacher, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		Map map = new HashMap();
		int count = 0;
		try {
			/**
			 * 自行定制，Where条件！！！！！！！！！！
			 */
			TeacherExample teacherExample = new TeacherExample();
			/*
			 * teacherExample.createCriteria().andNameEqualTo("zhangfei");
			 */
			count = teacherSV.deleteTeacher(teacherExample);
			map.put("result", "success");
			map.put("promptMsg", "删除成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "删除教师信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("删除教师信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="insertTeacher")
	public Map insertTeacher(Teacher teacher, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		//teacher对象中封装所有需要insert的属性信息。
		Map map = new HashMap();
		int count = 0;
		try {
			count = teacherSV.insertTeacher(teacher);
			map.put("result", "success");
			map.put("promptMsg", "新增成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "新增教师信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("新增教师信息失败。", e);
		}
		return map;
	}
	

}
