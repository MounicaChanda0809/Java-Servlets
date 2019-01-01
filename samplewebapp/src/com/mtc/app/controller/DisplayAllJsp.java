package com.mtc.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ProductsServletJSP
 */
@WebServlet("/display")
public class DisplayAllJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    
	private IProductDAO productDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllJsp() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
	public void init(ServletConfig config) throws ServletException {
		
		productDAO = new ProductDAO();
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> products = productDAO.findAll();
		
		
			
			//adding product object to the request scope, the name given "product is used in the jsp page
			request.setAttribute("products", products); 
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("products.jsp");
			
			//calling the jsp
			requestDispatcher.forward(request, response);
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
