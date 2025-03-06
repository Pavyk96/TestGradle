package com.pavyk96.TestGradle;

import com.pavyk96.TestGradle.controller.TalkConstructor;
import com.pavyk96.TestGradle.controller.TalkFieldInjection;
import com.pavyk96.TestGradle.controller.TalkSetterInjection;
import com.pavyk96.TestGradle.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestGradleApplication implements CommandLineRunner {
	private final TalkConstructor talkConstructor;
	private final TalkSetterInjection talkSetterInjection;
	private final TalkFieldInjection talkFieldInjection;

	@Autowired
	public TestGradleApplication(TalkConstructor talkConstructor,
								 TalkSetterInjection talkSetterInjection,
								 TalkFieldInjection talkFieldInjection) {
		this.talkConstructor = talkConstructor;
		this.talkSetterInjection = talkSetterInjection;
		this.talkFieldInjection = talkFieldInjection;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestGradleApplication.class, args);
	}

	@Override
	public void run(String... args) {
		User user = new User();
		user.setName("Иван");
		user.setSurname("Петров");

		System.out.println("Constructor Injection: " + talkConstructor.newTalk(user));
		System.out.println("Setter Injection: " + talkSetterInjection.sayGoodbye(user));
		System.out.println("Field Injection: " + talkFieldInjection.sayHello(user));
	}
}

