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
package com.solvd.computeranddb.patterns;

import com.solvd.computeranddb.patterns.models.CPU;
import com.solvd.computeranddb.patterns.models.Computer;
import com.solvd.computeranddb.patterns.models.Mouse;
import com.solvd.computeranddb.patterns.utils.FactoryGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class MainWithPatternsTest {
    private final static Logger LOGGER = LogManager.getLogger(MainWithPatternsTest.class);

    public static void main(String[] args) {
        AbstractFactory componentFactory = FactoryGenerator.getFactory("component");
        CPUBuilder cpuBuilder = new CPUBuilder();
        MouseBuilder mouseBuilder = new MouseBuilder();
        ComputerBuilder computerBuilder = new ComputerBuilder();
        CPU cpu;
        Mouse mouse;
        Computer computer;
        Context context;
        String comparisonResult;

        if (componentFactory != null) {
            cpu = (CPU) componentFactory.getComponent("CPU");
            cpu.setId(1);
            cpu.setManufacturer("Intel");
            cpu.setModel("CORE i5 vPro 8th Gen");
            cpu.setNumberOfCores(8);
            cpu.setClockRateInGHz(1.90);
            cpu.setHasTurboBoost(true);
            cpu.setComputerId(1);
            cpu.use();

            mouse = (Mouse) componentFactory.getComponent("mouse");
            mouse.setId(1);
            mouse.setManufacturer("China");
            mouse.setModel("Z");
            mouse.setMouseType("USB");
            mouse.setComputerId(1);
            mouse.use();
        }

        cpu = cpuBuilder
                .withId(1)
                .withManufacturer("Toshiba")
                .withModel("Katana")
                .withNumberOfCores(16)
                .withClockRateInGHz(4.00)
                .withTurboBoost(true)
                .withComputerId(1)
                .build();
        cpu.use();

        mouse = mouseBuilder
                .withId(1)
                .withManufacturer("Logitech")
                .withModel("Super Model")
                .withMouseType("Bluetooth")
                .withComputerId(1)
                .build();
        mouse.use();

        computer = computerBuilder
                .withId(1)
                .withManufacturer("Sony")
                .withModel("Blade")
                .withComputerType("Laptop")
                .withTarget("Business")
                .withFreshness("New")
                .withPriceInUSD(new BigDecimal("3000.00"))
                .withTurnedOn(true)
                .withCPU(cpu)
                .withMouse(mouse)
                .build();
        computer.use();

        ComputerDecorator laptop = new ComputerDecorator(computer);
        laptop.switchOff();
        laptop.use();

        context = new Context(new CompComparisonByCPUClockRate());
        comparisonResult = context.executeStrategy(computer, computer);
        LOGGER.info(comparisonResult);
        context = new Context(new CompComparisonByNumOfCores());
        comparisonResult = context.executeStrategy(computer, computer);
        LOGGER.info(comparisonResult);
    }
}
