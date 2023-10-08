package org.example;

import java.io.IOException;

import org.example.models.EventRegistry;
import org.example.models.MonsterFactory;
import org.example.models.Player;
import org.example.models.defence.Shield;
import org.example.models.weapons.Hands;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class StartServlet
 */
@WebServlet("/start")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StartServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("gameStatus", "start");
		Player player=new Player(new Hands(1,5),new Shield(4),20,10);
		MonsterFactory factory= new MonsterFactory();
		session.setAttribute("monsterFactory", factory);
		session.setAttribute("monster", factory.getMonster(1));
		session.setAttribute("player",player);
		EventRegistry.getInstance().clearRegistry();
		session.setAttribute("registry", EventRegistry.getInstance().getEvents());
		 response.sendRedirect("http://localhost:8080/game/main");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
