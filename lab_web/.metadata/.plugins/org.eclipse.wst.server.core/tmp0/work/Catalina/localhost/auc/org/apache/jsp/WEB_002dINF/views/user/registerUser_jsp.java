/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.43
 * Generated at: 2017-06-17 04:03:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registerUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html >\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/gstyle1.css\"/> \r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/gstyle2.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../resources/css/gstyle3.css\"/>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"UTF-8\"/>\r\n");
      out.write("<title>판매 정보</title>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\">\r\n");
      out.write("<script src=\"//code.jquery.com/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"//code.jquery.com/ui/1.11.4/jquery-ui.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write(".file-drop{\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   height: 200px;\r\n");
      out.write("   border: 1px solid grey;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!--       \r\n");
      out.write("   \r\n");
      out.write(" Ajax를 이용한 파일 업로드\r\n");
      out.write("   \r\n");
      out.write("<div class=\"file-drop\"  >사진 등록</div>   \r\n");
      out.write("<div class=\"upload-list\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write(" $(document).ready(function(){\r\n");
      out.write("    // 파일을 끌어다 놓을 때 (drag & drop)\r\n");
      out.write("    // 브라우저가 파일을 자동으로 열어주는 기능을 막음 (기본적으로 브라우저가 동작을 한다.)\r\n");
      out.write("     \r\n");
      out.write("    $('.file-drop').on('dragenter dragover', function(event) {\r\n");
      out.write("       event.preventDefault();       \r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    //drop 부분에서 한 가지 동작을 더 추가할 것이다. ajax 방식으로 파일을 업로드 하는 기능까지 추가!\r\n");
      out.write("    $('.file-drop').on('drop', function(event){\r\n");
      out.write("       \r\n");
      out.write("       // drop 이벤트의 기본 동작을 막음\r\n");
      out.write("       event.preventDefault();\r\n");
      out.write("       \r\n");
      out.write("       // Ajax를 이용해서 서버로 파일을 업로드\r\n");
      out.write("       // multipart/form-data 타입으로 파일을 업로드하기 위해서 \r\n");
      out.write("       var formData = new FormData();\r\n");
      out.write("       \r\n");
      out.write("       // drop한 파일들에 대한 정보 가져오기.\r\n");
      out.write("       var files = event.originalEvent.dataTransfer.files;\r\n");
      out.write("       var i = 0;\r\n");
      out.write("       for (i = 0; i < files.length; i++){\r\n");
      out.write("          console.log(files[i]);\r\n");
      out.write("       \r\n");
      out.write("          // 이제 이 파일 정보들을 formData에 넣는다. 서버에 보내기 위해서임.\r\n");
      out.write("          // 'files' 라는 이름으로 모든 파일들을 append 하기 \r\n");
      out.write("         formData.append('files', files[i]);\r\n");
      out.write("          \r\n");
      out.write("          // formData가 완성이 되었으니, 서버로 보내기.\r\n");
      out.write("          // 제이쿼리 라이브러리가 포함되어있어야 $ 포함된 함수 쓸 수 있음! 에이작스!\r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("          $.ajax({\r\n");
      out.write("             type: 'post',\r\n");
      out.write("             url: '/auc/upload-ajax',\r\n");
      out.write("             data: formData, \r\n");
      out.write("             dataType: 'text',\r\n");
      out.write("             processData: false,\r\n");
      out.write("             contentType: false,\r\n");
      out.write("             /* \r\n");
      out.write("             form의 enctype 속성을 기본값인 \"application/x-www-form-urlencoded\"을 사용하지 않고,\r\n");
      out.write("             \"multipart/form-data\"를 사용하기 위해서 반드시 주어야 할 속성은\r\n");
      out.write("             dataType: text, processData, contentType: false\r\n");
      out.write("             \r\n");
      out.write("             processType: true이면 enctype이 기본값이 되기 때문에 반드시 false라고 주어야 한다.\r\n");
      out.write("             */\r\n");
      out.write("             success: function(data){\r\n");
      out.write("                alert(data);\r\n");
      out.write("                \r\n");
      out.write("                var str = $('.upload-list').html(); //이렇게 하면 파일이 밑에 계속 추가될 것.\r\n");
      out.write("                str += '<div>' \r\n");
      out.write("                      + '<img src= \"/auc/display?fileName='\r\n");
      out.write("                      + data\r\n");
      out.write("                      + ' \"/>'\r\n");
      out.write("                      + data\r\n");
      out.write("                      + '</div>';\r\n");
      out.write("                $('.upload-list').html(str);                   \r\n");
      out.write("                                         \r\n");
      out.write("             } //end success\r\n");
      out.write("          }); //end ajax\r\n");
      out.write("          \r\n");
      out.write("       }//end for(i)\r\n");
      out.write("        \r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write(" });\r\n");
      out.write("</script>\r\n");
      out.write("      <input type = \"submit\" value =\"등록\"/>\r\n");
      out.write("</form> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- /// 상품 등록시작 세션  /// -->\r\n");
      out.write("      <section class=\"join-section\">\r\n");
      out.write("         <div class=\"container\">\r\n");
      out.write("            <div class=\"cont-title\"><!-- 회원정보 타이틀 시작 -->\r\n");
      out.write("               <h2>회원가입</h2>\r\n");
      out.write("               <!-- <ul class=\"list-unstyled\">\r\n");
      out.write("                  <li><span class=\"list-icon-line\">-</span>아래 항목을 충실히 작성해 주세요. 공란이 있을 경우 상품등록을 할 수 없습니다..</li>\r\n");
      out.write("               </ul> -->\r\n");
      out.write("            </div><!-- 회원정보 타이틀 끝 -->\r\n");
      out.write("\r\n");
      out.write("             <form id=\"fom_join\" action=\"registerUser\" method=\"post\"><!-- 회원가입 \"아이디\" 시작  -->\r\n");
      out.write("               <div class=\"login-cont-all\">\r\n");
      out.write("                  <article class=\"login-cont\"><!-- article 시작 -->\r\n");
      out.write("                     <div class=\"block1\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                           <label for=\"id\" class=\"col-sm-2 control-label lable-title\">회원 ID</label>\r\n");
      out.write("                           <div class=\"col-sm-10\">\r\n");
      out.write("                              <input type=\"text\" class=\"form-control\" id=\"id\" name=\"id\" placeholder=\"아이디를 5자이상 입력하세요\"  required>\r\n");
      out.write("                           </div>\r\n");
      out.write("                           <div id=\"result\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                     </div><!-- 회원가입 \"아이디\" 끝  -->\r\n");
      out.write("                     \r\n");
      out.write("                     \r\n");
      out.write("                     <div class=\"block1\"><!-- 회원가입 \"비밀번호\" 시작  -->\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                           <label for=\"pw\" class=\"col-sm-2 control-label lable-title\">비밀번호</label>\r\n");
      out.write("                           <div class=\"col-sm-10\">\r\n");
      out.write("                              <input type=\"password\" class=\"form-control\" id=\"pw\" name=\"pw\" placeholder=\"비밀번호 8자리 입력하세요\" required>\r\n");
      out.write("                           <div id=\"result1\"></div>\r\n");
      out.write("                           </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                     </div><!-- 회원가입 \"비밀번호\" 끝  -->\r\n");
      out.write("                     \r\n");
      out.write("                     <div class=\"block1\"><!-- 회원가입 \"비밀번호 확인\" 시작  -->\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                           <label for=\"pw2\" class=\"col-sm-2 control-label lable-title\">비밀번호 확인</label>\r\n");
      out.write("                           <div class=\"col-sm-10\">\r\n");
      out.write("                              <input type=\"password\" class=\"form-control\" id=\"pw2\" name=\"pw2\" placeholder=\"비밀번호 다시 입력하세요\" required>\r\n");
      out.write("                           <div id=\"result2\"></div>\r\n");
      out.write("                           </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                     </div><!-- 회원가입 \"비밀번호 확인\" 끝  -->\r\n");
      out.write("                     \r\n");
      out.write("                     \r\n");
      out.write("                     <div class=\"block1\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                           <label for=\"name\" class=\"col-sm-2 control-label lable-title\">회원 이름</label>\r\n");
      out.write("                           <div class=\"col-sm-10\">\r\n");
      out.write("                              <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" placeholder=\"회원이름을 입력하세요\" value=\"\" required>\r\n");
      out.write("                           </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                     </div><!-- 회원가입 \"회원이름\" 끝  -->\r\n");
      out.write("\r\n");
      out.write("                     \r\n");
      out.write("                     <div class=\"block1\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                           <label for=\"phone\" class=\"col-sm-2 control-label lable-title\">휴대전화번호</label>\r\n");
      out.write("                           <div class=\"col-sm-10\">\r\n");
      out.write("                              <input type=\"text\" class=\"form-control\" id=\"phone\" name=\"phone\" placeholder=\"전화번호를 입력하세요\" value=\"\">\r\n");
      out.write("                           </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                     </div><!-- 회원가입 \"휴대전화번호\" 끝  -->\r\n");
      out.write("                     \r\n");
      out.write("                     \r\n");
      out.write("                     <div class=\"block1\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                           <label for=\"email\" class=\"col-sm-2 control-label lable-title\">E-mail</label>\r\n");
      out.write("                           <div class=\"col-sm-10\">\r\n");
      out.write("                              <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"이메일을 입력하세요\" value=\"\">\r\n");
      out.write("                           </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                     </div><!-- 회원가입 \"이메일\" 끝  -->\r\n");
      out.write("                    \r\n");
      out.write("                     \r\n");
      out.write("                     <div class=\"block1\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                           <label for=\"address\" class=\"col-sm-2 control-label lable-title\">받을 주소</label>\r\n");
      out.write("                           <div class=\"col-sm-10\">\r\n");
      out.write("                              <input type=\"text\" class=\"form-control\" id=\"address\" name=\"address\" placeholder=\"주소를 입력하세요.\">\r\n");
      out.write("                           </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                     </div><!-- 회원가입 \"받을 주소\" 끝  -->\r\n");
      out.write("                     \r\n");
      out.write("          \r\n");
      out.write("                  </article><!-- article 끝 -->\r\n");
      out.write("               </div>\r\n");
      out.write("               \r\n");
      out.write("               \r\n");
      out.write("               <div class=\"btn-area\" ><!-- 등록하기 버튼 -->\r\n");
      out.write("                  <a type=\"button\" class=\"btn btn-primary btn-block btn-login\" id=\"join_btn\" style=\"width:1040px; margin:20px;\">회원가입</a>\r\n");
      out.write("               </div>\r\n");
      out.write("             <!--   <div class=\"btn-area\" style=\"float:left; margin-left:95px\"> 등록하기 버튼\r\n");
      out.write("                  <a role=\"button\" class=\"btn btn-primary btn-block btn-login\" id=\"login_btn\">수정</a>\r\n");
      out.write("               </div>\r\n");
      out.write("               <div class=\"btn-area\" style=\"float:left; margin-left:95px\">등록하기 버튼\r\n");
      out.write("                  <a role=\"button\" class=\"btn btn-primary btn-block btn-login\" id=\"login_btn\">삭제</a>\r\n");
      out.write("               </div> -->\r\n");
      out.write("               \r\n");
      out.write("               \r\n");
      out.write("               <!-- 등록하기 버튼  요까이~ -->\r\n");
      out.write("             </form>\r\n");
      out.write("      </section>\r\n");
      out.write("      \r\n");
      out.write("      <!-- /// 상품 등록 세션 끝 /// -->\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      <script>\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$('#id').keyup(function() {\r\n");
      out.write("\t\t\t\t// 아이디 5 ~ 20자 일때 //사용 가능한 아이디 입니다!//뜸\r\n");
      out.write("\t\t\t\tif($('#id').val().length >= 5 && $('#id').val().length <= 20) {\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\ttype: 'get',\r\n");
      out.write("\t\t\t\t\t\turl: 'checking-id',\r\n");
      out.write("\t\t\t\t\t\tdata: {id: $('#id').val()},\r\n");
      out.write("\t\t\t\t\t\tsuccess: function(res, status, xhr) {\r\n");
      out.write("\t\t\t\t\t\t\tif (res === 'valid') {\r\n");
      out.write("\t\t\t\t\t\t\t\t$('#result').html('사용 가능한 아이디 입니다!');\r\n");
      out.write("\t\t\t\t\t\t\t\t$('#result').css('color', 'green');\r\n");
      out.write("\t\t\t\t\t\t\t\t$('#btn-submit').prop('disabled',false)\r\n");
      out.write("\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t$('#result').html('이미 사용중이거나 탈퇴한 아이디입니다.');\r\n");
      out.write("\t\t\t\t\t\t\t\t$('#result').css('color', 'red');\r\n");
      out.write("\t\t\t\t\t\t\t\t$('#btn-submit').prop('disabled',true)\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$('#result').html('5~20자 입니다.');\r\n");
      out.write("\t\t\t\t\t$('#result').css('color', 'red');\r\n");
      out.write("\t\t\t\t} // end if() \r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t$('#pw').keyup(function() {\r\n");
      out.write("\t\t\t\t\t// 패스워드 4자 이상 //사용 가능한 아이디 입니다!//뜸\r\n");
      out.write("\t\t\t\tif($('#pw').val().length >= 8 && $('#pw').val().length <= 20) {\r\n");
      out.write("\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\ttype: 'post',\r\n");
      out.write("\t\t\t\t\t\t\turl: 'checking-id',\r\n");
      out.write("\t\t\t\t\t\t\tdata: {pw: $('#pw').val()},\r\n");
      out.write("\t\t\t\t\t\t\tsuccess: function(res, status, xhr) {\r\n");
      out.write("\t\t\t\t\t\t\t\tif (res === 'valid') {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#result1').html('8자 이상 입니다!');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#result1').css('color', 'green');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#btn-submit').prop('disabled',false)\r\n");
      out.write("\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#result1').html('패스워드가 짧습니다.');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#result1').css('color', 'red');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#btn-submit').prop('disabled',true)\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$('#result1').html('패스워드가 너무 짧습니다.');\r\n");
      out.write("\t\t\t\t\t$('#result1').css('color', 'red');\r\n");
      out.write("\t\t\t\t} // end if()  \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$('#join_btn').click(function(){\r\n");
      out.write("\t\t\t\tif($('#pw').val() == $('#pw2').val()){\r\n");
      out.write("\t\t\t\t\t//$('#result2').html('패스워드 확인 ');\r\n");
      out.write("\t\t\t\t    //$('#result2').css('color', 'green');\r\n");
      out.write("\t\t\t\t    if($('#id').val().length >= 5 && $('#id').val().length <= 20 && $('#pw').val().length >= 8 && $('#pw').val().length <= 20){\r\n");
      out.write("\t\t\t\t    \t//$('#result2').html('확인 ');\r\n");
      out.write("\t\t\t\t    \t$('#fom_join').submit();\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t//$('#result2').html('노확인 ');\r\n");
      out.write("\t\t\t\t\t\t$('#result2').html('아이디나 패스워드길이를 확인해주세요. ');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t    \r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t $('#result2').html('패스워드를 다시 한번 확인해주세요.');\r\n");
      out.write("\t\t\t\t\t$('#result2').css('color', 'red'); \r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
