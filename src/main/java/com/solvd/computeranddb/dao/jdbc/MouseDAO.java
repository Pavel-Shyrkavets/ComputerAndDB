/*
 * %W% %E% Pavel Shyrkavets
 *
 * Copyright (c) 2011-2025 Solvd, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Solvd,
 * Inc. ("Confidential Information.") You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Solvd.
 *
 * SOLVD MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. SOLVD SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 */
package com.solvd.computeranddb.dao.jdbc;

import com.solvd.computeranddb.BasicConnectionPool;
import com.solvd.computeranddb.dao.interfaces.IMouseDAO;
import com.solvd.computeranddb.models.Mouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MouseDAO implements IMouseDAO {
    private final static BasicConnectionPool BASIC_CONNECTION_POOL = BasicConnectionPool.create();
    private final static Logger LOGGER = LogManager.getLogger(MouseDAO.class);

    @Override
    public Mouse getEntityById(int id) {
        Mouse mouse = new Mouse();
        String sql = "SELECT * FROM computer.mouse WHERE id = ?;";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                mouse.setId(resultSet.getInt("id"));
                mouse.setManufacturer(resultSet.getString("manufacturer"));
                mouse.setModel(resultSet.getString("model"));
                mouse.setMouseType(resultSet.getString("mouse_type"));
                mouse.setComputerId(resultSet.getInt("computer_id"));
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }

        return mouse;
    }

    @Override
    public List<Mouse> getEntities() {
        List<Mouse> mice = new ArrayList<>();
        String sql = "SELECT * FROM computer.mouse;";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mouse mouse = new Mouse();
                mouse.setId(resultSet.getInt("id"));
                mouse.setManufacturer(resultSet.getString("manufacturer"));
                mouse.setModel(resultSet.getString("model"));
                mouse.setMouseType(resultSet.getString("mouse_type"));
                mouse.setComputerId(resultSet.getInt("computer_id"));
                mice.add(mouse);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }

        return mice;
    }

    @Override
    public void insert(Mouse mouse) {
        String sql = "INSERT INTO computer.mouse VALUES (?, ?, ?, ?, null);";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, mouse.getId());
            preparedStatement.setString(2, mouse.getManufacturer());
            preparedStatement.setString(3, mouse.getModel());
            preparedStatement.setString(4, mouse.getMouseType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Mouse mouse) {
        String sql = "UPDATE computer.mouse " +
                     "SET manufacturer = ?, model = ?, mouse_type = ?, computer_id = null " +
                     "WHERE id = ?;";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mouse.getManufacturer());
            preparedStatement.setString(2, mouse.getModel());
            preparedStatement.setString(3, mouse.getMouseType());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            LOGGER.info("The mouse with ID {} is updated in the database.", id);
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM computer.mouse WHERE id = ?;";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            LOGGER.info("The mouse with ID {} is deleted from the database.", id);
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
