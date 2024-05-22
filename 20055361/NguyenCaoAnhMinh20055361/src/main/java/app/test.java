package app;

import jakarta.persistence.Persistence;

public abstract class test {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("school_jpa");
	}

}
