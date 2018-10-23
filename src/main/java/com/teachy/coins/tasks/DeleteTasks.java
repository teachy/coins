package com.teachy.coins.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.teachy.coins.enumers.TabbleName;

@Component
public class DeleteTasks extends BaseTask {

	@Scheduled(cron = "56 56 23 * * ?")
	public void deleteKlineByDays() {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("tableName", TabbleName.M1.getValue());
		map1.put("days", 15);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("tableName", TabbleName.M5.getValue());
		map2.put("days", 75);
		Map<String, Object> map3 = new HashMap<>();
		map3.put("tableName", TabbleName.M10.getValue());
		map3.put("days", 150);
		Map<String, Object> map4 = new HashMap<>();
		map4.put("tableName", TabbleName.M30.getValue());
		map4.put("days", 450);
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.stream().forEach(e -> klineDAO.delete(e));
	}
}
