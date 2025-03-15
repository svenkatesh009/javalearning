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
