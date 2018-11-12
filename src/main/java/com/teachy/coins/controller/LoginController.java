package com.teachy.coins.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teachy.coins.dd.DDTasks;
import com.teachy.coins.dd.SFTest;

@RestController
@RequestMapping("login")
public class LoginController {
	@GetMapping("/GetVerificationCode")
	public void GetVerificationCode(HttpServletResponse response) throws IOException {
		ServletOutputStream out = response.getOutputStream();
		InputStream in = DDTasks.GetVerificationCode();
		ImageIO.write(ImageIO.read(in), "png", out);
		out.close();
	}

	@GetMapping("/GetIdAndGlod")
	@ResponseBody
	public String GetIdAndGlod() throws IOException {
		return DDTasks.getIdAndGold();
	}

	@PostMapping("/doLogin")
	public void doLogin(@RequestParam String name, @RequestParam String password,
		@RequestParam String code, HttpServletResponse response) throws IOException {
		DDTasks.login(name, password, code);
		response.sendRedirect("/login/base.html");
	}

	@GetMapping("/GetTest")
	@ResponseBody
	public String GetTest() throws IOException {
		return SFTest.js1 + ":" + SFTest.fk1 + ":" + SFTest.js2 + ":" + SFTest.fk2 + ":" + SFTest.js3 + ":"
			+ SFTest.fk3 + ":" + DDTasks.getIdAndGold();
	}
}
