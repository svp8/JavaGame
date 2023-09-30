package org.example;

import java.io.IOException;

import org.example.models.Entity;
import org.example.models.Monster;
import org.example.models.Player;
import org.example.models.defence.Shield;
import org.example.models.statuses.StunnedStatus;
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
@WebServlet("/MainServlet")
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
			player.addStatus(new StunnedStatus(2));
			Monster monster=new Monster(new Hands(1,5),new Shield(4),5,10);
			session.setAttribute("player",player);
			session.setAttribute("monster",monster);
			
		}
		
		

	        getServletContext().getRequestDispatcher("/Main.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();

		 System.out.println(session.getAttribute("player"));
		if(session.getAttribute("age")!=null) {
			int j=(int)session.getAttribute("age");
			j++;
			System.out.println(j);
			session.setAttribute("age",j);
			
		}else session.setAttribute("age", 34);
			
		//request.setAttribute("age",(int)request.getAttribute("age")+1);
		doGet(request, response);
	}

}
