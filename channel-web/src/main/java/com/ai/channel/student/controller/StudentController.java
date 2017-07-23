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

import com.ai.channel.student.entity.Student;
import com.ai.channel.student.entity.StudentExample;
import com.ai.channel.student.service.interfaces.IStudentSV;
import com.ai.channel.util.exception.CommonException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private IStudentSV studentSV;
	
	private static Logger logger = LoggerFactory.getLogger(StudentController.class);  
	
	@ResponseBody
	@RequestMapping(value="getStudentById")
	public Map getStudentById(String id, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		Map map = new HashMap();
		try {
			Student student = studentSV.getStudentById(id);
			map.put("student", student);
			map.put("result", "success");
			map.put("promptMsg", "查询成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "查询失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("查询学生信息失败。", e);
		}
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping(value="getStudentsByPage")
	public Map getStudents(Student student, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		Map map = new HashMap();
		try {
			Page<Object> page = PageHelper.startPage(request);
			/**
			 * 自行定制，Where条件！！！！！！！！！！
			 */
			StudentExample studentExample = new StudentExample();
			/*studentExample.createCriteria().andNameEqualTo("zhangfei").andCodeEqualTo(student.getCode());
			studentExample.setDistinct(true);
			studentExample.setOrderByClause("id desc");*/
			
			PageHelper.startPage(request);
			List<Student> students = studentSV.getStudents(studentExample);
			
			map.put("students", students);
			map.put("result", "success");
			map.put("promptMsg", "查询成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "查询失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("查询学生信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="updateStudentById")
	public Map updateStudentById(Student student, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		//student对象中封装所有需要update的属性信息。
		Map map = new HashMap();
		int count = 0;
		try {
			count = studentSV.updateStudentById(student);
			map.put("result", "success");
			map.put("promptMsg", "更新成功!");
			if (count != 1) {
				map.put("result", "failed");
				map.put("promptMsg", "更新学生信息失败!");
			}
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "更新学生信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("更新学生信息失败。", e);
		}
		return map;
	}
	

	@ResponseBody
	@RequestMapping(value="updateStudent")
	public Map updateStudent(Student student, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		//student对象中封装所有需要update的属性信息。
		Map map = new HashMap();
		int count = 0;
		try {
			/**
			 * 自行定制，Where条件！！！！！！！！！！
			 */
			StudentExample studentExample = new StudentExample();
			/*
			 * studentExample.createCriteria().andNameEqualTo("zhangfei");
			 */
			count = studentSV.updateStudent(student, studentExample);
			map.put("result", "success");
			map.put("promptMsg", "更新成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "更新学生信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("更新学生信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteStudentById")
	public Map deleteStudentById(String id, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		Map map = new HashMap();
		int count = 0;
		try {
			count = studentSV.deleteStudentById(id);
			map.put("result", "success");
			map.put("promptMsg", "删除成功!");
			if (count != 1) {
				map.put("result", "failed");
				map.put("promptMsg", "删除学生信息失败!");
			}
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "删除学生信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("删除学生信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteStudent")
	public Map deleteStudent(Student student, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		Map map = new HashMap();
		int count = 0;
		try {
			/**
			 * 自行定制，Where条件！！！！！！！！！！
			 */
			StudentExample studentExample = new StudentExample();
			/*
			 * studentExample.createCriteria().andNameEqualTo("zhangfei");
			 */
			count = studentSV.deleteStudent(studentExample);
			map.put("result", "success");
			map.put("promptMsg", "删除成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "删除学生信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("删除学生信息失败。", e);
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="insertStudent")
	public Map insertStudent(Student student, HttpServletRequest request, HttpServletResponse response) throws IOException, CommonException{
		//student对象中封装所有需要insert的属性信息。
		Map map = new HashMap();
		int count = 0;
		try {
			count = studentSV.insertStudent(student);
			map.put("result", "success");
			map.put("promptMsg", "新增成功!");
		} catch (Exception e) {
			map.put("result", "failed");
			map.put("promptMsg", "新增学生信息失败!");
			map.put("errorMsg", e.getMessage());
			logger.error("新增学生信息失败。", e);
		}
		return map;
	}
	

}
