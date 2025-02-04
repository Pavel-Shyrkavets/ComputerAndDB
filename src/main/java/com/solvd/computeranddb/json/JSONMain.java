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
package com.solvd.computeranddb.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.computeranddb.json.models.CPU;
import com.solvd.computeranddb.json.models.Computer;
import com.solvd.computeranddb.json.models.Mouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JSONMain {
    private final static Logger LOGGER = LogManager.getLogger(JSONMain.class);

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(simpleDateFormat);
        List<CPU> cpus = new ArrayList<>();
        cpus.add(new CPU(1, "Intel", "CORE i5 vPro 8th Gen", 4, 2.0, true, 1));
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 2);
        Date mouseManufactureDate = calendar.getTime();
        Mouse mouse = new Mouse(1, "Logitech", "Z", "Bluetooth", mouseManufactureDate, 1);
        List<Mouse> mice = new ArrayList<>();
        mice.add(mouse);
        Computer computer = new Computer(1, "Sony", "Vaio", "Laptop", "Business", "Not new",
                            new BigDecimal("400.00"), false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, cpus, mice);
        Computer computerFromJson;

        try {
            //Write to a JSON file
            objectMapper.writeValue(new File("src/main/resources/parsed_computer.json"), computer);
            LOGGER.info("The computer object is parsed into src/main/resources/parsed_computer.json");
            //Read from a JSON file
            computerFromJson = objectMapper.readValue(
                    new File("src/main/resources/parsed_computer.json"), Computer.class);
            LOGGER.info(computerFromJson);
        } catch (IOException e) {
            LOGGER.error("IOException is caught.");
        }
    }
}
