// To save as "<CATALINA_HOME>\webapps\helloservlet\WEB-INF\src\mypkg\EchoServlet.java"
package mypkg;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
 
public class gestioneAppuntamenti extends HttpServlet {
 
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html; charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
 
      // Write the response message, in an HTML page
      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Echo Servlet</title></head>");
         out.println("<body><h2>Hai inserito</h2>");
 
         // Retrieve the value of the query parameter "username" (from text field)
         String username = request.getParameter("username");
         // Get null if the parameter is missing from query string.
         // Get empty string or string of white spaces if user did not fill in
         if (username == null
               || (username = htmlFilter(username.trim())).length() == 0) {
            out.println("<p>Cognome: MANCANTE</p>");
         } else {
            out.println("<p>Benvenuto" + username + " ! </p>");
         }
 
         // Retrieve the value of the query parameter "password" (from password field)
         
 
         // Retrieve the value of the query parameter "secret" (from hidden field)
         
 
         // Get all the names of request parameters
         
 
         // Hyperlink "BACK" to input page
         out.println("<a href='form1.html'>BACK</a>");
 
         out.println("</body></html>");
      } finally {
         out.close();  // Always close the output writer
      }
   }
 
   // Redirect POST request to GET request.
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      doGet(request, response);
   }
 
   // Filter the string for special HTML characters to prevent
   // command injection attack
   private static String htmlFilter(String message) {
      if (message == null) return null;
      int len = message.length();
      StringBuffer result = new StringBuffer(len + 20);
      char aChar;
 
      for (int i = 0; i < len; ++i) {
         aChar = message.charAt(i);
         switch (aChar) {
             case '<': result.append("&lt;"); break;
             case '>': result.append("&gt;"); break;
             case '&': result.append("&amp;"); break;
             case '"': result.append("&quot;"); break;
             default: result.append(aChar);
         }
      }
      return (result.toString());
   }
}