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
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			StringBuffer temp = new StringBuffer();
			temp.append("{");
			temp.append("\"").append(JSONKeys.CODE.getValue()).append("\":").append("\"").append(code).append("\",");
			temp.append("\"").append(JSONKeys.DESC.getValue()).append("\":").append("\"").append(desc).append("\"");
			temp.append(",\"").append(JSONKeys.DATA.getValue()).append("\":").append(JSON.toJSON(obj));
			temp.append("}");

			PrintWriter writer = response.getWriter();
			writer.write(temp.toString());
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			obj = null;
		}
	}

	/**
	 * 将响应的json串写入响应流
	 */
	public static final void responseAsJson(String code, String desc, HttpServletResponse response) {
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
			e.printStackTrace();
		}
	}
}
