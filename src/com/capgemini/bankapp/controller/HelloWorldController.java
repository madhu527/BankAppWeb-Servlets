/*
 * package com.capgemini.bankapp.controller;
 * 
 * import java.io.IOException; import java.io.PrintWriter;
 * 
 * import javax.security.auth.message.callback.PrivateKeyCallback.Request;
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import sun.rmi.server.Dispatcher;
 * 
 * @WebServlet(name = "helloworld",loadOnStartup= 1,urlPatterns = {"/hello",
 * "/helloworld","/login"}) public class HelloWorldController extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 * 
 * public HelloWorldController() { super();
 * 
 * }
 * 
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * response.setContentType("text/html"); System.out.println("Hello world");
 * 
 * PrintWriter out = response.getWriter(); out.println("Hello world");
 * 
 * out.close(); }
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { String
 * username=request.getParameter("username"); String
 * password=request.getParameter("password");
 * response.setContentType("text/html"); RequestDispatcher dispacher=null;
 * 
 * if(username.equals("root") && password.equals("root@123")) { dispacher =
 * request.getRequestDispatcher("successhtml");
 * 
 * out.println("<h2> Login..."+username+"</h2>"); } else { dispacher =
 * request.getRequestDispatcher("success.html"); } dispacher =
 * forwardrequest.getRequestDispatcher("error.html");
 * //out.println("<h2> invalid username and password</h2>"); //out.close(); }
 * Dispatcher()
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 */