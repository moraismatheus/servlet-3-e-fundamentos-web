package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {
	
	private final Cookie cookie;
	
	public Cookies(Cookie[] cookies) {
		this.cookie = getCookies(cookies);
	}
	
	private Cookie getCookies(Cookie[] cookies) {
		if(cookies == null) return null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				return cookie;
			}
		}
		return null;
	};
	
	public Cookie getCookie() {
		return this.cookie;
	}
}
