package com.onekook.ddns.aliyun.domain.scheduled;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.onekook.ddns.aliyun.domain.service.UpdateDomainService;

/**
 * @author kook
 */
@Component
public class ScheduledList {
	private static final Logger logger = LoggerFactory.getLogger(ScheduledList.class);

	@Autowired
	private UpdateDomainService updateDomainService;

	@PostConstruct
	public void post() {
		updateDomain();
	}

	@Scheduled(cron = "0 0/5 * * * ?") // 每隔5分钟执行一次定时任务
	@Scheduled(cron = "0 0 4 * * ?") // 每天凌晨4点执行
	public void updateDomain() {
		logger.info("Starting update domain->" + new Date());
		try {
			updateDomainService.updateDomain(null);
			logger.info("Finish update domain[success]->" + new Date());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Finish update domain[failed]->" + new Date());
		}
	}

}
