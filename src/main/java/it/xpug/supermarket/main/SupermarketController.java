package it.xpug.supermarket.main;

import static java.lang.String.*;

import java.io.*;

import javax.servlet.http.*;

public class SupermarketController {

	private SupermarketCheckout checkout;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public SupermarketController(SupermarketCheckout checkout,
			HttpServletRequest request, HttpServletResponse response) {
		this.checkout = checkout;
		this.request = request;
		this.response = response;
	}

	public void service() throws IOException {
		response.setContentType("application/json");
		if (request.getRequestURI().equals("/scan")) {
			doScan();
		} else if (request.getRequestURI().equals("/total")) {
			doTotal();
		} else {
			do404();
		}
	}

	private void do404() throws IOException {
		response.setStatus(404);
		writeBody(toJson("description", "Not Found"));
	}

	private void doTotal() throws IOException {
		int total = checkout.total();
		writeBody(toJson("total", total));
	}

	private String toJson(String name, String value) {
		return format("{ \"%s\": \"%s\" }", name, value);
	}

	private String toJson(String name, int value) {
		return format("{ \"%s\": %s }", name, value);
	}

	private void doScan() throws IOException {
		try {
			int price = checkout.scan(request.getParameter("code"));
			writeBody(format("{ \"price\": %s }", price));
		} catch (PriceNotFound e) {
			response.setStatus(400);
			writeBody("{ \"description\": \"Price not found\" }");
		}
	}

	private void writeBody(String body) throws IOException {
		response.getWriter().write(body);
	}


}
