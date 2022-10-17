
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
        HttpSession session = request.getSession();
        ArrayList<String> items = (ArrayList) request.getAttribute("items");
        String action = request.getParameter("action");
        
        if(action != null && action.equals("Logout")) {
                request.getSession().invalidate();
                request.setAttribute("username", null);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                
        } else if (action != null && action.equals("Register")) {
            User user = new User(request.getParameter("username"));
            items = new ArrayList<>();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            
        } else if (action != null && action.equals("Add")) {
           String item = request.getParameter("item");
           items = (ArrayList<String>) request.getSession().getAttribute("items");
              if(items != null) {
              items.add(item);
              } else {
                  items = new ArrayList<>();
                  items.add(item);
              }
              request.getSession().setAttribute("items", items);
           
           getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else if (action.equals("Delete")) {
            String item = request.getParameter("item");
            items = (ArrayList) request.getSession().getAttribute("items"); 
            items.remove(item);
            request.getSession().setAttribute("items", items);
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
