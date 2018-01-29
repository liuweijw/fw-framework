package com.github.liuweijw.api.web.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.liuweijw.api.security.domain.IUser;
import com.github.liuweijw.api.security.domain.IUserRole;
import com.github.liuweijw.api.security.domain.Role;

@Entity
@Table(name = User.TABLE_NAME)
public class User implements IUser {

	public static final String TABLE_NAME = "t_fw_user";

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@OneToMany
	@JoinColumn(name = "app_user_id", referencedColumnName = "id")
	private List<UserRole> roles;

	public User() {
	}

	public User(Long id, String username, String password, List<UserRole> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public List<IUserRole> getUserRoles() {
		if (null == roles)
			return null;
		List<IUserRole> list = new ArrayList<IUserRole>();
		for (UserRole userRole : roles) {
			list.add(new IUserRole() {
				@Override
				public Role getRole() {
					return userRole.getRole();
				}
			});
		}
		return list;
	}
}
