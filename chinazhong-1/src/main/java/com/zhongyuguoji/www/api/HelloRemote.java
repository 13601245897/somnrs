package com.zhongyuguoji.www.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "client")
public interface HelloRemote {
	@GetMapping("/eclient")
	public String hello();
}
