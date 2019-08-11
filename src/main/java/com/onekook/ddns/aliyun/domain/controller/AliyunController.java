package com.onekook.ddns.aliyun.domain.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.onekook.ddns.aliyun.domain.service.UpdateDomainService;

/**
 * @author kook
 */
@RestController
public class AliyunController {
	private static final Logger logger = LoggerFactory.getLogger(AliyunController.class);

	@Autowired
	private UpdateDomainService updateDomainService;

	@GetMapping("/update-domain/{domains}")
	public String describeDomainRecords(@PathVariable List<String> domains) {
		logger.info("[Http restful]-update domain->" + new Date());
		return updateDomainService.updateDomain(domains);
	}

}
