package com.humanbooster.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.humanbooster.model.User;
import com.humanbooster.util.DAO;
import com.humanbooster.util.DataConnect;

public class UserService implements DAO<User, Integer>{

	private Connection connection;

	public UserService() {
		try {
			this.connection = DataConnect.getConnexion();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<User> getAll() throws SQLException {
		
		List<User> userList = new ArrayList<User>();

		String query = "SELECT * FROM user;";
		PreparedStatement prepareStatement = this.connection.prepareStatement(query);
		ResultSet resultSet = prepareStatement.executeQuery();

		while (resultSet.next()) {
			
			int user_id = resultSet.getInt("user_id");
			String login = resultSet.getString("login");
			String password = resultSet.getString("password");
			Boolean isAdmin = resultSet.getBoolean("isAdmin");
			String profilePicture = resultSet.getString("profilePicture");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			Date hireDate = resultSet.getDate("hireDate");
			String phoneNumber = resultSet.getString("phoneNumber");
			
			User user = new User(user_id, login, password, isAdmin, profilePicture, firstName, lastName, hireDate, phoneNumber);
			
			userList.add(user);
		}

		resultSet.close();
		prepareStatement.close();

		return userList;
	}

	@Override
	public User getById(Integer id) throws SQLException {
		
		User user = null;

        String query = "SELECT * FROM user WHERE user_id = ? ;";
        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        prepareStatement.setInt(1, id);

        ResultSet resultSet = prepareStatement.executeQuery();

        if(resultSet.next()) {

        	int user_id = resultSet.getInt("user_id");
			String login = resultSet.getString("login");
			String password = resultSet.getString("password");
			Boolean isAdmin = resultSet.getBoolean("isAdmin");
			String profilePicture = resultSet.getString("profilePicture");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			Date hireDate = resultSet.getDate("hireDate");
			String phoneNumber = resultSet.getString("phoneNumber");

			user = new User(user_id, login, password, isAdmin, profilePicture, firstName, lastName, hireDate, phoneNumber);

        }

        return user;
	}

	@Override
	public Integer create(User user) throws SQLException {
		
		String query = "INSERT INTO user (login, password, isAdmin, profilePicture, firstName, lastName, hireDate, phoneNumber) values (?, ?, ?, ?, ?, ?, ?, ?);";

		PreparedStatement prepareStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		prepareStatement.setString(1, user.getLogin());
		prepareStatement.setString(2, user.getPassword());
		prepareStatement.setBoolean(3, user.isAdmin());
		prepareStatement.setString(4, user.getProfilePicture());
		prepareStatement.setString(5, user.getFirstName());
		prepareStatement.setString(6, user.getLastName());
		prepareStatement.setDate(7, user.getHireDate());
		prepareStatement.setString(8, user.getPhoneNumber());


		prepareStatement.executeUpdate();
		ResultSet resultSet = prepareStatement.getGeneratedKeys();
		Integer user_id = null;

		if (resultSet.next()) {
			user_id = resultSet.getInt(1);
		}

		resultSet.close();
		prepareStatement.close();
		return user_id;
	}

	@Override
	public Integer update(User user) throws SQLException {

		String query = "UPDATE user SET login = ?, password = ?, isAdmin = ?, profilePicture = ?, firstName = ?, lastName = ?, hireDate = ?, phoneNumber = ? WHERE user_id = ?;";

        PreparedStatement prepareStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		prepareStatement.setString(1, user.getLogin());
		prepareStatement.setString(2, user.getPassword());
		prepareStatement.setBoolean(3, user.isAdmin());
		prepareStatement.setString(4, user.getProfilePicture());
		prepareStatement.setString(5, user.getFirstName());
		prepareStatement.setString(6, user.getLastName());
		prepareStatement.setDate(7, user.getHireDate());
		prepareStatement.setString(8, user.getPhoneNumber());

        prepareStatement.executeUpdate();
        ResultSet resultSet = prepareStatement.getGeneratedKeys();
        Integer user_id = null;

        if(resultSet.next()) {
        	user_id = resultSet.getInt(1);
        }

        resultSet.close();
        prepareStatement.close();
        return user_id;
	}

	@Override
	public void delete(User user) throws SQLException {

		String query = "DELETE FROM user WHERE user_id = ?;";

        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        prepareStatement.setInt(1, user.getUser_id());

        prepareStatement.executeUpdate();
        prepareStatement.close();
		
	}
	
	public Boolean isUserRegistered(User user) throws SQLException {
		List<User> userList = new ArrayList<User>();
		userList = this.getAll();
		Boolean validUser = false;
		for (User currentUser : userList) {
			if (currentUser.getLogin().equals(user.getLogin())) {
				if (currentUser.getPassword().equals(user.getPassword())) {
					validUser = true;
				}
			}
		}
        return validUser == true;
    }
	
	public Boolean isAdmin(User user) throws SQLException {
	
		Boolean isAdmin = false;
        String query = "SELECT * FROM user WHERE login = ? AND password = ?;";
        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        prepareStatement.setString(1, user.getLogin());
        prepareStatement.setString(2, user.getPassword());

        ResultSet resultSet = prepareStatement.executeQuery();

        if(resultSet.next()) {
			isAdmin = resultSet.getBoolean("isAdmin");
        }
        return isAdmin;
	}

}
