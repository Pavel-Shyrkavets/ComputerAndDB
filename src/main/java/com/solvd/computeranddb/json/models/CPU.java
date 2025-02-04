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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class CPU {
    private int id;
    private String manufacturer;
    private String model;
    @JsonProperty(value = "number_of_cores")
    private int numberOfCores;
    @JsonProperty(value = "clock_rate_in_GHz")
    private double clockRateInGHz;
    @JsonProperty(value = "has_turbo_boost")
    private boolean hasTurboBoost;
    @JsonProperty(value = "computer_id")
    private int computerId;

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
