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
package com.solvd.computeranddb.patterns.models;

import com.solvd.computeranddb.patterns.ComputerBuilder;
import com.solvd.computeranddb.patterns.interfaces.IUse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Computer implements IUse {
    private final static Logger LOGGER = LogManager.getLogger(Computer.class);

    private int id;
    private String manufacturer;
    private String model;
    private String computerType;
    private String target;
    private String freshness;
    private BigDecimal priceInUSD;
    private boolean isTurnedOn;
    private CPU cpu;
    private Mouse mouse;

    public Computer(ComputerBuilder computerBuilder) {
        this.id = computerBuilder.getId();
        this.manufacturer = computerBuilder.getManufacturer();
        this.model = computerBuilder.getModel();
        this.computerType = computerBuilder.getComputerType();
        this.target = computerBuilder.getTarget();
        this.freshness = computerBuilder.getFreshness();
        this.priceInUSD = computerBuilder.getPriceInUSD();
        this.isTurnedOn = computerBuilder.isTurnedOn();
        this.cpu = computerBuilder.getCpu();
        this.mouse = computerBuilder.getMouse();
    }

    @Override
    public void use() {
        LOGGER.info("The computer is used: {}", this);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", computerType='" + computerType + '\'' +
                ", target='" + target + '\'' +
                ", freshness='" + freshness + '\'' +
                ", priceInUSD=" + priceInUSD +
                ", isTurnedOn=" + isTurnedOn +
                ", " + cpu +
                ", " + mouse +
                '}';
    }
}
