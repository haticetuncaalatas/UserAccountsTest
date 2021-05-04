package UserAccounts;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Table(name = "user_accounts")
class User {

	@Column(name = "id")
	@NotNull
	@NotEmpty
	@Id
	private Long id;

	@Column(name = "name")
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 150)
	private String name;

	@Column(name = "phone")
	@NotNull
	@NotEmpty
	@Size(min = 9, max = 12)
	private Long phone;

	@Column(name = "email")
	@NotNull
	@NotEmpty
	@Size(max = 200)
	private String email;

	@Column(name = "address")
	@Size(max = 200)
	private String address;

	@Column(name = "country")
	@NotNull
	@NotEmpty
	@Size(max = 56)
	private String country;

	@Column(name = "department")
	@NotNull
	@NotEmpty
	@Size(max = 50)
	private String department;

	User() {
	}

	User(Long id, String name, Long phone, String email, String address, String country, String department) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.country = country;
		this.department = department;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public Long getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Long phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;
		User User = (User) o;
		return Objects.equals(this.id, User.id) && Objects.equals(this.name, User.name)
				&& Objects.equals(this.phone, User.phone);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.phone);
	}

	@Override
	public String toString() {
		return "User{" + "id=" + this.id + ", name='" + this.name + '\'' + ", phone='" + this.phone + '\'' + '}';
	}
}
