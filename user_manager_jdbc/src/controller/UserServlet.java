package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDao;

    public void init(){
        userDao = new UserDAO();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try{
            switch (action){
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "find":
                    find_By_Country(request, response);
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try{
            switch (action){
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "find":
                    showUsersByCountry(request, response);
                    break;
                case "sort":
                    sort(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
        throws  SQLException, IOException,ServletException{
        List<User> listUser = userDao.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws  SQLException, IOException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDao.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request,response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws  SQLException, IOException,ServletException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        userDao.insertUser(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws  SQLException, IOException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User book = new User(id, name, email, country);
        userDao.updateUser(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws  SQLException, IOException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.deleteUser(id);
        List<User> listUser = userDao.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void sort(HttpServletRequest request, HttpServletResponse response)
            throws  SQLException, IOException,ServletException{

        List<User> listUser = userDao.sortByName();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showUsersByCountry(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/listUsersByCountry.jsp");
        dispatcher.forward(request, response);
    }
    private void find_By_Country(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        String country = request.getParameter("findByCountry");
        List<User> listUser = userDao.selectUsersByCountry(country);
        request.setAttribute("listUserByCountry", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/listUsersByCountry.jsp");
        dispatcher.forward(request, response);
    }
}
