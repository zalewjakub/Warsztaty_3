package pl.coderslab.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.ActiveRecord;
import pl.coderslab.model.Exercise;

/**
 * Servlet implementation class SolutionInfo
 */
@WebServlet("/SolutionInfo")
public class SolutionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SolutionInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActiveRecord exercise = new Exercise();
		String idParameter = request.getParameter("id");
		ArrayList<String> searchingExercise = new ArrayList<>();
		try {
			int id = Integer.parseInt(idParameter);
			exercise.getById(id);
			for (String key : exercise.getFields()) {
				searchingExercise.add(exercise.getValue(key));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		request.setAttribute("id", idParameter);
		request.setAttribute("user", exercise);
		request.setAttribute("finded", searchingExercise);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/solutionInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
