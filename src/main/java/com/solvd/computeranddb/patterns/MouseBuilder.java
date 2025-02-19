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

import com.solvd.computeranddb.patterns.models.Mouse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class MouseBuilder {
    private int id;
    private String manufacturer;
    private String model;
    private String mouseType;
    private int computerId;

    public MouseBuilder withId(int id) {
        this.id = id;

        return this;
    }

    public MouseBuilder withManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;

        return this;
    }

    public MouseBuilder withModel(String model) {
        this.model = model;

        return this;
    }

    public MouseBuilder withMouseType(String mouseType) {
        this.mouseType = mouseType;

        return this;
    }

    public MouseBuilder withComputerId(int computerId) {
        this.computerId = computerId;

        return this;
    }

    public Mouse build() {
        return new Mouse(this);
    }
}
