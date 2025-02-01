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
package com.solvd.computeranddb.jaxb.models;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlType(propOrder = { "manufacturer", "model", "numberOfCores", "clockRateInGHz",
                       "hasTurboBoost", "computerId" })
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class CPU {
    private int id;
    private String manufacturer;
    private String model;
    private int numberOfCores;
    private double clockRateInGHz;
    private boolean hasTurboBoost;
    private int computerId;

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @XmlElement
    public void setModel(String model) {
        this.model = model;
    }

    @XmlElement(name = "number_of_cores")
    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    @XmlElement(name = "clock_rate_in_GHz")
    public void setClockRateInGHz(double clockRateInGHz) {
        this.clockRateInGHz = clockRateInGHz;
    }

    @XmlElement(name = "has_turbo_boost")
    public void setHasTurboBoost(boolean hasTurboBoost) {
        this.hasTurboBoost = hasTurboBoost;
    }

    @XmlElement(name = "computer_id")
    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", numberOfCores=" + numberOfCores +
                ", clockRateInGHz=" + clockRateInGHz +
                ", hasTurboBoost=" + hasTurboBoost +
                ", computerId=" + computerId +
                '}';
    }
}
