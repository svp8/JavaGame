package org.example;

import java.io.IOException;

import org.example.models.Entity;
import org.example.models.EventRegistry;
import org.example.models.Monster;
import org.example.models.MonsterFactory;
import org.example.models.Player;
import org.example.models.defence.Shield;
import org.example.models.statuses.StunnedStatus;
import org.example.models.weapons.Hammer;
import org.example.models.weapons.Hands;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //request.setAttribute("name", "Tom");
	       // request.setAttribute("age", 34);
		HttpSession session = request.getSession();
		if(session.getAttribute("gameStatus")==null) {
			session.setAttribute("gameStatus", "start");
			Player player=new Player(new Hands(1,5),new Shield(4),20,10);
			session.setAttribute("monster", new MonsterFactory().getMonster(1));
			session.setAttribute("player",player);
			
		}
		session.setAttribute("registry", EventRegistry.getInstance().getEvents());
	        getServletContext().getRequestDispatcher("/Main.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();

		String button=(String) request.getParameter("button");
		System.out.println(button);
		Player player=(Player) session.getAttribute("player");
		Monster monster=(Monster) session.getAttribute("monster");
		
		
		player.applyStatuses();
		switch(button) {
		
		case "attack":
			player.fight(monster);
			break;

		case "heal":
			player.heal();
			break;

		case "start":
			
			break;
		}
		monster.applyStatuses();
		monster.fight(player);
		if(player.getHealth()<=0) {
			getServletContext().getRequestDispatcher("/gameOver.jsp").forward(request, response);
			return;
		}
		if(monster.getHealth()<=0) {
			response.sendRedirect("http://localhost:8080/game/levelup");
			return;
		}
		
		doGet(request, response);
	}

}
