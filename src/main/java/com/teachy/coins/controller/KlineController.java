package com.teachy.coins.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teachy.coins.model.BaseCoins;
import com.teachy.coins.model.Warning;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("coins")
public class KlineController extends BaseController {
	@ApiOperation(value = "get warning list")
	@GetMapping("getWarningList")
	public List<Warning> getWarningList() {
		return warningDAO.getWarningList();
	}

	@ApiOperation(value = "updateCoinsIsable")
	@GetMapping("updateCoinsIsable")
	public void updateCoinsIsable(@RequestParam String coinName, @RequestParam String website,
		@RequestParam Integer enable) {
		baseCoinsDAO.updateCoinsIsable(new BaseCoins(coinName, website, enable));
	}
}
