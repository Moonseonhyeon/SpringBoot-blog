package com.cos.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//웬만하면 콤포지션 하지 말고!!

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDetailRespDto {
	private int id;
	private String title;
	private String content;
	private String username;	
}
