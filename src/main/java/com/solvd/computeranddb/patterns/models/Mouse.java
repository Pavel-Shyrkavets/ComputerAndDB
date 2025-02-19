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

import com.solvd.computeranddb.patterns.MouseBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Mouse extends Component {
    private final static Logger LOGGER = LogManager.getLogger(Mouse.class);

    private String mouseType;

    public Mouse(MouseBuilder mouseBuilder) {
        this.id = mouseBuilder.getId();
        this.manufacturer = mouseBuilder.getManufacturer();
        this.model = mouseBuilder.getModel();
        this.mouseType = mouseBuilder.getMouseType();
        this.computerId = mouseBuilder.getComputerId();
    }

    @Override
    public void use() {
        LOGGER.info("The mouse is used: {}", this);
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", mouseType='" + mouseType + '\'' +
                ", computerId=" + computerId +
                '}';
    }
}
