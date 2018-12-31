package com.mtc.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtc.app.dao.IProductDAO;
import com.mtc.app.dao.ProductDAO;
import com.mtc.app.vo.Product;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IProductDAO productDAO; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
	public void init() throws ServletException {
		
		productDAO = new ProductDAO();
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productid = Integer.parseInt(request.getParameter("pid"));
		
		Product product = productDAO.findById(productid);
		
		//adding product object to the request scope, the name given "prodcut is used in the jsp page
		request.setAttribute("product", product); 
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("search.jsp");
		
		//calling the jsp
		requestDispatcher.forward(request, response);
		
		
		
	}

	
	

}
