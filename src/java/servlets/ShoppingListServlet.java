
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author kurtm
 */
public class ShoppingListServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        if(username == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String action = request.getParameter("action");
        if(action != null && action.equals("Logout")) {
                request.getSession().invalidate();
                request.setAttribute("username", null);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                
        } else if (action != null && action.equals("Register")) {
            HttpSession session = request.getSession();
            User user = new User(request.getParameter("username"));
            ArrayList<String> items = new ArrayList<>();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            
        } else if (action != null && action.equals("Add")) {
           String item = request.getParameter("item");
           if(request.getAttribute("items") == null) {
              ArrayList<String> items = new ArrayList<>();
              items.add(item);
              request.setAttribute("items", items);
           } else {
              ArrayList<String> items = (ArrayList) request.getAttribute("items");
              items.add(item);
              request.setAttribute("items", items);
           }
           getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        
        
        
    }

    public class User {
        private String username;
        public User(String username) {
            this.username = username;
        }
        public String getUsername() {
            return this.username;
        }
    }
}
