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
import com.solvd.computeranddb.models.CPU;
import com.solvd.computeranddb.dao.interfaces.ICPUDAO;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CPUDAO implements ICPUDAO {
    private final static BasicConnectionPool BASIC_CONNECTION_POOL = BasicConnectionPool.create();
    private final static Logger LOGGER = LogManager.getLogger(CPUDAO.class);

    @Override
    public CPU getEntityById(int id) {
        CPU cpu = new CPU();
        String sql = "SELECT * FROM computer.cpu1 WHERE id = ?;";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cpu.setId(resultSet.getInt("id"));
                cpu.setManufacturer(resultSet.getString("manufacturer"));
                cpu.setModel(resultSet.getString("model"));
                cpu.setNumberOfCores(resultSet.getInt("number_of_cores"));
                cpu.setClockRateInGHz(resultSet.getDouble("clock_rate_in_GHz"));
                cpu.setHasTurboBoost(resultSet.getBoolean("has_turbo_boost"));
                cpu.setComputerId(resultSet.getInt("computer_id"));
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }

        return cpu;
    }

    @Override
    public List<CPU> getEntities() {
        List<CPU> cpus = new ArrayList<>();
        String sql = "SELECT * FROM computer.cpu1;";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CPU cpu = new CPU();
                cpu.setId(resultSet.getInt("id"));
                cpu.setManufacturer(resultSet.getString("manufacturer"));
                cpu.setModel(resultSet.getString("model"));
                cpu.setNumberOfCores(resultSet.getInt("number_of_cores"));
                cpu.setClockRateInGHz(resultSet.getDouble("clock_rate_in_GHz"));
                cpu.setHasTurboBoost(resultSet.getBoolean("has_turbo_boost"));
                cpu.setComputerId(resultSet.getInt("computer_id"));
                cpus.add(cpu);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }

        return cpus;
    }

    @Override
    public void insert(CPU cpu) {
        String sql = "INSERT INTO computer.cpu1 VALUES (?, ?, ?, ?, ?, ?, null);";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cpu.getId());
            preparedStatement.setString(2, cpu.getManufacturer());
            preparedStatement.setString(3, cpu.getModel());
            preparedStatement.setInt(4, cpu.getNumberOfCores());
            preparedStatement.setDouble(5, cpu.getClockRateInGHz());
            preparedStatement.setBoolean(6, cpu.isHasTurboBoost());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(int id, CPU cpu) {
        String sql = "UPDATE computer.cpu1 " +
                     "SET manufacturer = ?, model = ?, number_of_cores = ?, " +
                     "clock_rate_in_GHz = ?, has_turbo_boost = ?, computer_id = null " +
                     "WHERE id = ?;";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpu.getManufacturer());
            preparedStatement.setString(2, cpu.getModel());
            preparedStatement.setInt(3, cpu.getNumberOfCores());
            preparedStatement.setDouble(4, cpu.getClockRateInGHz());
            preparedStatement.setBoolean(5, cpu.isHasTurboBoost());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            LOGGER.info("The CPU with ID {} is updated in the database.", id);
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM computer.cpu1 WHERE id = ?;";
        Connection connection = BASIC_CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            LOGGER.info("The CPU with ID {} is deleted from the database.", id);
        } catch (SQLException e) {
            LOGGER.error("SQLException is caught.");
        } finally {
            BASIC_CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
