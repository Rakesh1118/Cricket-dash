package io.java.ipldashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("io.java.ipldashboard.model")
public class IpldashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpldashboardApplication.class, args);
	}

}
