package it.xpug.supermarket.main;


import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class SupermarketServlet extends HttpServlet {

	private SupermarketCheckout checkout;

	public SupermarketServlet() {
		PriceList priceList = new PriceList("price_list.properties");
		checkout = new SupermarketCheckout(priceList);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SupermarketController controller = new SupermarketController(checkout, request, response);
		controller.service();
	}
}
