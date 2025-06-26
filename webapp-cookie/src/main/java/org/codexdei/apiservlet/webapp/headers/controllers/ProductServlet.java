package org.codexdei.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codexdei.apiservlet.webapp.headers.models.Product;
import org.codexdei.apiservlet.webapp.headers.services.ProductService;
import org.codexdei.apiservlet.webapp.headers.services.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/products.html", "/products"})
public class ProductServlet extends HttpServlet {

    ProductService productService = new ProductServiceImpl();
    List<Product> productList = productService.listProduct();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("       <title>Products List</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Products List!</h1>");
            out.println("       <p><a href=\"" + req.getContextPath() + "/products.xls" + "\">Export to</a></p>");
            out.println("           <table>");
            out.println("               <tr>");
            out.println("                    <th>Id</th>");
            out.println("                    <th>Name</th>");
            out.println("                    <th>Type</th>");
            out.println("                    <th>Price</th>");
            out.println("               </tr>");
            productList.forEach(p -> {
                out.println("               <tr>");
                out.println("                    <td>" + p.getId() + "</td>");
                out.println("                    <td>" + p.getName() + "</td>");
                out.println("                    <td>" + p.getType() + "</td>");
                out.println("                    <td>" + p.getPrice() + "</td>");
                out.println("                   </tr>");
            });
            out.println("           </table>");
        }
    }
}
