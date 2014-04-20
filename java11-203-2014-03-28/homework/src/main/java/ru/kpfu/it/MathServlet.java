package ru.kpfu.it;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ayrat on 31.03.2014.
 */
public class MathServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oper = request.getParameter("oper");
        String arg1 = request.getParameter("arg1");
        String arg2 = request.getParameter("arg2");
        PrintWriter out = null;
        try {
            response.setContentType("text/html");
            out = response.getWriter();
            out.println("<html>\n" +
                    "<head>\n" +
                    "    <title>Math</title>\n" +
                    "    <meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\" />\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "   <h1>");
            String err;
            if ((err = Validator.getError(oper, arg1, arg2)) != null) {
                out.println(err);
            }else{
                Double darg1 = Double.parseDouble(arg1);
                Double result  = null;
                if(Validator.getNumberOfArgs(oper)==1) {
                    switch (oper) {
                        case "sin":
                            result = Math.sin(darg1);
                            break;
                        case "cos":
                            result = Math.cos(darg1);
                            break;
                        case "ln":
                            result = Math.log(darg1);
                            break;
                        case "exp":
                            result = Math.exp(darg1);
                            break;
                    }
                } else {
                    Double darg2 = Double.parseDouble(arg2);
                    switch (oper) {
                        case "add":
                            result = darg1 + darg2;
                            break;
                        case "sub":
                            result = darg1 - darg2;
                            break;
                        case "mult":
                            result = darg1 * darg2;
                            break;
                        case "div":
                            result = darg1 / darg2;
                            break;
                    }
                }
                out.println("Result: " + result);
            }

            out.println("   </h1>" +
                    "</body>\n" +
                    "</html>");
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            try{
                if(out != null){
                    out.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
