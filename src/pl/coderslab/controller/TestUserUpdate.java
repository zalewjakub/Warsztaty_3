package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.ActiveRecord;
import pl.coderslab.model.User;

/**
 * Servlet implementation class TestUserUpdate
 */
@WebServlet("/TestUserUpdate")
public class TestUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestUserUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean validate(String text) {
		return text != null && !"".equals(text);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequestużytkownika request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActiveRecord user = new User();
		request.setAttribute("user", user);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/updateUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String update = "";
		ActiveRecord user = new User();
		String idParameter = request.getParameter("id");
		if (validate(idParameter)) {
			try {
				int id = Integer.parseInt(idParameter);
				for (String name : user.getFields()) {
					if (validate(request.getParameter(name))) {
						user.setValue(name, request.getParameter(name));
						System.out.println("\"");
						update += name + "=" + "\"" + request.getParameter(name) + "\""  + ",";
					}
					// user.save();
				}
				user.update(update.substring(0,update.length()-1),id);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
