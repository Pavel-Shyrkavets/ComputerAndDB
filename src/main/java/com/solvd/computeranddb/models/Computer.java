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
package com.solvd.computeranddb.models;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
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
                ", cpuId=" + cpuId +
                ", displayId=" + displayId +
                ", gpuId=" + gpuId +
                ", osId=" + osId +
                ", portId=" + portId +
                ", ramId=" + ramId +
                ", storageId=" + storageId +
                ", mouseId=" + mouseId +
                ", keyboardId=" + keyboardId +
                ", speakersId=" + speakersId +
                ", userId=" + userId +
                '}';
    }
}
