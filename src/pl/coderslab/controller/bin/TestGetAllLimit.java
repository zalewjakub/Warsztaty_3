package pl.coderslab.controller.bin;

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
 * Servlet implementation class TestGetAll
 */
@WebServlet("/TestGetAll")
public class TestGetAllLimit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestGetAllLimit() {
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
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/loadAllLimit.jsp").forward(request, response);
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
		request.setAttribute("user", user);
		int limit = 0;
		String limitParameter = request.getParameter("limit");
		ArrayList<String> allData = new ArrayList<>();
		if (validate(limitParameter)) {
			try {
				limit = Integer.parseInt(limitParameter);
				allData = user.loadWithLimit(limit);
			} catch (Exception e) {
				System.out.println(e);
			}
			request.setAttribute("allData", allData);
			request.setAttribute("size", (user.getFieldsWithId().length));
			request.setAttribute("limit", limit);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/loadAllLimit.jsp").forward(request, response);
		} else {
			response.sendRedirect("TestGetById?message=Podaj Id");
		}

	}

}
