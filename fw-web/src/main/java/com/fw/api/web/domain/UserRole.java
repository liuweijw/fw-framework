package com.fw.api.web.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.fw.api.security.domain.IUserRole;
import com.fw.api.security.domain.Role;

/**
 * UserRole
 */
@Entity
@Table(name = UserRole.TABLE_NAME)
public class UserRole implements IUserRole {

	public static final String TABLE_NAME = "t_fw_user_role";

	@Embeddable
	public static class Id implements Serializable {

		private static final long serialVersionUID = 5795681605525647359L;

		@Column(name = "app_user_id")
		protected Long userId;

		@Enumerated(EnumType.STRING)
		@Column(name = "role")
		protected Role role;

		public Id() {
		}

		public Id(Long userId, Role role) {
			this.userId = userId;
			this.role = role;
		}
	}

	@EmbeddedId
	Id id = new Id();

	@Enumerated(EnumType.STRING)
	@Column(name = "role", insertable = false, updatable = false)
	protected Role role;

	@Override
	public Role getRole() {
		return role;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
