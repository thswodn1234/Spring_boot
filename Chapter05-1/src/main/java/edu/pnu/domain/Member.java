package edu.pnu.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Member {
	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	private String password;
	private String name;
	private String role;

	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<Board> boardList = new ArrayList<Board>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Member(String id, String password, String name, String role) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}

	public Member() {
		super();
	}

}
