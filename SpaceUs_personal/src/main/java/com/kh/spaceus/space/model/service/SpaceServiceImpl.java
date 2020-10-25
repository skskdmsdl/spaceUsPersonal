package com.kh.spaceus.space.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spaceus.qna.model.vo.Qna;
import com.kh.spaceus.space.model.dao.SpaceDAO;
import com.kh.spaceus.space.model.vo.Attachment;
import com.kh.spaceus.space.model.vo.Category;
import com.kh.spaceus.space.model.vo.Option;
import com.kh.spaceus.space.model.vo.OptionList;
import com.kh.spaceus.space.model.vo.Review;
import com.kh.spaceus.space.model.vo.ReviewAttachment;
import com.kh.spaceus.space.model.vo.Space;
import com.kh.spaceus.space.model.vo.SpaceList;
import com.kh.spaceus.space.model.vo.SpaceTag;
import com.kh.spaceus.space.model.vo.Star;
import com.kh.spaceus.space.model.vo.Tag;
import com.kh.spaceus.space.model.vo.Wish;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SpaceServiceImpl implements SpaceService{
	
	@Autowired
	private SpaceDAO spaceDAO;

	@Override
	public Tag selectOneTag(String hashTag) {
		return spaceDAO.selectOneTag(hashTag);
	}
	
	@Override
	public int insertHashTag(String hashTag) {
		return spaceDAO.insertHashTag(hashTag);
	}

	@Override
	public Space selectOneSpace(String spaceNo) {
		return spaceDAO.selectOneSpace(spaceNo);
	}
	
	@Override
	public Space selectOneSpace(long businessNo) {
		return spaceDAO.selectOneSpace(businessNo);
	}

	@Override
	public List<Tag> selectListSpaceTag(String spaceNo) {
		return spaceDAO.selectListSpaceTag(spaceNo);
	}

	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int insertReview(Review review) {
		int result = 0;
		
		//1. review테이블에 insert
		result = spaceDAO.insertReview(review);
		
		//2. attachment테이블에 insert
		//첨부파일수만큼 행 추가
		List<ReviewAttachment> attachList = review.getReviewAtt();
		
		//첨부파일이 있는 경우
		if(attachList != null) {
			for(ReviewAttachment attach : attachList) {
				attach.setReviewNo(review.getReviewNo());
				log.debug("attach = {}", attach);
				result = spaceDAO.insertReviewAttahment(attach);
			}
		}
		
		return result;
	}

	@Override
	public List<Review> selectListReview(String spaceNo, int limit, int offset) {
		return spaceDAO.selectListReview(spaceNo, limit, offset);
	}

	@Override
	public int selectReviewTotalContents(String spaceNo) {
		return  spaceDAO.selectReviewTotalContents(spaceNo);
	}

	@Override
	public Star selectStar(String spaceNo) {
		return spaceDAO.selectStar(spaceNo);
	}



	@Override
	public Space selectOneSpaceNo(String email) {
		return spaceDAO.selectOneSpaceNo(email);
	}

	@Override
	public int updateReviewComment(Review review) {
		return spaceDAO.updateReviewComment(review);
	}

	@Override
	public List<Review> selectReviewComment(String spaceNo, int limit, int offset) {
		return spaceDAO.selectReviewComment(spaceNo, limit, offset);
	}
	
	@Override
	public List<Qna> selectQuestionList(String spaceNo, int limit, int offset) {
		return spaceDAO.selectQuestionList(spaceNo, limit, offset);
	}

	@Override
	public int selectQuestionTotalContents(String spaceNo) {
		return  spaceDAO.selectQuestionTotalContents(spaceNo);
	}

	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int insertSpace(Space space) {
		int result = 0;
		
		result = spaceDAO.insertSpace(space);
		
		List<Attachment> attachList = space.getAttachList();
		
		//첨부파일이 있는 경우
		if(attachList != null) {
			for(Attachment attach : attachList) {
				attach.setSpaceNo(space.getSpaceNo());
				
				log.debug("attach = {}", attach);
				result = spaceDAO.insertAttachment(attach);
				
			}
		}
		
		return result;
	}

	@Override
	public int insertOption(Option option) {
		return spaceDAO.insertOption(option);
	}

	@Override
	public int insertSpaceTag(SpaceTag spaceTag) {
		return spaceDAO.insertSpaceTag(spaceTag);
	}

	@Override
	public int insertWish(Wish wish) {
		return spaceDAO.insertWish(wish);
	}

	@Override
	public List<SpaceList> selectSameCategory(Space space) {
		return spaceDAO.selectSameCategory(space);
	}

	@Override
	public int selectLikeCnt(String spaceNo) {
		return spaceDAO.selectLikeCnt(spaceNo);
	}

	@Override
	public int deleteWish(Wish wish) {
		return spaceDAO.deleteWish(wish);
	}

	@Override
	public String selectCateName(String spaceNo) {
		return spaceDAO.selectCateName(spaceNo);
	}

	@Override
	public List<Space> selectReviewList(String memberEmail) {
		return spaceDAO.selectReviewList(memberEmail);
	}

	@Override
	public int updateReview(Review review) {
		return spaceDAO.updateReview(review);
	}

	@Override
	public List<Review> selectStarAvg(String spaceNo) {
		return spaceDAO.selectStarAvg(spaceNo);
	}

	@Override
	public void updateStarAvg(Space space) {
		spaceDAO.updateStarAvg(space);
	}

	@Override
	public List<Space> selectReviewPossible(String email) {
		return spaceDAO.selectReviewPossible(email);
	}

	@Override
	public List<Space> selectReviewComplete(String email) {
		return spaceDAO.selectReviewComplete(email);
	}

	@Override
	public List<Space> selectAll() {
		return spaceDAO.selectAll();
	}

	@Override
	public List<OptionList> selectOptionList(String spaceNo) {
		return spaceDAO.selectOptionList(spaceNo);
	}
	
	@Override
	public List<Review> selectRecentReviewList() {
		return spaceDAO.selectRecentReviewList();
	}
	
	@Override
	public List<SpaceList> selectPopularSpaces() {
		return spaceDAO.selectPopularSpaces();
	}
	

	@Override
	public List<Object> selectAutoList(String value) {
		return spaceDAO.selectAutoList(value);
	}

	@Override
	public List<Category> selectCategoryList() {
		return spaceDAO.selectCategoryList();
	}

	@Override
	public List<OptionList> selectOptionList1() {
		return spaceDAO.selectOptionList1();
	}

	@Override
	public List<String> selectSpaceNoList(String keyword, String sort) {
		Map<String,String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("sort", sort);
		return spaceDAO.selectSpaceNoList(map);
	}
	
	

	@Override
	public Wish selectOneWish(Wish wish) {
		return spaceDAO.selectOneWish(wish);
	}

	@Override
	public List<SpaceList> selectSearchSpaceList(String searchSpace) {
		return spaceDAO.selectSearchSpaceList(searchSpace);
	}

	@Override
	public List<String> selectSearchDetailSpaceNo(Map<String, String> map) {
		return spaceDAO.selectSearchDetailSpaceNo(map);
	}
	
	@Override
	public Attachment selectPopularImage(String spaceNo) {
		return spaceDAO.selectPopularImage(spaceNo);
	}

	@Override
	public int increaseSpaceReadCnt(String spaceNo) {
		return spaceDAO.increaseSpaceReadCnt(spaceNo);
	}
	
	@Override
	public int minusLikeCnt(Wish wish) {
		return spaceDAO.minusLikeCnt(wish);
	}

	@Override
	public int deleteOption(String spaceNo) {
		return spaceDAO.deleteOption(spaceNo);
	}

	@Override
	public int updateStatus(String spaceNo, String status) {
		return spaceDAO.updateStatus(spaceNo, status);
	}

	@Override
	public int selectHostReviewTotalContents(String spaceNo) {
		return spaceDAO.selectHostReviewTotalContents(spaceNo);
	}

	@Override
	public int deleteSpace(String spaceNo) {
		return spaceDAO.deleteSpace(spaceNo);
	}
	
	/*@Override
	public List<Space> selectListSpaceCollection(String email) {
		return spaceDAO.selectListSpaceCollection(email);
	}*/
	
}
