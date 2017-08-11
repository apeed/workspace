package com.rongcheng.rcb.service.one_menu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rongcheng.rcb.dao.OneMenuDAO;
import com.rongcheng.rcb.dao.TwoMenuDAO;
import com.rongcheng.rcb.entity.OneMenu;
import com.rongcheng.rcb.entity.TwoMenu;
import com.rongcheng.rcb.exception.ForeignKeysException;

@Service("oneMenuService")
public class OneMenuServiceImpl implements OneMenuService {
	@Resource
	private OneMenuDAO oneMenuDAO;
	@Resource
	private TwoMenuDAO twoMenuDAO;

	public String getTitleById(Integer id) {
		return oneMenuDAO.getTitleById(id);
	}

	public OneMenu getOneMenuById(Integer id) {
		return oneMenuDAO.getOneMenuById(id);
	}
	
	/**
	 * 查询前几个一级菜单（包含不显示的）
	 * @param num 要查询的数量
	 * @return
	 */
	public List<OneMenu> listOneMenuByFrontRow(Integer num) {
		return oneMenuDAO.listOneMenuByFrontRow(num);
	}
/////zb////////////////
	//查找OneMenu所有对象
		public List<OneMenu> listOneMenuAll() {
			
			List<OneMenu> list = oneMenuDAO.listOneMenuAll();
			return list;
		}
		
		//增加OneMenu
		public OneMenu insertOneMenu(String title,String iconUrl, String link, String profile, String keyword,Byte display,
				Byte seq,String remark) {
			
			OneMenu oneMenu = new OneMenu(null, title, iconUrl, link, profile, keyword, display, seq, remark);
			int row = oneMenuDAO.insertOneMenu(oneMenu);
			return oneMenu;
		}
		//修改OneMenu,返回行数
		public int updateOneMenu(Integer id, String title,String iconUrl, String link, String profile, String keyword,Byte display,
				Byte seq,String remark) {
			
			OneMenu oneMenu = oneMenuDAO.getOneMenuById(id);
			oneMenu.setTitle(title);
			oneMenu.setIconUrl(iconUrl);
			oneMenu.setLink(link);
			oneMenu.setProfile(profile);
			oneMenu.setKeyword(keyword);
			oneMenu.setDisplay(display);
			oneMenu.setSeq(seq);
			oneMenu.setRemark(remark);
			int row = oneMenuDAO.updateOneMenu(oneMenu);
			return row;
		}

		//删除OneMenu,返回行数
		public int deleteOneMenuById(Integer id) throws ForeignKeysException{
			
			List<TwoMenu> list = twoMenuDAO.listTwoMenuByOneMenuId(id);
			if(list.isEmpty() || list == null){
				int row = oneMenuDAO.deleteOneMenuById(id);
				return row;
			}else{
				throw new ForeignKeysException("存在子栏目，无法删除！");
			}
			
			
		}

		//查找OneMenu根据id，返回OneMenu对象
//		public OneMenu getOneMenuById(Integer id){
//			OneMenu oneMenu = oneMenuDAO.getOneMenuById(id);
//			return oneMenu;
//		}
/////zb////////////////

}
