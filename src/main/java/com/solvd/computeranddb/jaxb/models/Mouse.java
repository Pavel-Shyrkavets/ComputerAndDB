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

import com.solvd.computeranddb.jaxb.DateAdapter;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@XmlType(propOrder = { "manufacturer", "model", "mouseType", "manufactureDate",
                       "computerId" })
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class Mouse {
    private int id;
    private String manufacturer;
    private String model;
    private String mouseType;
    private Date manufactureDate;
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

    @XmlElement(name = "mouse_type")
    public void setMouseType(String mouseType) {
        this.mouseType = mouseType;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "manufacture_date")
    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @XmlElement(name = "computer_id")
    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", mouse_type='" + mouseType + '\'' +
                ", manufacture_date='" + manufactureDate + '\'' +
                ", computer_id=" + computerId +
                '}';
    }
}
