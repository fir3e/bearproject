package com.fastfeast.fastfeast.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	int id;
	String name;
	String username;
	String password;
	String email;
	String birthDate;
	String role;

	public User() {
	}

	public User(int id, String name, String username, String password, String email, String birthDate, String role) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
		this.role = role;
	}

	public User(String name, String username, String password, String email, String birthDate, String role) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birtDateIntToString(birthDate);
	}

	public String birtDateIntToString(int birthDate) {
		String birthString = String.valueOf(birthDate);
		birthString = birthString.substring(0, 4)
				+ "."
				+ birthString.substring(4, 6)
				+ "."
				+ birthString.substring(6, birthString.length())
				+ ".";

		return birthString;
	}

	public int birtDateStringToInt(String birthDate) {
		String birthString = birthDate.substring(0, 4)
				+ birthDate.substring(5, 7)
				+ birthDate.substring(8, 10);
		Integer birtDateInt = Integer.parseInt(birthString);

		return birtDateInt;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", email="
				+ email + ", birthDate=" + birthDate + ", role=" + role
				+ "]";
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(this.role));
		return authorities;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

}