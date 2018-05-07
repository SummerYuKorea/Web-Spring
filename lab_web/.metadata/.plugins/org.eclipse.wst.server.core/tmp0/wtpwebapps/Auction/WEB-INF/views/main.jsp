<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
      <!-- jQuery CDN 포함: 라이브러리 포함  -->
      <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>Auction_Main</title>

    <!--  Bootstrap 최신 버전의 CSS 파일들을 링크 -->


    <style media="screen">
      .main{
        margin: auto;
        width: 100%;
        min-width: 1200px;
        height: 1000px;
        /*background-color:#ffa;*/
        /*
        찐주황:  #F15A22;
        연주황: #F58220
        하늘: #00ADF0
        */
      }

 

      .body1{

        width: 965px;
        height:410px;

        margin: auto;
        background-color: #000;
        /*url로 줄때는 또 슬래쉬로 줘야함 \ 이거 안됨 .. */
        /*background-image: url("resources/images/food/김장3.jpg");*/
        /*background-image: url("resources/images/food/고흥군특산물.jpg");*/
        /*background-image: url("resources/images/food/한돈.jpg");*/
        /*background-image: url("resources/images/food/호두.jpg");*/
        background-image: url("resources/images/food/수산물.jpg"); 
        /*background-image: url("resources/images/food/육류.jpg");*/
        position: relative;

      }

      .search_form{
        width:100%;
        padding: 10px;
        background-color: #F15A22;

        position: absolute;
        top: 410px;


      }

      .body2{
        margin-top: 120px;
        text-align: center;
      }
    </style>
  </head>
  <body>

    <div class="main">
      <%@ include file="product/header.jspf" %>
     
      <div class="body1">

        <div class="search_form">
        <!--검색 form! -->
        <form id="search" action="product/productList">

                             <div class="block1">
                                <div class="row">

                                   <label for="user_id" class="col-sm-2 control-label lable-title">

                                   <select id = "category" name ="category" style="width:150px; height:33px; border-width:1px; border-radius:5px; border-color:#800000; background-color: #ffffff;
                                       box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);">
                                     <option value="all" >========전체=======</option>
                                      <option value="fresh" >쌀/과일/농수축산물</option>
                                   <option value="drink" >커피/음료</option>
                                     <option value="healthy" >건강/다이어트</option>
                                   <option value="instant" >즉석/가공식품</option>
                              </select></label>
                                   <div class="col-sm-8">
                                      <input type="text" class="form-control" id="usrId" name="name" placeholder="상품이름을 입력하세요" value="" required>
                                   </div>
                                   <button type="submit" class="btn btn-primary btn-block btn-login"  id="login_btn" style="width:150px; background-color: #800000; border-color: #800000;">검색하기</button>

                                 </div>

                               </div>
         </form>
         </div>

      </div>

      <div class="body2">
        <img src="http://static.ssgcdn.com/ui/ssg/img/common/h3_tit_06.gif" alt="Category Best">
      </div>


    </div>

   
  </body>
</html>
