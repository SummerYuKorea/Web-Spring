<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/common1.css">
<link rel="stylesheet" type="text/css" href="resources/css/view.css">
<title>판매자 평점 등록</title>

<style>
	#table, #table thead{
		border: 2px solid grey;
		padding: 5px;
	}
	#table tr, #table tr td{
		margin:5px;	
		padding:5px;
	}

</style>

</head>
<body>

  
   
  
   <h1>상품평</h1>
   
   <table id="table">
   	 <thead>
        <tr>
            <td> </td>
            <td> 상품정보(이름 )</td>
            <td> 판매자</td>
        	<td> 등급</td>
            
      	</tr>
      </thead>
      <tbody>
      	<tr>
        	<td><img alt="파리" src="resources/images/a.jpg" width="150px" height="100px" /></td>
            <td>아사이베리 </td>
            <td>summer</td>
            <td>등급</td>   
        </tr>  
      </tbody>   
   </table>
   <br/><hr/>
               

   
    <h3>구매평: 상품의 만족도를 선택해주세요</h3>
    
	<div class="vote_lst">
   		<dl class="lt">
			<dt id="topStarLabel"><img src="http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/detail/txt_point_click.gif" width="38" height="11" class="starscore_guide_txt" alt="별점주기"></dt>
            <dd id="topStarSelectbox">
            	<div class="pointSelect fl" >
               		<a onclick="clickSelector()" href="#" class="default" id="starScoreMenu_1"><span class="star_type4"><span id="topTargetMask" class="mask" style="width:100%"><img src="http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/ico_star_n.gif" width="60" height="12" alt="점수선택" class="starscore_star_pic" ></span></span></a>
                    <ul style="display:none;margin:0px;padding:0px;" id="pointSelectOption">
                    	<li><a onclick="clickcr(this,'10')" href="#" id="topStar10Select" title="10점"><span class="star_type4"><span class="mask" style="width:100%"><img src="http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/ico_star_n.gif" width="60" height="12" alt="10점">10점</span></span></a></li>
                        <li><a onclick="clickcr(this,'9')" href="#" id="topStar9Select" title="9점"><span class="star_type4"><span class="mask" style="width:90%"><img src="http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/ico_star_n.gif" width="60" height="12" alt="9점">9점</span></span></a></li>
                        <li><a onclick="clickcr(this,'8')" href="#" id="topStar8Select" title="8점"><span class="star_type4"><span class="mask" style="width:80%"><img src="http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/ico_star_n.gif" width="60" height="12" alt="8점">8점</span></span></a></li>
                        <li><a onclick="clickcr(this,'7')" href="#" id="topStar7Select" title="7점"><span class="star_type4"><span class="mask" style="width:70%"><img src="http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/ico_star_n.gif" width="60" height="12" alt="7점">7점</span></span></a></li>
                        <li><a onclick="clickcr(this,'6')" href="#" id="topStar6Select" title="6점"><span class="star_type4"><span class="mask" style="width:60%"><img src="http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/ico_star_n.gif" width="60" height="12" alt="6점">6점</span></span></a></li>
                        <li><a onclick="clickcr(this,'5')" href="#" id="topStar5Select" title="5점"><span class="star_type4"><span class="mask" style="width:50%"><img src="http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/ico_star_n.gif" width="60" height="12" alt="5점">5점</span></span></a></li>
                        <li><a onclick="clickcr(this,'4')" href="#" id="topStar4Select" title="4점"><span class="star_type4"><span class="mask" style="width:40%"><img src="http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/ico_star_n.gif" width="60" height="12" alt="4점">4점</span></span></a></li>
                        <li><a onclick="clickcr(this,'3')" href="#" id="topStar3Select" title="3점"><span class="star_type4"><span class="mask" style="width:30%"><img src="http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/ico_star_n.gif" width="60" height="12" alt="3점">3점</span></span></a></li>
                        <li><a onclick="clickcr(this,'2')" href="#" id="topStar2Select" title="2점"><span class="star_type4"><span class="mask" style="width:20%"><img src="http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/ico_star_n.gif" width="60" height="12" alt="2점">2점</span></span></a></li>
                        <li><a onclick="clickcr(this,'1')" href="#" id="topStar1Select" title="1점"><span class="star_type4"><span class="mask" style="width:10%"><img src="http://static.comic.naver.net/staticImages/COMICWEB/NAVER/img/common/ico_star_n.gif" width="60" height="12" alt="1점">1점</span></span></a></li>
                    </ul>
                </div>
               <!--  <a href="#" class="btn_bx fl" id="topStarScoreSubmitButton" onclick="clickcr(this,'bdt.starok','','');"  ><span>확인</span></a> -->
            </dd>
            <dd id="topStarText" class="txt" style="display:none;"><span>참여하셨습니다.</span></dd>
        </dl>       
        
    	 <br/><br/><br/>
        
        <!-- grade와 detail값을 넘겨줌 -->
        <form action="registerReview" method="post">
        	<input type="hidden" name="grade" id="grade"/>
        	<!-- <label for="review" > 리뷰</label> -->
        	<textarea  rows="4" cols="60" name="detail" placeholder="리뷰" required autofocus></textarea> 
        	<br/>                  
        	<input type="submit" value="확인"/>
        
        </form>      
	
	</div> 
      
	<script>
         
    function clickSelector(){
    	var display = $('#pointSelectOption').css('display');
               
        if(display=='none'){
        	$('#pointSelectOption').css('display','inline-table');
        }else {
        	$('#pointSelectOption').css('display','none');
        }
	}//function clickSelector()
            
	function clickcr(p,num){
		var wid=num*10;
	
		$('#pointSelectOption').css('display','none');//drop-down-list 접는다
		$('#topTargetMask').css('width', wid+'%');
		
		$('#grade').val(num);
	}
            

	</script>

   

</body>
</html>


