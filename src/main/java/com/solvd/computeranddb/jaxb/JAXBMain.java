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
package com.solvd.computeranddb.jaxb;

import com.solvd.computeranddb.jaxb.models.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JAXBMain {
    private final static Logger LOGGER = LogManager.getLogger(JAXBMain.class);

    public static void main(String[] args) {
        Computers computers = unmarshal();
        LOGGER.info(computers);
        marshal();
    }

    public static void marshal() {
        CPU cpu = new CPU(1, "Intel", "CORE i5 vPro 8th Gen", 4, 2.0, true, 1);
        CPUs cpus = new CPUs();
        List<CPU> cpusList = new ArrayList<>();
        Mouse mouse = new Mouse(1, "Logitech", "Y", "USB", new Date(), 1);
        Mice mice = new Mice();
        List<Mouse> miceList = new ArrayList<>();
        Computer computer = new Computer(1, "Sony", "Vaio", "Laptop", "Business", "Not new",
                            new BigDecimal("400.00"), false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, cpus, mice);
        Computers computers = new Computers();
        List<Computer> computersList = new ArrayList<>();
        JAXBContext context;
        Marshaller mar;

        cpusList.add(cpu);
        cpus.setList(cpusList);
        miceList.add(mouse);
        mice.setList(miceList);
        computersList.add(computer);
        computers.setList(computersList);

        try {
            context = JAXBContext.newInstance(Computers.class);
            mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(computers,
                        new File("src/main/resources/computers_with_date_in_mouse_marshalled.xml"));
        } catch (JAXBException e) {
            LOGGER.error("JAXBException is caught.");
        }
    }

    public static Computers unmarshal() {
        JAXBContext context;

        try {
            context = JAXBContext.newInstance(Computers.class);

            return (Computers) context.createUnmarshaller()
                    .unmarshal(new FileReader("src/main/resources/computers_with_date_in_mouse.xml"));
        } catch (JAXBException e) {
            LOGGER.error("JAXBException is caught.");
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException is caught.");
        }

        return null;
    }
}
