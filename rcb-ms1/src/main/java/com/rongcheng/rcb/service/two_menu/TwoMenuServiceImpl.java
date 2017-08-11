package com.rongcheng.rcb.service.two_menu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rongcheng.rcb.dao.TwoMenuDAO;
import com.rongcheng.rcb.entity.TwoMenu;
@Service("twoMenuService")
public class TwoMenuServiceImpl implements TwoMenuService {
	@Resource
	private TwoMenuDAO twoMenuDAO;
	
	public String getTitleById(Integer id) {
		return twoMenuDAO.getTitleById(id);
	}

	public List<TwoMenu> listTwoMenuDisplayByOneMenuId(Integer oneMenuId) {
		return twoMenuDAO.listTwoMenuDisplayByOneMenuId(oneMenuId);
	}
	
	/////zb///////////////
	//查找TwoMenu所有对象
		public List<TwoMenu> listTwoMenuAll() {
			
			List<TwoMenu> list = twoMenuDAO.listTwoMenuAll();
			return list;
		}

		//增加TwoMenu
		public TwoMenu insertTwoMenu(Integer oneMenuId,String title,String iconUrl, String link, String profile, String keyword,Byte display,
				Byte seq,String remark) {
			
			TwoMenu twoMenu = new TwoMenu(null, oneMenuId, title, iconUrl, link, profile, keyword, display, seq, remark);
			int row = twoMenuDAO.insertTwoMenu(twoMenu);
			return twoMenu;
		}

		//修改TwoMenu,返回行数
		public int updateTwoMenu(Integer id, Integer oneMenuId,String title,String iconUrl, String link, String profile, String keyword,Byte display,
				Byte seq,String remark) {
			
			TwoMenu twoMenu = twoMenuDAO.getTwoMenuById(id);
			twoMenu.setOneMenuId(oneMenuId);
			twoMenu.setTitle(title);
			twoMenu.setIconUrl(iconUrl);
			twoMenu.setLink(link);
			twoMenu.setProfile(profile);
			twoMenu.setKeyword(keyword);
			twoMenu.setDisplay(display);
			twoMenu.setSeq(seq);
			twoMenu.setRemark(remark);
			int row = twoMenuDAO.updateTwoMenu(twoMenu);
			return row;
		}

		//删除TwoMenu,返回行数
		public int deleteTwoMenuById(Integer id) {
			int row = twoMenuDAO.deleteTwoMenuById(id);
			return row;
		}

		public TwoMenu getTwoMenuById(Integer id) {
			TwoMenu towMenu = twoMenuDAO.getTwoMenuById(id);
			return towMenu;
		}

		public List<TwoMenu> listTwoMenuByOneMenuId(Integer oneMenuID) {
			List<TwoMenu> list = twoMenuDAO.listTwoMenuByOneMenuId(oneMenuID);
			return list;
		}
	/////zb///////////////
}
