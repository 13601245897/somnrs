package com.zhongyuguoji.www.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongyuguoji.www.common.constans.Constants;
import com.zhongyuguoji.www.entity.MemberSetting;
import com.zhongyuguoji.www.service.MemberSettingService;
import com.zhongyuguoji.www.util.ResponseUtils;

/**
 * MemberSetting List
 * 
 * @author moese
 *
 */

@RestController
@RequestMapping("/MemberSetting")
public class MemberSettingController {
	@Resource
	private MemberSettingService mss;

	/**
	 * getAllMemberSetting
	 */
	@GetMapping("/getAll")
	public void getAll(HttpServletResponse response) {
		List<MemberSetting> list = mss.getAll();
		ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
				Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), list, response);
	}

	/**
	 * getMemberSettingById
	 * 
	 * @param id
	 * @param response
	 */
	@GetMapping("/getMemberSettingById")
	public void getMemberSettingById(Integer id, HttpServletResponse response) {
		if (id != null) {
			MemberSetting memberSettingById = mss.getMemberSettingById(id);
			if (memberSettingById != null) {
				ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
						Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), memberSettingById, response);
			}
		}
	}

	@PostMapping("/saveMemberSetting")
	public void saveMemberSetting(MemberSetting entity, HttpServletResponse response) {
		if (entity != null) {
			mss.insert(entity);
			ResponseUtils.responseAsJson(Constants.Success.COMMON_CODE,
					Constants.Success.SUCCESS.get(Constants.Success.COMMON_CODE), response);
		}
	}
}
