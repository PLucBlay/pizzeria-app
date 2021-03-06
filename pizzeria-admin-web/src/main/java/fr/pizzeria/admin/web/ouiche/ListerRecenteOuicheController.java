package fr.pizzeria.admin.web.ouiche;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.IngredientService;
import fr.pizzeria.admin.metier.OuicheService;
import fr.pizzeria.model.Pizza;

/**
 * Contrôleur de la page Liste des pizzas.
 */
@WebServlet("/ouiches/liste")
public class ListerRecenteOuicheController extends HttpServlet {

	private static final String VUE_LISTER_OUICHES = "/WEB-INF/views/ouiches/listerOuiches.jsp";
	
	@Inject
	private OuicheService ouicheService;

	@Inject
	private IngredientService ingredientService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setAttribute("listePizzas", this.ouicheService.findNewestPizzaByName());	    
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(VUE_LISTER_OUICHES);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		Integer id = Integer.valueOf(request.getParameter("id"));

		Pizza editerPizza = this.ouicheService.findById(id);

		editerPizza.setArchive(!editerPizza.getArchive());

		this.ouicheService.update(id, editerPizza);

		response.sendRedirect(request.getContextPath() + "/ouiches/liste");

	}

}