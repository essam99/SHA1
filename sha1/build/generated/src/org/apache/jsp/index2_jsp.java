package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import mainPackage.sha1;

public final class index2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("      <head>\n");
      out.write("    <title>Digital Signature SHA-1</title>  \n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("    <meta name=\"author\" content=\"colorlib.com\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Poppins:400,500,700\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"css/main.css\" rel=\"stylesheet\" />\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    \n");
      out.write("    ");
 sha1 sha = new sha1(); 
      out.write("\n");
      out.write("    <div class=\"s013\">\n");
      out.write("      <form action=\"\" method=\"post\">\n");
      out.write("        <fieldset>\n");
      out.write("          <legend>DIGITAL SIGNATURE SHA-1</legend>\n");
      out.write("        </fieldset>\n");
      out.write("        <div class=\"inner-form\">\n");
      out.write("          <div class=\"left\">\n");
      out.write("            <div class=\"input-wrap first\">\n");
      out.write("              <div class=\"input-field first\">\n");
      out.write("                <label>TEXT</label>\n");
      out.write("                <input type=\"text\" name=\"txt\" placeholder=\"ex: Hello World\" />\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <input type=\"submit\" class=\"btn-search\" value=\"CONVERT\">            \n");
      out.write("        </div>\n");
      out.write("          ");
 if(request.getParameter("txt") != ""){
      out.write("\n");
      out.write("          <br />\n");
      out.write("            <div class=\"inner-form\">\n");
      out.write("                <div class=\"input-wrap\" style=\"width:100%;background: #dff2e4\">\n");
      out.write("                    <div class=\"input-field\">\n");
      out.write("                      <label>CONVERTED TEXT</label>\n");
      out.write("<textarea name=\"txt\" style=\"margin-top:12px;resize: none;border:0;width:100%;background:transparent;font-size:12pt;color:#333;\" disabled>\n");
out.print(sha.get_SHA1(request.getParameter("txt")));
      out.write("\n");
      out.write("</textarea>\n");
      out.write("                    </div>\n");
      out.write("                </div> \n");
      out.write("            </div>\n");
 }
      out.write("\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
