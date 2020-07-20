package com.cos.blog.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
	private int id;
	private String title;
	private String context;
	private int userId;
	private Timestamp createDate;
}
