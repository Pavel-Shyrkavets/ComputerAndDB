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

import com.solvd.computeranddb.patterns.interfaces.IStrategy;
import com.solvd.computeranddb.patterns.models.Computer;

public class CompComparisonByNumOfCores implements IStrategy {
    @Override
    public String compareObjects(Object object, Object anotherObject) {
        if (object instanceof Computer && anotherObject instanceof Computer) {
            if (((Computer) object).getCpu().getNumberOfCores()
                    > ((Computer) anotherObject).getCpu().getNumberOfCores()) {
                return object + " has " + ((Computer) object).getCpu().getNumberOfCores() + " cores.";
            } else if (((Computer) object).getCpu().getNumberOfCores()
                    < ((Computer) anotherObject).getCpu().getNumberOfCores()) {
                return anotherObject + " has "
                        + ((Computer) anotherObject).getCpu().getNumberOfCores() + " cores.";
            } else {
                return "Each of the two compared computers has "
                        + ((Computer) anotherObject).getCpu().getNumberOfCores() + " cores.";
            }
        }

        return "The two objects are incomparable.";
    }
}
