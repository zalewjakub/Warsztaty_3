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
 * Servlet implementation class TestUser
 */
@WebServlet("/testuser")
public class TestUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestUser() {
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
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/form.jsp").forward(request, response);

		// user.getById(6);
		// for (String key : user.getFields()) {
		// response.getWriter().append(key + ":" + user.getValue(key) + "<br>");
		// }
		// user.setValue("email", "jan.kowalski@gmail.com");
		// for (String key : user.getFields()) {
		// response.getWriter().append(key + ":" + user.getValue(key) + "<br>");
		// }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public boolean validate(String text) {
		return text != null && !"".equals(text);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActiveRecord user = new User();
		int count = 0;
		for (String name : user.getFields()) {
			if (validate(request.getParameter(name))) {
				count++;
				user.setValue(name, request.getParameter(name));
			} else {				
				break;
			}
		}	
		if (count < user.getFields().length) {
			response.sendRedirect("testuser?message=Wypelnij wszystkie pola");
		}else {
			user.save(0,"");// powinna zwracać id
			response.sendRedirect("testuser?message=Dodano!!!");
			// doGet()	
		}

	}

}
