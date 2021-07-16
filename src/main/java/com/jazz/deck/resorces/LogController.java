package com.jazz.deck.resorces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jazz.deck.repository.LogEntity;
import com.jazz.deck.repository.LogRepository;

@Controller
public class LogController {
	
	@Autowired
	LogRepository repository;
	
	public List<LogEntity> get() {
		return repository.get();
	}

	public LogEntity get(Integer id) {
		return repository.get(id);
	}

	public int set(String code, String text) {
		return repository.set(code, text);
	}

}
