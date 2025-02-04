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
package com.solvd.computeranddb.json.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Computer {
    private int id;
    private String manufacturer;
    private String model;
    @JsonProperty(value = "computer_type")
    private String computerType;
    private String target;
    private String freshness;
    @JsonIgnore
    private BigDecimal priceInUSD;
    @JsonIgnore
    private boolean isTurnedOn;
    @JsonIgnore
    private int cpuId;
    @JsonIgnore
    private int displayId;
    @JsonIgnore
    private int gpuId;
    @JsonIgnore
    private int osId;
    @JsonIgnore
    private int portId;
    @JsonIgnore
    private int ramId;
    @JsonIgnore
    private int storageId;
    @JsonIgnore
    private int mouseId;
    @JsonIgnore
    private int keyboardId;
    @JsonIgnore
    private int speakersId;
    @JsonIgnore
    private int userId;
    @JsonProperty("cpus")
    private List<CPU> cpus;
    @JsonProperty("mice")
    private List<Mouse> mice;

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
