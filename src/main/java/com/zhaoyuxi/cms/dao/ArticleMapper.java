package com.zhaoyuxi.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.zhaoyuxi.cms.entity.Article;

/**
*@author 作者:赵玉玺
*@version 创建时间：2019年9月18日 下午7:34:42
*类功能说明
*/
public interface ArticleMapper {


	List<Article> list(@Param("channelId") Integer channelId,
			@Param("catId") Integer cid);

	Article findById(Integer articleId);
	
	int add(Article article);
	
	
	List<Article> listByUser(@Param("userId") Integer userId);

	// 获取审核的文章列表
	List<Article> checkList(Integer status);

	/**
	 * 修改文章的状态
	 * @param id
	 * @param status
	 * @return
	 */
	@Update("update cms_article set status=#{status} , updated=now() where id=#{id}")
	int updateStatus(@Param("id") Integer id, @Param("status") Integer status);

	/**
	 * 获取热门文章
	 * @return
	 */
	List<Article> hotList();

	
	/** 
	 * 获取最新文章
	 * @return
	 */
	List<Article> lastArticles();
	
	
	/**
	 * 设置热门
	 * @param id
	 * @param status
	 * @return
	 */
	@Update("update cms_article set hot=#{status} , updated=now() where id=#{id}")
	int updateHot(@Param("id") Integer id, @Param("status") Integer status);
	
	@Update("update cms_article set title=#{title},content=#{content1},channel_id=#{channelId},category_id=#{categoryId} where id=#{id}")
	int updatea(@Param("id")Integer id,@Param("title") String title,@Param("categoryId") Integer categoryId, @Param("channelId")Integer channelId,@Param("content1") String content1);

	@Update("update cms_article set commentCnt = commentCnt + 1 where id=#{value}")
	void increaseCommentCnt(Integer articleId);
}
