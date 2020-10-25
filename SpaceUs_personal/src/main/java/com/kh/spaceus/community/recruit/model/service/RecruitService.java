package com.kh.spaceus.community.recruit.model.service;

import java.util.List;
import java.util.Map;

import com.kh.spaceus.community.recruit.model.vo.Recruit;
import com.kh.spaceus.community.recruit.model.vo.RecruitComment;
import com.kh.spaceus.community.recruit.model.vo.ReportComment;
import com.kh.spaceus.community.recruit.model.vo.ReportRecruit;

public interface RecruitService {

	int insertRecruit(Recruit recruit);

	List<Recruit> selectRecruitList(int limit, int offset);

	int selectRecruitTotalContents();

	Recruit selectOneRecruit(String no);

	int updateRecruit(Recruit recruit);

	int deleteRecruit(String no);

	ReportRecruit selectOneReport(String no, String memberEmail);

	int insertReport(ReportRecruit report);

	int updateReport(String no);

	int increaseRecruitReadCnt(String no);

	int insertComment(RecruitComment recruitComment);

	List<RecruitComment> selectCommentList(RecruitComment comment);

	int updateComment(RecruitComment comment);

	int deleteComment(String commentNo);

	int selectCommentTotalContents(String no);

	int insertReportComment(ReportComment reportComment);

	List<Recruit> searchRecruit(String keyWord, int limit, int offset);

	int selectRecruitTotalSearch(String keyWord);

	List<Recruit> recruitHeaderSearch(String header, int limit, int offset);

	int selectRecruitTotalHeader(String header);





}