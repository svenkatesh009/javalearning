![image](https://github.com/user-attachments/assets/3db794a8-04d1-4949-97da-37d7ae34db1a)
![image](https://github.com/user-attachments/assets/4b74fee3-4b3c-43ef-8fc7-22f3ea16f3fd)

In demoApp we can do some modifcations:
The app consists of & methods we implemented two mwthods :
1)doGet - it is a deafult method
2)doPost - it is only used to post , in url we can see only the required page of url not the parameters but not in doget.

We can transfer the req and respond to the another servlet using the REQUESTDISPATCHER and SENDREDIRECT.
Requestdispatcher does not notify the server that you are getting response from the another servlet 
syntax:
RequestDispatcher rs=req.getRequestDispatcher("sq");
rs.forward(req,res);
But the sendredirect notifies the client that you are redirected to the another servlet.
syntax:
res.sendRedirect("sq");

After this The web.xml file is also known as the Deployment Descriptor (DD) in Java-based web applications. It is an XML file used in Java EE (Jakarta EE) applications to configure servlets, filters, listeners, and other settings related to web applications deployed on a servlet container like Apache Tomcat, JBoss, or GlassFish.

Here what we will do is adding the :
servlet and servlet-mapping
 <servlet>
	 <servlet-name>abc</servlet-name>
	 <servlet-class>com.practice.AddServelet</servlet-class>
 </servlet> 
 
 <servlet-mapping>
 	 <servlet-name>abc</servlet-name>
 	 <url-pattern>/add</url-pattern>
 </servlet-mapping>
 
  <servlet>
	 <servlet-name>def</servlet-name>
	 <servlet-class>com.practice.SqServlet</servlet-class>
 </servlet> 
 
 <servlet-mapping>
 	 <servlet-name>def</servlet-name>
 	 <url-pattern>/sq</url-pattern>
 </servlet-mapping>

Urlrewriter:
in url rewriter we specify the parameter without setting the attribute.
res.sendRedirect("sq?k="+k);


HTTPsession(Session management):
HttpSession hp=req.getSession();
hp.setAttribute("k",k);

res.sendRedirect("sq");

Cookies:
In servlet side:
   A side:
   		Cookie cookie = new Cookie("k", k +I"");
		res.addCookie(cookie);
		res.sendRedirect("sq");
   B sdie:
	       int k = 0;
		Cookie cookies= req.getCookies();
		for(Cookie c : cookies)
		{
		if(c.getName().equals("k"))
		k = Integer.parseInt(c.getValue())};
		}

Servlet config & Servletcontext:

Servlet config:
1. Define Initialization Parameters in web.xml
xml
Copy
Edit
<servlet>
    <servlet-name>MyServlet</servlet-name>
    <servlet-class>com.example.MyServlet</servlet-class>
    <init-param>
        <param-name>databaseURL</param-name>
        <param-value>jdbc:mysql://localhost:3306/mydb</param-value>
    </init-param>
    <init-param>
        <param-name>username</param-name>
        <param-value>admin</param-value>
    </init-param>
</servlet>
2. Access ServletConfig in Java Servlet
java
Copy
Edit
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
    private String dbURL;
    private String dbUser;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dbURL = config.getInitParameter("databaseURL");
        dbUser = config.getInitParameter("username");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h3>Database URL: " + dbURL + "</h3>");
        out.println("<h3>Username: " + dbUser + "</h3>");
        out.println("</body></html>");
    }
}

Servlet context:
1. Define Context Parameters in web.xml
xml
Copy
Edit
<context-param>
    <param-name>databaseURL</param-name>
    <param-value>jdbc:mysql://localhost:3306/mydb</param-value>
</context-param>

<context-param>
    <param-name>username</param-name>
    <param-value>admin</param-value>
</context-param>
2. Access Context Parameters in a Servlet
java
Copy
Edit
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
    private String dbURL;
    private String dbUser;

    public void init() throws ServletException {
        ServletContext context = getServletContext();
        dbURL = context.getInitParameter("databaseURL");
        dbUser = context.getInitParameter("username");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h3>Database URL: " + dbURL + "</h3>");
        out.println("<h3>Username: " + dbUser + "</h3>");
        out.println("</body></html>");
    }
}
