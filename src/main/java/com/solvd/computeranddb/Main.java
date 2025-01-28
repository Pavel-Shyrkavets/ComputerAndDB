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

import com.solvd.computeranddb.dao.interfaces.IComputerDAO;
import com.solvd.computeranddb.dao.interfaces.IMouseDAO;
import com.solvd.computeranddb.dao.jdbc.CPUDAO;
import com.solvd.computeranddb.dao.interfaces.ICPUDAO;
import com.solvd.computeranddb.dao.jdbc.ComputerDAO;
import com.solvd.computeranddb.dao.jdbc.MouseDAO;
import com.solvd.computeranddb.models.CPU;
import com.solvd.computeranddb.models.Computer;
import com.solvd.computeranddb.models.Mouse;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

/**
 * The Main class starts an application that selects, inserts into, updates and
 * deletes data from the computer, cpu1, mouse tables in the computer database.
 *
 * @version    1.1 28 Jan 2025
 * @author     Pavel Shyrkavets
 */

@NoArgsConstructor
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args ) {
        IComputerDAO computerDAO = new ComputerDAO();
        ICPUDAO cpuDAO = new CPUDAO();
        IMouseDAO mouseDAO = new MouseDAO();

        computerDAO.insert(new Computer(1, "Sony", "Vaio", "Laptop", "Business", "Not new",
                new BigDecimal("400.00"), false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        LOGGER.info(computerDAO.getEntityById(1));
        computerDAO.update(1, new Computer(1, "HP", "Pavilion", "Laptop", "Gaming", "New",
                           new BigDecimal("800.00"), true, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        LOGGER.info(computerDAO.getEntityById(1));
        LOGGER.info("The total number of computers in the computer table is {}.",
                    computerDAO.getEntities().size());

        cpuDAO.insert(new CPU(1, "Intel", "CORE i5 vPro 8th Gen", 4, 2.0, true, 0));
        LOGGER.info(cpuDAO.getEntityById(1));
        cpuDAO.update(1, new CPU(1, "Intel", "CORE i7 vPro 9th Gen", 4, 3.0, true, 0));
        LOGGER.info(cpuDAO.getEntityById(1));
        LOGGER.info("The total number of CPUs in the cpu1 table is {}.",
                    cpuDAO.getEntities().size());

        mouseDAO.insert(new Mouse(1, "Logitech", "Z", "Bluetooth", 0));
        LOGGER.info(mouseDAO.getEntityById(1));
        mouseDAO.update(1, new Mouse(1, "Logitech", "ZZZ", "USB", 0));
        LOGGER.info(mouseDAO.getEntityById(1));
        LOGGER.info("The total number of computer mice in the mouse table is {}.",
                    mouseDAO.getEntities().size());

        computerDAO.delete(1);
        cpuDAO.delete(1);
        mouseDAO.delete(1);
        LOGGER.info("The total number of computers in the computer table is {}.",
                computerDAO.getEntities().size());
        LOGGER.info("The total number of CPUs in the cpu1 table is {}.",
                cpuDAO.getEntities().size());
        LOGGER.info("The total number of computer mice in the mouse table is {}.",
                mouseDAO.getEntities().size());
    }
}
