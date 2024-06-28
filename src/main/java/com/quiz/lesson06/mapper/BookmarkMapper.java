package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.domain.Bookmark;

@Mapper
public interface BookmarkMapper {
	
	//select
	public List<Bookmark> selectBookmarkList();
	
	//insert
	public void insertBookmark(@Param("name") String name, @Param("url") String url);
	
	// input : url
	// output : List<Bookmark> url 중복 여러개 일 수 있어서 List
	public List<Bookmark> selectBookmarkListByUrl(String url);
	// 중복 x : []
	// 중복 o : [a,a]
	
	public int deleteBookmarkById(int id);
}
