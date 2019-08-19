package com.zhongyuguoji.www.controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.zhongyuguoji.www.common.constans.Constants;
import com.zhongyuguoji.www.entity.UserEntity;
import com.zhongyuguoji.www.util.CodeUtil;
import com.zhongyuguoji.www.util.Result;

@RequestMapping("/")
@RestController
public class LoginController {
	@PostMapping("login")
	public Result getLogin(UserEntity userEntity, HttpServletRequest request) {
		Result result = new Result(Constants.Success.COMMON_CODE,
				Constants.Success.DESC.get(Constants.Success.COMMON_CODE));
		String sessionCode = request.getSession().getAttribute("code").toString();
		if (!StringUtils.isEmpty(sessionCode) && !sessionCode.equalsIgnoreCase(userEntity.getValidateCode())) {
			result.setCODE(Constants.Failure.IMAGE_CODE);
			result.setDESC(Constants.Failure.DESC.get(Constants.Failure.IMAGE_CODE));
		}
		return result;
	}

	@GetMapping("checkImage")
	public void getcheckImage(String captchaType, HttpServletResponse response, HttpServletRequest request) {
		// 调用工具类生成的验证码和验证码图片
		Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();

		// 将四位数字的验证码保存到Session中。
		HttpSession session = request.getSession();
		session.setAttribute("code", codeMap.get("code").toString());

		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -1);

		response.setContentType("image/jpeg");

		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos;
		try {
			sos = response.getOutputStream();
			ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
			sos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
