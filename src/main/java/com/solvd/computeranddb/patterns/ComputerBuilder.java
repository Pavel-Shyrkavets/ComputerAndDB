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
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class ComputerBuilder {
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

    public ComputerBuilder withId(int id) {
        this.id = id;

        return this;
    }

    public ComputerBuilder withManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;

        return this;
    }

    public ComputerBuilder withModel(String model) {
        this.model = model;

        return this;
    }

    public ComputerBuilder withComputerType(String computerType) {
        this.computerType = computerType;

        return this;
    }

    public ComputerBuilder withTarget(String target) {
        this.target = target;

        return this;
    }

    public ComputerBuilder withFreshness(String freshness) {
        this.freshness = freshness;

        return this;
    }

    public ComputerBuilder withPriceInUSD(BigDecimal priceInUSD) {
        this.priceInUSD = priceInUSD;

        return this;
    }

    public ComputerBuilder withTurnedOn(boolean isTurnedOn) {
        this.isTurnedOn = isTurnedOn;

        return this;
    }

    public ComputerBuilder withCPU(CPU cpu) {
        this.cpu = cpu;

        return this;
    }

    public ComputerBuilder withMouse(Mouse mouse) {
        this.mouse = mouse;

        return this;
    }

    public Computer build() {
        return new Computer(this);
    }
}
