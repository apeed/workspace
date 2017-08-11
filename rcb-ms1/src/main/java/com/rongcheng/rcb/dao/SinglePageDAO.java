package com.rongcheng.rcb.dao;

import java.util.List;

import com.rongcheng.rcb.entity.SinglePage;

public interface SinglePageDAO {
	Integer updateSinglePageClick(Integer id);
	int countSinglePageByOneTwoMenuId(Integer oneMenuId,Integer twoMenuId,Integer display);
	SinglePage getSinglePageById(Integer id);
	List<SinglePage> listSinglePage();
	List<SinglePage> listSinglePageByOneTwoMenuIdAndDisplay(Integer start, Integer num, Integer oneMenuId,Integer twoMenuId,Integer display);
	List<SinglePage> listSinglePageByOneMenuIdAndFrontRow(Integer oneMenuId,Integer num);//首页用
	List<SinglePage> listSinglePageByOneTwoMenuIdAndFrontRow(Integer oneMenuId,Integer twoMenuId,Integer start,Integer row);
	/**
	 * 模糊查询（查询的字段有：。。。）
	 * @param keyWord
	 * @return
	 */
	List<SinglePage> listSinglePageByKeyword(String keyWord);
	
	//////////zb/////////
	//分页查找SinglePage，根据起始行start，查询的行数rows
	public List<SinglePage> listSinglePageByPage(int start ,int rows);
	
	//分页查找SinglePage，根据起始行start，查询的行数rows,oneMenuId和twoMenuId
	public List<SinglePage> listSinglePageByPageMenuId(int start ,int rows,int oneMenuId,int twoMenuId);
	
	//分页查找SinglePage，根据起始行start，查询的行数rows，模糊查询
	public List<SinglePage> listSinglePageByPageLike(int start, int rows,String fuzzy);
		
	//分页查找SinglePage，根据起始行start，查询的行数rows,oneMenuId
	public List<SinglePage> listSinglePageByPageOneMenuId(int start ,int rows,int oneMenuId);
		
	//查找SinglePage条数
	public int countSinglePage();
	
	//查找SinglePage条数
	public int countSinglePageByPageMenuId(int oneMenuId,int twoMenuId);
	
	//查找SinglePage条数
	public int countSinglePageByPageLike(String fuzzy);
	
	//查找SinglePage条数
	public int countSinglePageByPageOneMenuId(int oneMenuId);
	
	//增加SinglePage
	public int insertSinglePage(SinglePage singlePage);
	
	//查找SinglePage根据id
	//public SinglePage getSinglePageById(Integer id);
	
	//修改SinglePage
	public int updateSinglePage(SinglePage singlePage);
	
	//删除SinglePage
	public int deleteSinglePageById(Integer id);
	//////////zb/////////
}
