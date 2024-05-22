package app;

import jakarta.persistence.Persistence;

public class test {
public static void main(String[] args) {
	Persistence.createEntityManagerFactory("music_jpa");
}
}
