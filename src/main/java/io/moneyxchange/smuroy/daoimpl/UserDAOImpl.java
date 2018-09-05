package io.moneyxchange.smuroy.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.moneyxchange.smuroy.dao.UserDAO;
import io.moneyxchange.smuroy.model.User;

/**
 * 
 * @author SERGIO MUROY
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	DataSource datasource;

	@Override
	public User getUser(User user) {
		String query = "SELECT * FROM user WHERE username = ? AND password = ?";

		Connection connection = null;
		User searchedUser = null;

		try {
			connection = datasource.getConnection();

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				searchedUser = new User();
				searchedUser.setId(rs.getInt("id"));
				searchedUser.setUsername(rs.getString("username"));
				searchedUser.setStatus(rs.getBoolean("status"));
				searchedUser.setCreationDate(rs.getDate("creation_date"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return searchedUser;
	}

}
