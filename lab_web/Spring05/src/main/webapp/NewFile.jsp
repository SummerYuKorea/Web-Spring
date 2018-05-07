<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>

<style>
btn{

   display: inline-block;
    vertical-align: top;
    pading: 10px;
}


ul,ol,menu,li {
list-style:none;
}

  

.goodDetail_Area{margin:0px 20px;width:500px;float:left;}

   .goodtitleArea{width:500px;border-bottom:1px solid #ddd;float:left;padding-bottom:5px;}
      .goods_tit_txt1{font-size: 19px;line-height: 21px;margin-bottom: 0px; width:460px;}
      .goods_tit_txt1 a{color: #b56818;}
      .goods_tit_txt1 a:hover{text-decoration:underline;}
      

#goods_pic_main{
text-align:center;
vertical-align:center;
}



.goodImg_Area{width:500px;float:left}
   .goods_pic{width:500px; height:500px; border:solid 1px #ccc; display:block;position:relative; overflow:hidden;background:#fff}
   .goods_pic img{position:absolute;top:0;right:0;bottom:0;left:0;margin:auto;max-height:100%;max-width:100%;}
   .goods_pic_btn{width:100%; margin-top:20px; text-align:center;}

   #s_goods{margin-top:10px; text-align:center;}
   .s_goods_pic{float:left; width:80px; height:80px; margin-left:5px; margin-right:5px; border:solid 1px #ccc; display:block; position:relative; overflow:hidden;}
   .s_goods_pic img{position:absolute;top:0;right:0;bottom:0;left:0;margin:auto;max-height:100%;max-width:100%;}
   .s_goods_pic_btn{float:left; margin-top:31px;}
   .thumImg{margin-top:10px; text-align:center;}


.goodGreadInfor{margin:10px 10px 10px;clear:both;float:left;width:100%}
   .goodGreadInfor li{font-size:14px;color:#666;line-height: 16px;padding:4px 0}
   .goodGreadInfor .strong{color:#000}
   .goodGreadInfor .deadtime{color:;}
   .goodGreadInfor .deadtimeShort{color:#e43137;}
   .goodGreadInfor .doogst{color:#e43137}
   .goodGreadInfor .pass{font-size: 12px;color:#888}

.goodSeller{
   width:300px;display: inline-block; border-left:1px solid #ddd; 
}

.goodtitleArea2
   {border-bottom:1px solid #ddd;  display: inline-block;padding-bottom:5px;width:100%}

.goods_tit_txt2{font-size: 19px;line-height: 21px;margin-bottom: 0px; width:460px;}   


.star {
    display: inline-block;
    width: 75px;
    height: 13px;
    background: url(http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/sp_star.gif) no-repeat 0 -37px;
    text-align: left;
    vertical-align: middle;
}


.star em {

    display: block;
    background: url(http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/sp_star.gif) no-repeat 0 -59px;
    text-indent: -9999px;
}

.detailTitle {
    margin: 0 0 17px;
    border-bottom: 1px solid #e0e0e0;
    font-size: 22px;
    color: #222222;
    font-size: 20px;
    line-height: 50px;
    letter-spacing: -0.5px; 
}

.detailSection{
   position: absolute;
   top:650px;
   left:20px;
   width: 1400px;
   height:500px;
   border: 1px solid #ccc;
   
    padding: 10px 20px 10px 20px;
    margin-bottom: 10px;
    
}

.detailSection2{
   position: absolute;
   top:1200px;
   left:20px;
   width: 1400px;
   height:500px;
   border: 1px solid #ccc;
   
    padding: 10px 20px 10px 20px;
    margin-bottom: 10px;
}

.detailSection3{
   position: absolute;
   top:1750px;
   left:20px;
   width: 1400px;
   height:500px;
   
   border: 1px solid #ccc;
    padding: 10px 20px 10px 20px;
    margin-bottom: 10px;
}
</style>


<!-- 
<nav>: 링크, 메뉴
 -->
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>




<div class="goodTotal">
<section class="goodImg_Area">
    <p class="goods_pic" id="goods_pic_main" style="position: relative;"><img src="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/l-4AAOSwGIRXYikX/$_1.JPG?set_id=880000500F" id="IMG_DETAIL" name="IMG_DETAIL" onload="detailImageLoad(this)" onerror="imageErrorL(this)" data-zoom-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/l-4AAOSwGIRXYikX/$_1.JPG?set_id=880000500F" onclick="viewFullImage();" style="top: 50px; left: 50px;"><img style="display: none; top: 50px; left: 50px;" src="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/l-4AAOSwGIRXYikX/$_1.JPG?set_id=880000500F" width="null" height="null"></p>
    
        

    <!-- 썸네일 이미지 -->
    <!-- todo : http://dev.ebay.auction.co.kr/?dir=shop&itemID=161747155826 -->
    <div class="thumImg">
        <table >
            <tbody><tr>
                <td width="10" align="left"><img name="img_thumbnail_left" src="http://pics3.wsbind.com/global/ns_lft01.png" style="cursor: pointer;"></td>
                <td><div style="width:460px;height:90px;overflow:hidden;border:red 1px none" id="id_thumbnail_frame"><table style="margin-left: 0px;">
                            <tbody><tr>
                                                                    <td align="center" height="90">
                                        <a href="#" data-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/l-4AAOSwGIRXYikX/$_1.JPG?set_id=880000500F" data-zoom-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/l-4AAOSwGIRXYikX/$_1.JPG?set_id=880000500F"><div class="s_goods_pic" style="border-color: rgb(255, 84, 0); cursor: pointer;"><img src="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/l-4AAOSwGIRXYikX/$_1.JPG?set_id=880000500F"  onclick="document.getElementById('IMG_DETAIL').src='http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/l-4AAOSwGIRXYikX/$_1.JPG?set_id=880000500F'" onload="resizeImage(this, 82, 82, 76)" onerror="imageErrorS(this)" width="80" height="80" style="margin-top: 0px;"></div></a></td>
                                                                    <td align="center" height="90">
                                        <a href="#" data-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/UWEAAOSwNuxXYikX/$_1.JPG?set_id=880000500F" data-zoom-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/UWEAAOSwNuxXYikX/$_1.JPG?set_id=880000500F"><div class="s_goods_pic" style="cursor: pointer;"><img src="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/UWEAAOSwNuxXYikX/$_1.JPG?set_id=880000500F"  onclick="document.getElementById('IMG_DETAIL').src='http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/UWEAAOSwNuxXYikX/$_1.JPG?set_id=880000500F'" onload="resizeImage(this, 82, 82, 76)" onerror="imageErrorS(this)" width="80" height="80"  style="margin-top: 0px;"></div></a></td>
                                                                    <td align="center" height="90">
                                        <a href="#" data-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/HA8AAOSwc1FXYikX/$_1.JPG?set_id=880000500F" data-zoom-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/HA8AAOSwc1FXYikX/$_1.JPG?set_id=880000500F"><div class="s_goods_pic" style="cursor: pointer;"><img src="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/HA8AAOSwc1FXYikX/$_1.JPG?set_id=880000500F"  onclick="document.getElementById('IMG_DETAIL').src='http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/HA8AAOSwc1FXYikX/$_1.JPG?set_id=880000500F'" onload="resizeImage(this, 82, 82, 76)" onerror="imageErrorS(this)" width="80" height="80"  style="margin-top: 0px;"></div></a></td>
                                                                    <td align="center" height="90">
                                        <a href="#" data-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/r~YAAOSwvg9XYikX/$_1.JPG?set_id=880000500F" data-zoom-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/r~YAAOSwvg9XYikX/$_1.JPG?set_id=880000500F"><div class="s_goods_pic" style="cursor: pointer;"><img src="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/r~YAAOSwvg9XYikX/$_1.JPG?set_id=880000500F"  onclick="document.getElementById('IMG_DETAIL').src='http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/r~YAAOSwvg9XYikX/$_1.JPG?set_id=880000500F'" onload="resizeImage(this, 82, 82, 76)" onerror="imageErrorS(this)" width="80" height="80" style="margin-top: 0px;"></div></a></td>
                                                                    <td align="center" height="90">
                                        <a href="#" data-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/jukAAOSwmtJXYikX/$_1.JPG?set_id=880000500F" data-zoom-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/jukAAOSwmtJXYikX/$_1.JPG?set_id=880000500F"><div class="s_goods_pic" style="cursor: pointer;"><img src="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/jukAAOSwmtJXYikX/$_1.JPG?set_id=880000500F"  onclick="document.getElementById('IMG_DETAIL').src='http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/jukAAOSwmtJXYikX/$_1.JPG?set_id=880000500F'" onload="resizeImage(this, 82, 82, 76)" onerror="imageErrorS(this)" width="80" height="80" style="margin-top: 0px;"></div></a></td>
                                                                    <td align="center" height="90">
                                        <a href="#" data-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/vPgAAOSwepJXYikW/$_1.JPG?set_id=880000500F" data-zoom-image="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/vPgAAOSwepJXYikW/$_1.JPG?set_id=880000500F"><div class="s_goods_pic" style="cursor: pointer;"><img src="http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/vPgAAOSwepJXYikW/$_1.JPG?set_id=880000500F"  onclick="document.getElementById('IMG_DETAIL').src='http://i.ebayimg.com/00/s/MTAwMFgxMDAw/z/vPgAAOSwepJXYikW/$_1.JPG?set_id=880000500F'" onload="resizeImage(this, 82, 82, 76)" onerror="imageErrorS(this)" width="80" height="80" style="margin-top: 0px;"></div></a></td>
                                                                    <td align="center" height="90">
                                        <a href="#" data-image="http://i.ebayimg.com/00/s/Njc2WDY3Ng==/z/0w8AAOSwN6JZALJm/$_1.JPG?set_id=880000500F" data-zoom-image="http://i.ebayimg.com/00/s/Njc2WDY3Ng==/z/0w8AAOSwN6JZALJm/$_1.JPG?set_id=880000500F"><div class="s_goods_pic" style="cursor: pointer;"><img src="http://i.ebayimg.com/00/s/Njc2WDY3Ng==/z/0w8AAOSwN6JZALJm/$_1.JPG?set_id=880000500F"  onclick="document.getElementById('IMG_DETAIL').src='http://i.ebayimg.com/00/s/Njc2WDY3Ng==/z/0w8AAOSwN6JZALJm/$_1.JPG?set_id=880000500F'" onload="resizeImage(this, 82, 82, 76)" onerror="imageErrorS(this)" width="80" height="80" style="margin-top: 0px;"></div></a></td>
                                                                    <td align="center" height="90">
                                        <a href="#" data-image="http://i.ebayimg.com/00/s/MTYwMFgxNjAw/z/rFkAAOSwIWVZALJo/$_1.JPG?set_id=880000500F" data-zoom-image="http://i.ebayimg.com/00/s/MTYwMFgxNjAw/z/rFkAAOSwIWVZALJo/$_1.JPG?set_id=880000500F"><div class="s_goods_pic" style="cursor: pointer;"><img src="http://i.ebayimg.com/00/s/MTYwMFgxNjAw/z/rFkAAOSwIWVZALJo/$_1.JPG?set_id=880000500F"  onclick="document.getElementById('IMG_DETAIL').src='http://i.ebayimg.com/00/s/MTYwMFgxNjAw/z/rFkAAOSwIWVZALJo/$_1.JPG?set_id=880000500F'" onload="resizeImage(this, 82, 82, 76)" onerror="imageErrorS(this)" width="80" height="80"  style="margin-top: 0px;"></div></a></td>
                                                                    <td align="center" height="90">
                                        <a href="#" data-image="http://i.ebayimg.com/00/s/MTUwMFgxNTAw/z/XbcAAOSwHptZAM6z/$_1.JPG?set_id=880000500F" data-zoom-image="http://i.ebayimg.com/00/s/MTUwMFgxNTAw/z/XbcAAOSwHptZAM6z/$_1.JPG?set_id=880000500F"><div class="s_goods_pic" style="cursor: pointer;"><img src="http://i.ebayimg.com/00/s/MTUwMFgxNTAw/z/XbcAAOSwHptZAM6z/$_1.JPG?set_id=880000500F"  onclick="document.getElementById('IMG_DETAIL').src='http://i.ebayimg.com/00/s/MTUwMFgxNTAw/z/XbcAAOSwHptZAM6z/$_1.JPG?set_id=880000500F'" onload="resizeImage(this, 82, 82, 76)" onerror="imageErrorS(this)" width="80" height="80"  style="margin-top: 0px;"></div></a></td>
                                                                    <td align="center" height="90">
                                        <a href="#" data-image="http://i.ebayimg.com/00/s/MTUwMFgxNTAw/z/q5wAAOSwtZJZAM60/$_1.JPG?set_id=880000500F" data-zoom-image="http://i.ebayimg.com/00/s/MTUwMFgxNTAw/z/q5wAAOSwtZJZAM60/$_1.JPG?set_id=880000500F"><div class="s_goods_pic" style="cursor: pointer;"><img src="http://i.ebayimg.com/00/s/MTUwMFgxNTAw/z/q5wAAOSwtZJZAM60/$_1.JPG?set_id=880000500F"  onclick="document.getElementById('IMG_DETAIL').src='http://i.ebayimg.com/00/s/MTUwMFgxNTAw/z/q5wAAOSwtZJZAM60/$_1.JPG?set_id=880000500F'" onload="resizeImage(this, 82, 82, 76)" onerror="imageErrorS(this)" width="80" height="80"  style="margin-top: 0px;"></div></a></td>
                                                            </tr>
                            <tr>
                            </tr>
                        </tbody></table></div></td>
                <td width="10" align="right"><img name="img_thumbnail_right" src="http://pics3.wsbind.com/global/ns_right02.png" style="cursor: pointer;"></td>
            </tr>
        </tbody></table>
    </div>
    
  
</section>
  </div>
<section class="goodDetail_Area">

<ul class="goodtitleArea">
    <li class="goods_tit_txt1">여기가 상품 이름입니다. 하하하하</li>
</ul>

<ul class="goodGreadInfor">
   <li>상품 코드 : ${product.code }</li>
   <li>상품 이름: ${product.name }</li>
    <li><div>제품상태: <span class="strong" style="color:#f00;">New ${product.detail}</span></div></li>
    <li>상품 시작가 : ${product.start_price }</li>
    <li>현재 입찰가 : ${product.contract_price }</li>     
    <li>판매종료: <span class="deadtime"><font id="id_left_time">8일 15시간 27분 52초 남음</font> (06월 11일 07시 40분 13초 종료)</span></li>
    <li><a href="">입찰자 수 : ${product.bidders} 명</a></li>  
    <li><a id="" href=""><img src="http://pics.auction.co.kr/listing/used/2014/btn_bidding.gif" alt=""></a>
       <a id="" href=""><img src="http://pics.auction.co.kr/listing/used/2014/btn_buy.gif" alt=""></a>
    </li>
    <li><a href="biddingList?code=${product.code }"><button type="button"  id="biddingList">입찰 기록</button></a>
    </li>
    
</ul>
</section>
<section class="goodSeller">
<ul class="goodtitleArea2">
   <li class="goods_tit_txt2">판매자  정보</li>
</ul>
<ul class="goodGreadInfor">
   <li>판매자 아이디 : 세모동동주</li>
   <li>판매자 별점/리뷰 :                      
                                <span class="star"><em style="width:77%">평점</em></span>
                                <span id="topPointTotalNumber"><strong>7.75</strong></span>
                                <span class="pointTotalPerson">(참여 <em>4</em>)</span>
                            
   </li>
   <li><a id="" href="">판매자의 다른 상품들</a></li>
</ul>
</section>

<section class="detailSection">
   <h3 class="detailTitle">상세정보</h3>
   </section>
<section class="detailSection2">
   <h3 class="detailTitle">추가구성상품</h3>
</section>

<section class="detailSection3">
   <h3 class="detailTitle">기  타</h3>
</section>


</body>
</html>