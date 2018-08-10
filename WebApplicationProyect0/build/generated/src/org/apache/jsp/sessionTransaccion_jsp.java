package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sessionTransaccion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <title>SALDO</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link  rel=\"stylesheet\" href=\"CSS/bootstrap.min.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jQuery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("            <br>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <ul class=\"nav nav-tabs\">\n");
      out.write("                            <li><a href=\"inicio.php\">Inicio</a></li>\n");
      out.write("                            <li><a href=\"saldo.php\">Saldo</a></li>\n");
      out.write("                            <li><a href=\"movimientos.php\">Movimientos</a></li>\n");
      out.write("                            <li class=\"active\"><a href=\"#\">Operaciones</a></li>\n");
      out.write("                            <li><a href=\"salir.php\">salir</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <form class=\"form-horizontal\" action=\"FormOperaciones.php\" method=\"POST\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"control-label col-sm-2 col-md-1\">Operacion</label>\n");
      out.write("                        <div class=\"col-sm-4 col-md-3\">\n");
      out.write("                            <select class=\"form-control\" name=\"operacion\">\n");
      out.write("                                <option>Deposito</option>\n");
      out.write("                                <option>Retiro</option>\n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"control-label col-sm-2 col-md-1\">Monto</label>\n");
      out.write("                        <div class=\"col-sm-4 col-md-3\"> \n");
      out.write("                            <input class=\"form-control\" placeholder=\"Monto\" type=\"number\" name=\"monto\" required>\n");
      out.write("                        </div>                          \n");
      out.write("                    </div> \n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-xs-4 col-sm-2 col-md-1 col-xs-offset-1 col-sm-2 col-md-1\">\n");
      out.write("                                <input class=\"btn btn-warning\" type=\"reset\" value=\"Limpiar\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-xs-6 col-sm-2 col-md-1\">\n");
      out.write("                                <input class=\"btn btn-success\" type=\"submit\" value=\"Realizar\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
