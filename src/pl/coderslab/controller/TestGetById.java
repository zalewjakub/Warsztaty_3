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
 * Servlet implementation class TestGetById
 */
@WebServlet("/TestGetById")
public class TestGetById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestGetById() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActiveRecord user = new User();
		request.setAttribute("user", user);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(request, response);
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
		ActiveRecord user = new User();
		String idParameter = request.getParameter("id");
		ArrayList<String> searchingUser = new ArrayList<>();
		if (validate(idParameter)) {
			try {
				int id = Integer.parseInt(idParameter);
				user.getById(id);
				for (String key : user.getFields()) {
					searchingUser.add(user.getValue(key));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			request.setAttribute("user", user);
			request.setAttribute("finded", searchingUser);
			request.setAttribute("size", (searchingUser.size() / user.getTableName().length()));
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(request, response);
		} else {
			response.sendRedirect("TestGetById?message=Podaj Id");
		}

	}

}
