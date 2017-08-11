<%@page contentType="text/html;charset=GBK" language="java" import="java.sql.*" errorPage=""%>
<%@page import="com.dao.BuyList"%>
<%@page import="java.util.*"%>
<%
request.setCharacterEncoding("GBk");
String name=request.getParameter("name");
String price=request.getParameter("price");
String photo=request.getParameter("photo");
String id=request.getParameter("id");

BuyList buyList= new BuyList();
buyList.id=id;
buyList.number=1;
buyList.photo=photo;
buyList.price=Float.parseFloat(price);
buyList.warename=name;
boolean flag=true;

List shoplist=null;
if(session.getAttribute("shop")==null){
	shoplist=new ArrayList();
	
}else{
	shoplist=(List)session.getAttribute("shop");
	for(int i=0;i<shoplist.size();i++){
		BuyList buyitem=(BuyList)shoplist.get(i);
		if(buyitem.id.equals(buyList.id)){
			buyitem.number++;
			shoplist.set(i,buyitem);
			flag=false;
		}
	}
}
if(flag)shoplist.add(buyList);
	session.setAttribute("shop", shoplist);
	%>
	<script language="javascript" type="text/javascript">
	alert("商品已成功添加到购物车");
	window.location.href="index.jsp";
	</script>


















