package com.mtc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtc.app.dao.IProductDAO;
import com.mtc.app.dao.ProductDAO;
import com.mtc.app.vo.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	private IProductDAO productDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		productDAO = new ProductDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> products = productDAO.findAll();
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		
		out.println("<h2 align=center>Product Records</h2>");
		
		out.println("<table align=center border=2>");
		
		out.println("<tr><th>ProductId</th><th>Name</th><th>Price</th><th>Quantity</th><th>Description</th></tr>");
		
		for (Product product : products) {
			out.println("<tr>");
				out.println("<td>"+product.getId()+"</td>");
				out.println("<td>"+product.getName()+"</td>");
				out.println("<td>"+product.getPrice()+"</td>");
				out.println("<td>"+product.getQuantity()+"</td>");
				out.println("<td>"+product.getDescription()+"</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
	
		out.println("</body></html>");
	
	}

}
