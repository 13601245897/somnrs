package com.zhongyuguoji.www.results;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public final class ResponseUtils {
	private static final Logger logs = LoggerFactory.getLogger(ResponseUtils.class);

	private ResponseUtils() {

	}

	public static void responseAsJson(String code, String desc, Object obj, HttpServletResponse response) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			StringBuffer temp = new StringBuffer();
			temp.append("{");
			temp.append("\"").append(JSONKeys.CODE.getValue()).append("\":").append("\"").append(code).append("\",");
			temp.append("\"").append(JSONKeys.DESC.getValue()).append("\":").append("\"").append(desc).append("\"");
			temp.append(",\"").append(JSONKeys.DATA.getValue()).append("\":")
					.append(JSON.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect));
			temp.append("}");
			PrintWriter writer = response.getWriter();
			writer.write(temp.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logs.info("io异常" + e);
		} finally {
			obj = null;
		}
	}

	public static void responseAsJson(String code, String desc, HttpServletResponse response) {
		try {
			response.setContentType("text/json; charset=UTF-8");
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
			logs.error("io异常" + e);
		}
	}

	public static void responseAsJson(Object obj, HttpServletResponse response) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			writer.write(JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue));
			writer.flush();
			writer.close();
		} catch (IOException ex) {
			logs.error("io异常" + ex);
		} finally {
			obj = null;
		}
	}

	public static void responseAsJson1(String code, String desc, Object obj, HttpServletResponse response) {
		try {
			response.setContentType("text/json; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			StringBuffer temp = new StringBuffer();
			temp.append("{");
			temp.append("\"").append(JSONKeys.CODE.getValue()).append("\":").append("\"").append(code).append("\",");
			temp.append("\"").append(JSONKeys.DESC.getValue()).append("\":").append("\"").append(desc).append("\"");
			temp.append(",\"").append(JSONKeys.DATA.getValue()).append("\":").append(JSON.toJSONString(obj));
			temp.append("}");
			PrintWriter writer = response.getWriter();
			writer.write(temp.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logs.error("io异常" + e);
		} finally {
			obj = null;
		}
	}
}