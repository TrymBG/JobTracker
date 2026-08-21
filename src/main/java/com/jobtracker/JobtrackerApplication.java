package com.jobtracker;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobtrackerApplication {

	public static void main(String[] args) {
		// Spring Boot 4.x has no built-in Flyway autoconfiguration yet, so migrations
		// are run manually here, before the Spring context (and Hibernate's schema
		// validation) starts up.
		String dbHost = System.getenv().getOrDefault("DB_HOST", "localhost");
		String dbName = System.getenv().getOrDefault("POSTGRES_DB", "jobtracker");
		String dbUser = System.getenv().getOrDefault("POSTGRES_USER", "jobtracker");
		String dbPassword = System.getenv().getOrDefault("POSTGRES_PASSWORD", "jobtracker_dev_password");

		Flyway.configure()
				.dataSource("jdbc:postgresql://" + dbHost + ":5432/" + dbName, dbUser, dbPassword)
				.load()
				.migrate();

		SpringApplication.run(JobtrackerApplication.class, args);
	}

}
