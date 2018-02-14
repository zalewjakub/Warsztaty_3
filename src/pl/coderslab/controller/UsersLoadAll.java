package pl.coderslab.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.ActiveRecord;
import pl.coderslab.model.User;

/**
 * Servlet implementation class users
 */
@WebServlet("/LoadUsers")
public class UsersLoadAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersLoadAll() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActiveRecord user = new User(true);
		request.setAttribute("user", user);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/Users.jsp").forward(request, response);
	}

	public boolean validate(String text) {
		return text != null && !"".equals(text);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActiveRecord user = new User(true);
		int limit = 0;
		request.setAttribute("user", user);
		ArrayList<String> allData = new ArrayList<>();
		String limitParameter = request.getParameter("limit");
		if (validate(limitParameter)) {
			try {
				limit = Integer.parseInt(limitParameter);
				if (limit>0) {				
				allData = user.loadWithLimit(limit);
				request.setAttribute("allData", allData);
				request.setAttribute("size", (user.getFieldsWithId().length));
				request.setAttribute("limit", limit);	
				}
			} catch (Exception e) {
				System.out.println(e);
			}		
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/Users.jsp").forward(request, response);
		}else {
			try {
				allData = user.loadAllResult();
			} catch (Exception e) {
				System.out.println(e);
			}
			limit = user.getcountRecord();
			request.setAttribute("allData", allData);
			request.setAttribute("size", (user.getFieldsWithId().length));
			request.setAttribute("limit", limit);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/Users.jsp").forward(request, response);
		}
	}

}
