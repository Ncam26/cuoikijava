package entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Instructor")
public class Instructor extends Person implements Serializable {
	private static final long serialVersionUID = 8065808962349626612L;
	private LocalDate hireDate;

	public Instructor() {
	}
	
	public Instructor(String firstName, String lastName, LocalDate hireDate) {
		super(firstName, lastName);
		this.hireDate = hireDate;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return String.format("Instructor [hireDate=%s, toString()=%s]", hireDate, super.toString());

	}

}