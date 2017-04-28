package fr.pizzeria.admin.web.promotion;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PromotionService;

@WebServlet("/promotions/list")
public class ListerPromotionController extends HttpServlet {
	
	private static final String VUE_LISTER_PROMOTIONS = "/WEB-INF/views/promotions/listerPromotions.jsp";

	@Inject private PromotionService promotionService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("promotions", promotionService.findAll());
		this.getServletContext().getRequestDispatcher(VUE_LISTER_PROMOTIONS).forward(request, response);
	}

}