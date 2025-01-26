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
import com.solvd.computeranddb.dao.interfaces.IComputerDAO;
import com.solvd.computeranddb.models.Computer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerDAO implements IComputerDAO {
    private final static BasicConnectionPool BASIC_CONNECTION_POOL = BasicConnectionPool.create();
    private final static Logger LOGGER = LogManager.getLogger(ComputerDAO.class);

    @Override
    public Computer getEntityById(int id) {
        Computer computer = new Computer();
        String sql = "SELECT * FROM computer.computer WHERE id = ?;";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                computer.setId(resultSet.getInt("id"));
                computer.setManufacturer(resultSet.getString("manufacturer"));
                computer.setModel(resultSet.getString("model"));
                computer.setComputerType(resultSet.getString("computer_type"));
                computer.setTarget(resultSet.getString("target"));
                computer.setFreshness(resultSet.getString("freshness"));
                computer.setPriceInUSD(resultSet.getBigDecimal("price_in_usd"));
                computer.setTurnedOn(resultSet.getBoolean("is_turned_on"));
                computer.setCpuId(resultSet.getInt("cpu_id"));
                computer.setDisplayId(resultSet.getInt("display_id"));
                computer.setGpuId(resultSet.getInt("gpu_id"));
                computer.setOsId(resultSet.getInt("os_id"));
                computer.setPortId(resultSet.getInt("port_id"));
                computer.setRamId(resultSet.getInt("ram_id"));
                computer.setStorageId(resultSet.getInt("storage_id"));
                computer.setMouseId(resultSet.getInt("mouse_id"));
                computer.setKeyboardId(resultSet.getInt("keyboard_id"));
                computer.setSpeakersId(resultSet.getInt("speakers_id"));
                computer.setUserId(resultSet.getInt("user_id"));
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }

        return computer;
    }

    @Override
    public List<Computer> getEntities() {
        List<Computer> computers = new ArrayList<>();
        String sql = "SELECT * FROM computer.computer;";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Computer computer = new Computer();
                computer.setId(resultSet.getInt("id"));
                computer.setManufacturer(resultSet.getString("manufacturer"));
                computer.setModel(resultSet.getString("model"));
                computer.setComputerType(resultSet.getString("computer_type"));
                computer.setTarget(resultSet.getString("target"));
                computer.setFreshness(resultSet.getString("freshness"));
                computer.setPriceInUSD(resultSet.getBigDecimal("price_in_usd"));
                computer.setTurnedOn(resultSet.getBoolean("is_turned_on"));
                computer.setCpuId(resultSet.getInt("cpu_id"));
                computer.setDisplayId(resultSet.getInt("display_id"));
                computer.setGpuId(resultSet.getInt("gpu_id"));
                computer.setOsId(resultSet.getInt("os_id"));
                computer.setPortId(resultSet.getInt("port_id"));
                computer.setRamId(resultSet.getInt("ram_id"));
                computer.setStorageId(resultSet.getInt("storage_id"));
                computer.setMouseId(resultSet.getInt("mouse_id"));
                computer.setKeyboardId(resultSet.getInt("keyboard_id"));
                computer.setSpeakersId(resultSet.getInt("speakers_id"));
                computer.setUserId(resultSet.getInt("user_id"));
                computers.add(computer);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }

        return computers;
    }

    @Override
    public void insert(Computer computer) {
        String sql = "INSERT INTO computer.computer " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, " +
                     "null, null, null, null, null, null, null, null, null, null, null);";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, computer.getId());
            preparedStatement.setString(2, computer.getManufacturer());
            preparedStatement.setString(3, computer.getModel());
            preparedStatement.setString(4, computer.getComputerType());
            preparedStatement.setString(5, computer.getTarget());
            preparedStatement.setString(6, computer.getFreshness());
            preparedStatement.setBigDecimal(7, computer.getPriceInUSD());
            preparedStatement.setBoolean(8, computer.isTurnedOn());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, Computer computer) {
        String sql = "UPDATE computer.computer " +
                     "SET manufacturer = ?, model = ?, computer_type = ?, target = ?, " +
                     "freshness = ?, price_in_usd = ?, is_turned_on = ?, cpu_id = null, " +
                     "display_id = null, gpu_id = null, os_id = null, port_id = null, " +
                     "ram_id = null, storage_id = null, mouse_id = null, keyboard_id = null, " +
                     "speakers_id = null, user_id = null " +
                     "WHERE id = ?;";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, computer.getManufacturer());
            preparedStatement.setString(2, computer.getModel());
            preparedStatement.setString(3, computer.getComputerType());
            preparedStatement.setString(4, computer.getTarget());
            preparedStatement.setString(5, computer.getFreshness());
            preparedStatement.setBigDecimal(6, computer.getPriceInUSD());
            preparedStatement.setBoolean(7, computer.isTurnedOn());
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
            LOGGER.info("The computer with ID {} is updated in the database.", id);
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM computer.computer WHERE id = ?;";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            LOGGER.info("The computer with ID {} is deleted from the database.", id);
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
