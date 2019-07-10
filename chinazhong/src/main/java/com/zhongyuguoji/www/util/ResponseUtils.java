package com.zhongyuguoji.www.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class ResponseUtils {
	/**
	 * 将响应的json串写入响应流 适用obj含有注解@jsonFilter,但其属性不带有该注解的场景
	 * 
	 */
	public final static void responseAsJson(String code, String desc, Object obj, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			StringBuffer temp = new StringBuffer();
			temp.append("{");
			temp.append("\"").append(JSONKeys.CODE.getValue()).append("\":").append("\"").append(code).append("\",");
			temp.append("\"").append(JSONKeys.DESC.getValue()).append("\":").append("\"").append(desc).append("\"");
			temp.append(",\"").append(JSONKeys.DATA.getValue()).append("\":").append(JSON.toJSON(obj));
			temp.append("}");

			// response.reset();
			PrintWriter writer = response.getWriter();
			writer.write(temp.toString());
			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			obj = null;
		}
	}

	/**
	 * 将响应的json串写入响应流
	 */
	public final static void responseAsJson(String code, String desc, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			StringBuffer temp = new StringBuffer();
			temp.append("{");
			temp.append("\"").append(JSONKeys.CODE.getValue()).append("\":").append("\"").append(code).append("\",");
			temp.append("\"").append(JSONKeys.DESC.getValue()).append("\":").append("\"").append(desc).append("\"");
			temp.append("}");

			PrintWriter writer = response.getWriter();
			writer.write(temp.toString());
			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public final static void responseAsJson(Exception e, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/json; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");

			// response.reset();
			PrintWriter writer = response.getWriter();
			writer.write(JSON.toJSONString(e.getMessage()));
			writer.flush();
			writer.close();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			e = null;
		}
	}

	public final static void responseAsJson(Object obj, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");

			// response.reset();
			PrintWriter writer = response.getWriter();
			writer.write(JSON.toJSONString(obj));
			writer.flush();
			writer.close();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			obj = null;
		}
	}

	public final static void responseAsJsonP(String code, String desc, String callback, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			StringBuffer temp = new StringBuffer();
			temp.append("{");
			temp.append("\"").append(JSONKeys.CODE.getValue()).append("\":").append("\"").append(code).append("\",");
			temp.append("\"").append(JSONKeys.DESC.getValue()).append("\":").append("\"").append(desc).append("\"");
			temp.append("}");
			// response.reset();
			PrintWriter writer = response.getWriter();
			writer.write(callback + "(" + temp + ")");
			writer.flush();
			writer.close();

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

}
