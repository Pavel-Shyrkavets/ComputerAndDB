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
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@XmlType(propOrder = { "manufacturer", "model", "computerType", "target",
                       "freshness", "cpus", "mice" })
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class Computer {
    private int id;
    private String manufacturer;
    private String model;
    private String computerType;
    private String target;
    private String freshness;
    private BigDecimal priceInUSD;
    private boolean isTurnedOn;
    private int cpuId;
    private int displayId;
    private int gpuId;
    private int osId;
    private int portId;
    private int ramId;
    private int storageId;
    private int mouseId;
    private int keyboardId;
    private int speakersId;
    private int userId;
    private CPUs cpus;
    private Mice mice;

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

    @XmlElement(name = "computer_type")
    public void setComputerType(String computerType) {
        this.computerType = computerType;
    }

    @XmlElement
    public void setTarget(String target) {
        this.target = target;
    }

    @XmlElement
    public void setFreshness(String freshness) {
        this.freshness = freshness;
    }

    @XmlTransient
    public void setPriceInUSD(BigDecimal priceInUSD) {
        this.priceInUSD = priceInUSD;
    }

    @XmlTransient
    public void setTurnedOn(boolean turnedOn) {
        isTurnedOn = turnedOn;
    }

    @XmlTransient
    public void setCpuId(int cpuId) {
        this.cpuId = cpuId;
    }

    @XmlTransient
    public void setDisplayId(int displayId) {
        this.displayId = displayId;
    }

    @XmlTransient
    public void setGpuId(int gpuId) {
        this.gpuId = gpuId;
    }

    @XmlTransient
    public void setOsId(int osId) {
        this.osId = osId;
    }

    @XmlTransient
    public void setPortId(int portId) {
        this.portId = portId;
    }

    @XmlTransient
    public void setRamId(int ramId) {
        this.ramId = ramId;
    }

    @XmlTransient
    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    @XmlTransient
    public void setMouseId(int mouseId) {
        this.mouseId = mouseId;
    }

    @XmlTransient
    public void setKeyboardId(int keyboardId) {
        this.keyboardId = keyboardId;
    }

    @XmlTransient
    public void setSpeakersId(int speakersId) {
        this.speakersId = speakersId;
    }

    @XmlTransient
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @XmlElement
    public void setCpus(CPUs cpus) {
        this.cpus = cpus;
    }

    @XmlElement
    public void setMice(Mice mice) {
        this.mice = mice;
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
                ", " + cpus +
                ", " + mice +
                '}';
    }
}
