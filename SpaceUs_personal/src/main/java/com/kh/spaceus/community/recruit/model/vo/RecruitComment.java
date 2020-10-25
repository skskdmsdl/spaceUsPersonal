package com.kh.spaceus.community.recruit.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecruitComment implements Serializable{
	
	private String no;
	private String nickName;
	private String email;
	private String recruitNo;
	private int secret;
	private String commentRef;
	private String content;
	private int level;
	private Date date;
	private String reporter;
	private String boardCommentNo;
}
