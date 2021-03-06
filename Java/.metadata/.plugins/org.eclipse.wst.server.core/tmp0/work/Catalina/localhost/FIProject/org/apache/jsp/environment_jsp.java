/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-10-18 13:38:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import FirmProjectPackage.*;
import java.util.*;

public final class environment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"css/bootstrap.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Environments</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<br>\r\n");
      out.write("<center>\r\n");
      out.write("<h1>Environments</h1>\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");

ApplicationsDAO dao = new ApplicationsDAO();


//controller
String action = request.getParameter("action");
String name = request.getParameter("name");
String url = request.getParameter("url");
String id = request.getParameter("id");
Environment env = new Environment();


if("create".equals(action)){
	Environment en = new Environment(name, url);
	dao.create(en);
}else if("remove".equals(action)){
	int idInt = Integer.parseInt(id);
	dao.remove(idInt);
}else if("select".equals(action)){
	int idInt = Integer.parseInt(id);
	env = dao.selectOne(idInt);
}else if("update".equals(action))
{
	int idInt = Integer.parseInt(id);
	env = new Environment(name, url);
	dao.update(idInt, env);
}


List<Environment> environments = dao.selectAll();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<form action=\"environment.jsp\">\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" name=\"id\" value=\"");
      out.print( env.getId() );
      out.write("\"/>\r\n");
      out.write("\r\n");
      out.write("<table class=\"table\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Name <input name=\"name\" class=\"form-control\" value=");
      out.print( env.getName() );
      out.write("/></td>\r\n");
      out.write("<td>URL <input name=\"url\" class =\"form-control\" value=");
      out.print( env.getUrl() );
      out.write("/></td>\r\n");
      out.write("<td>\r\n");
      out.write("<button class=\"btn\" name=\"action\" value=\"create\">\r\n");
      out.write("Add\r\n");
      out.write("</button>\r\n");
      out.write("<button class=\"btn\" name=\"action\" value=\"update\">\r\n");
      out.write("update\r\n");
      out.write("</button>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
 for(Environment en: environments){
	
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td>");
      out.print(en.getName() );
      out.write("</td>\r\n");
      out.write("\t<td>");
      out.print(en.getUrl() );
      out.write("</td>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<a href=\"environment.jsp?action=remove&id=");
      out.print( en.getId() );
      out.write("\">\r\n");
      out.write("\tDelete\r\n");
      out.write("\t</a>\r\n");
      out.write("\t\r\n");
      out.write("\t<a href=\"environment.jsp?action=select&id=");
      out.print(en.getId() );
      out.write("\">\r\n");
      out.write("\tSelect\r\n");
      out.write("\t</a>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

}
	
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
