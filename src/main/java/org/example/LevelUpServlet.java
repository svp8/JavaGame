package org.example;

import java.io.IOException;

import org.example.models.MonsterFactory;
import org.example.models.Player;
import org.example.models.defence.Shield;
import org.example.models.weapons.Hammer;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LevelUpServlet
 */
@WebServlet("/levelup")
public class LevelUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LevelUpServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Player player=(Player) session.getAttribute("player");
		
		getServletContext().getRequestDispatcher("/levelUp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String button=(String) request.getParameter("button");
		HttpSession session = request.getSession();
		Player player=(Player) session.getAttribute("player");
		player.setLevel(player.getLevel()+1);
		int level=player.getLevel();
		switch(button) {
		case "Health":
			player.setMaxHealth(player.getMaxHealth()+5*level);
			break;
		case "Attack":
			player.setAttack(player.getAttack()+5*level);
			break;
		case "Defence":
			player.setDefence(new Shield(level*5));
			break;
		case "Weapon":
			player.setWeapon(new Hammer(3*level,7*level));
			break;
		}
		session.setAttribute("monster", new MonsterFactory().getMonster(level));
		if(session.getAttribute("monster")==null) {
			getServletContext().getRequestDispatcher("/win.jsp").forward(request, response);
			return;
		}
		response.sendRedirect("http://localhost:8080/game/main");
	}

}
