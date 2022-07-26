package com.jjambbong.note.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@Table(name = "tb_member")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long memberId;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "name", nullable = false)
	private String name;

	@CreationTimestamp
	@Column(name = "created_datetime", nullable = false)
	private LocalDateTime createdDateTime;

	@Column(name = "last_login_ip")
	private String lastLoginIp;

	@Column(name = "role")
	private String role;
}
