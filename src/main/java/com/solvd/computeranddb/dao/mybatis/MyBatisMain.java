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
package com.solvd.computeranddb.dao.mybatis;

import com.solvd.computeranddb.dao.interfaces.IMouseDAO;
import com.solvd.computeranddb.models.Mouse;
import com.solvd.computeranddb.service.MouseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MyBatisMain {
    private final static Logger LOGGER = LogManager.getLogger(MyBatisMain.class);

    public static void main(String[] args) {
        IMouseDAO mouseDAO = MouseService.getMouseForOperation();
        Mouse mouse = new Mouse();
        mouse.setManufacturer("Logitech");
        mouse.setModel("A");
        mouse.setMouseType("USB");
        mouseDAO.insert(mouse);
        mouse = mouseDAO.getEntityById(mouse.getId());
        LOGGER.info(mouse);
        List<Mouse> mice = mouseDAO.getEntities();
        LOGGER.info(mice.get(0));
        mouse.setManufacturer("Dell");
        mouse.setModel("B");
        mouse.setMouseType("Bluetooth");
        mouseDAO.update(mouse.getId(), mouse);
        mouseDAO.delete(mouse.getId());
    }
}
