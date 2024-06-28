package com.quiz.lesson06.bo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	
	@Autowired
	BookmarkMapper bookmarkMapper;

	// input : x
	// output : List<Bookmark>
	public List<Bookmark> getBookmarkList(){
		return bookmarkMapper.selectBookmarkList();
	}
	
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	// input : url
	// output : boolean
	public boolean isDuplication(String url) {
		// 중복 o: [bookmark1, bookmark2] - true
		// 중복 x : [] - false
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkListByUrl(url);
		//return bookmarkList.isEmpty() ? false : true;
		return !bookmarkList.isEmpty();
	}
	
	public int deleteBookmarkById(int id) {
		return bookmarkMapper.deleteBookmarkById(id);
	}
}
