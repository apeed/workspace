package com.rongcheng.rcb.service.single_page;

import java.util.List;

import com.rongcheng.rcb.entity.SinglePage;

public interface SinglePageService {
	Integer updateSinglePageClick(Integer id);
	SinglePage getSinglePageById(Integer id);
	List<SinglePage> listSinglePage();
	Object[] listSinglePageByPage(Integer page,Integer num,Integer oneMenuId,Integer twoMenuId,Integer display);
	List<SinglePage> listSinglePageByOneMenuIdAndFrontRow(Integer oneMenuId,Integer num);//首页用
	List<SinglePage> listSinglePageByOneTwoMenuIdAndFrontRow(Integer oneMenuId,Integer twoMenuId,Integer start,Integer row);
	/**
	 * 模糊查询（查询的字段有：）
	 * @param keyWord
	 * @return
	 */
	List<SinglePage> listSinglePageByKeyword(String keyWord);
	
	/////////zb/////////////
	//分页查找SinglePage，根据起始行start，查询的行数rows
		public List<SinglePage> listSinglePageByPage(int page,int rows);
		
		//分页查找SinglePage，根据起始行start，查询的行数rows，查询的行数rows,oneMenuId和twoMenuId
		public List<SinglePage> listSinglePageByPageMenuId(int page,int rows,int oneMenuId,int twoMenuId);
		
		//分页查找SinglePage，根据起始行start，查询的行数rows，模糊查询
		public List<SinglePage> listSinglePageByPageLike(int page, int rows,String fuzzy);
			
		//分页查找SinglePage，根据起始行start，查询的行数rows,oneMenuId
		public List<SinglePage> listSinglePageByPageOneMenuId(int page,int rows,int oneMenuId);
		
		//查找SinglePage条数
		public int countSinglePage();
		
		//查找SinglePage条数
		public int countSinglePageByPageMenuId(int oneMenuId,int twoMenuId);
		
		//查找SinglePage条数
		public int countSinglePageByPageLike(String fuzzy);
		
		//查找SinglePage条数
		public int countSinglePageByPageOneMenuId(int oneMenuId);
		
		//增加SinglePage
		public int insertSinglePage(Integer oneMenuId,Integer twoMenuId, String title,
				String shortTitle,String author,String imgUrl,String keyword,
				String profile,String content1,String content2,String content3,
				Byte display,Byte seq,Integer click,String remark);
		
		//查找SinglePage根据id
		//public SinglePage getSinglePageById(Integer id);
		
		//修改SinglePage
		public int updateSinglePage(Integer id,Integer oneMenuId,Integer twoMenuId, String title,
				String shortTitle,String author,String imgUrl,String keyword,
				String profile,String content1,String content2,String content3,
				Byte display,Byte seq,Integer click,String remark);
		
		//删除SinglePage
		public int deleteSinglePageById(Integer id);
	/////////zb/////////////
}
