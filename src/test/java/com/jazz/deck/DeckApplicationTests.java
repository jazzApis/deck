package com.jazz.deck;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jazz.deck.exception.DeckException;
import com.jazz.deck.resorces.PrinterController;
import com.jazz.deck.resorces.TaskController;

@SpringBootTest
class DeckApplicationTests {

	@Autowired
	private PrinterController printerController;
	
	@Autowired
	private TaskController taskController;
	
	@Test                                               
	@DisplayName("Check printer selection")   	
	public void printerSelectTest() {
		printerController.setSelected("PDF");
		assertThat(printerController.getSelected()).isEqualTo(printerController.get("PDF")); 
	}

	@Test                                               
	@DisplayName("Check create task")   	
	public void taskAddToQueueTest() throws DeckException {
		taskController.add("Test #1", "Bla Bla Bla");
		assertThat(taskController.getFirst()).isNotNull();
	}

}
