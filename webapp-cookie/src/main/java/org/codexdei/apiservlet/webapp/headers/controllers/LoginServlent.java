package org.codexdei.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

@WebServlet({"/login", "/login.html"})
public class LoginServlent extends HttpServlet {

    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //obteniendo la cookie
        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];

        Optional<String> optionalCookie = Arrays.stream(cookies)
                        .filter(c -> "username".equals(c.getName()))
                //transformamos de Cookie a String
                        .map(Cookie::getValue)
                        .findAny();
        if (optionalCookie.isPresent()){

            resp.setContentType("text/html;charset=UTF-8");

            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("       <title>Welcome " + optionalCookie.get() + "!</title>");
                out.println("   </head>");
                out.println("   <body>");
                out.println("       <h1>Welcome " + optionalCookie.get() + " whether previously logged in!!</h1>");
                out.println("   </body>");
                out.println("</html>");
            }

        }else {

            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        if (USERNAME.equals(username) && PASSWORD.equals(password)){

            //Creacion de una cookie,
            //es un map, como valor se coloca la variable que contiene el parametro del req
            Cookie usernameCookie = new Cookie("username", username);
            resp.addCookie(usernameCookie);

            resp.setContentType("text/html;charset=UTF-8");

            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("       <title>Login Successful</title>");
                out.println("   </head>");
                out.println("   <body>");
                out.println("       <h1>Login Successful!</h1>");
                out.println("<h2> Login successful for '" + username + "' </h2>");
                out.println("   </body>");
                out.println("</html>");
            }
            
        }else {

            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        "Access denied, You are not authorized to view this web page");
        }


    }
}
