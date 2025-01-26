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
package com.solvd.computeranddb;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@NoArgsConstructor
public class BasicConnectionPool {
    private final static int INITIAL_POOL_SIZE = 5;
    private final static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("database");
    private final static String URL = RESOURCE_BUNDLE.getString("url");
    private final static String USER = RESOURCE_BUNDLE.getString("user");
    private final static String PASSWORD = RESOURCE_BUNDLE.getString("password");
    private final static List<Connection> CONNECTION_POOL = new ArrayList<>(INITIAL_POOL_SIZE);
    private final static List<Connection> USED_CONNECTIONS = new ArrayList<>();
    private final static Logger LOGGER = LogManager.getLogger(BasicConnectionPool.class);

    public static BasicConnectionPool create()  {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            try {
                CONNECTION_POOL.add(createConnection());
            } catch (SQLException e) {
                LOGGER.error("SQLException is caught.");
            }
        }
        return new BasicConnectionPool();
    }

    public Connection getConnection() {
        Connection connection = CONNECTION_POOL.remove(CONNECTION_POOL.size() - 1);
        USED_CONNECTIONS.add(connection);
        return connection;
    }

    public void releaseConnection(Connection connection) {
        CONNECTION_POOL.add(connection);
        USED_CONNECTIONS.remove(connection);
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
