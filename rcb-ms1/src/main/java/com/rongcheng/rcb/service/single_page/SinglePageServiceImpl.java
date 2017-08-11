package com.rongcheng.rcb.service.single_page;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rongcheng.rcb.dao.SinglePageDAO;
import com.rongcheng.rcb.entity.SinglePage;

@Service("singlePageService")
public class SinglePageServiceImpl implements SinglePageService{

	@Resource
	private SinglePageDAO singlePageDAO;
	
	public Integer updateSinglePageClick(Integer id){
		return singlePageDAO.updateSinglePageClick(id);
	}
	
	public SinglePage getSinglePageById(Integer id) {
		return singlePageDAO.getSinglePageById(id);
	}

	public List<SinglePage> listSinglePage() {
		return singlePageDAO.listSinglePage();
	}

	//首页用
	public List<SinglePage> listSinglePageByOneMenuIdAndFrontRow(Integer oneMenuId,Integer num){
		return singlePageDAO.listSinglePageByOneMenuIdAndFrontRow(oneMenuId, num);
	}
	public List<SinglePage> listSinglePageByOneTwoMenuIdAndFrontRow(Integer oneMenuId,Integer twoMenuId,Integer start,Integer row){
		return singlePageDAO.listSinglePageByOneTwoMenuIdAndFrontRow( oneMenuId, twoMenuId, start, row);
	}
	public List<SinglePage> listSinglePageByKeyword(String keyWord) {
		return singlePageDAO.listSinglePageByKeyword(keyWord);
	}

	//前台分页
	public Object[] listSinglePageByPage(Integer page, Integer num, Integer oneMenuId,Integer twoMenuId,Integer display) {
		Integer max_page = (int) Math.ceil(new Double(singlePageDAO.countSinglePageByOneTwoMenuId(oneMenuId, twoMenuId,1))/num);
		if(max_page == 0){
			return null;
		}
		if(page>max_page){
			page = max_page;
		}
		if(page<1){
			page = 1;
		}
		int start = page*num-num;
		return new Object[]{max_page,singlePageDAO.listSinglePageByOneTwoMenuIdAndDisplay(start, num, oneMenuId, twoMenuId, display)};
	}

	////////////zb//////////////
	//分页查找SinglePage，根据页数page，查询的行数rows
		public List<SinglePage> listSinglePageByPage(int page,int rows){
			/*System.out.println(page);*/
			int start = (page-1)*rows;
			List<SinglePage> list = singlePageDAO.listSinglePageByPage(start, rows);
			return list;
		}
		
		//分页查找SinglePage，根据起始行start，查询的行数rows，查询的行数rows,oneMenuId和twoMenuId
		public List<SinglePage> listSinglePageByPageMenuId(int page,int rows,int oneMenuId,int twoMenuId){
			int start = (page-1)*rows;
			List<SinglePage> list = singlePageDAO.listSinglePageByPageMenuId(start, rows, oneMenuId, twoMenuId);
			return list;
		}
		
		//分页查找SinglePage，根据起始行start，查询的行数rows，模糊查询
		public List<SinglePage> listSinglePageByPageLike(int page, int rows,String fuzzy){
			int start = (page-1)*rows;
			List<SinglePage> list = singlePageDAO.listSinglePageByPageLike(start, rows, fuzzy);
			return list;
		}
		
		//分页查找SinglePage，根据起始行start，查询的行数rows,oneMenuId
		public List<SinglePage> listSinglePageByPageOneMenuId(int page,int rows,int oneMenuId){
			int start = (page-1)*rows;
			List<SinglePage> list = singlePageDAO.listSinglePageByPageOneMenuId(start, rows, oneMenuId);
			return list;
		}
		
		//查找SinglePage条数
		public int countSinglePage(){
			return singlePageDAO.countSinglePage();
		}
		
		//查找SinglePage条数
		public int countSinglePageByPageMenuId(int oneMenuId,int twoMenuId){
			return singlePageDAO.countSinglePageByPageMenuId(oneMenuId, twoMenuId);
		}
		
		//查找SinglePage条数
		public int countSinglePageByPageLike(String fuzzy){
			return singlePageDAO.countSinglePageByPageLike(fuzzy);
		}
		
		//查找SinglePage条数
		public int countSinglePageByPageOneMenuId(int oneMenuId){
			return singlePageDAO.countSinglePageByPageOneMenuId(oneMenuId);
		}
		
		//增加SinglePage
		public int insertSinglePage(Integer oneMenuId,Integer twoMenuId, String title,
				String shortTitle,String author,String imgUrl,String keyword,
				String profile,String content1,String content2,String content3,
				Byte display,Byte seq,Integer click,String remark){
			Timestamp createTime = new Timestamp(System.currentTimeMillis()); 
			Timestamp modifyTime = createTime;
			SinglePage singlePage = new SinglePage(null, oneMenuId, twoMenuId, title, shortTitle,
					author, imgUrl, keyword, profile, content1, content2, content3, createTime, 
					modifyTime, display, seq, click, remark);
			int row = singlePageDAO.insertSinglePage(singlePage);
			return row;
		}
		
		//查找SinglePage根据id
//		public SinglePage getSinglePageById(Integer id){
//			SinglePage singlePage = singlePageDAO.getSinglePageById(id);
//			return singlePage;
//		}
		
		//修改SinglePage
		public int updateSinglePage(Integer id,Integer oneMenuId,Integer twoMenuId, String title,
				String shortTitle,String author,String imgUrl,String keyword,
				String profile,String content1,String content2,String content3,
				Byte display,Byte seq,Integer click,String remark){
			Timestamp modifyTime = new Timestamp(System.currentTimeMillis()); 
			SinglePage singlePage = singlePageDAO.getSinglePageById(id);
			singlePage.setOneMenuId(oneMenuId);
			singlePage.setTwoMenuId(twoMenuId);
			singlePage.setTitle(title);
			singlePage.setShortTitle(shortTitle);
			singlePage.setAuthor(author);
			singlePage.setImgUrl(imgUrl);
			singlePage.setKeyword(keyword);
			singlePage.setProfile(profile);
			singlePage.setContent1(content1);
			singlePage.setContent2(content2);
			singlePage.setContent3(content3);
			singlePage.setDisplay(display);
			singlePage.setSeq(seq);
			singlePage.setClick(click);
			singlePage.setRemark(remark);
			singlePage.setModifyTime(modifyTime);
			int row = singlePageDAO.updateSinglePage(singlePage);
			return row;
		}
		
		//删除SinglePage
		public int deleteSinglePageById(Integer id){
			int row = singlePageDAO.deleteSinglePageById(id);
			return row;
		}
	////////////zb//////////////
}
