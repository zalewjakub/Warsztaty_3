package pl.coderslab.controller.bin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.ActiveRecord;
import pl.coderslab.model.User;

/**
 * Servlet implementation class TestUserDelete
 */
@WebServlet("/TestUserDelete")
public class TestUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestUserDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/deleteData.jsp").forward(request, response);
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
		String idParameter = request.getParameter("id");
		ActiveRecord user = new User();
		if (validate(idParameter)) {
			try {
				int id = Integer.parseInt(idParameter);
				if (id>0) {
				user.delete(id);
				response.sendRedirect("TestUserDelete?message=Usunieto rekord");
				}
			} catch (Exception e) {
				System.out.println(e);
				response.sendRedirect("TestUserDelete?message=Podaj prawidlowe Id");
			}
			
		} else {
			response.sendRedirect("TestUserDelete?message=Podaj prawidlowe Id");
		}

	}
}
