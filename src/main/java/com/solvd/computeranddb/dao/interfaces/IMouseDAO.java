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
package com.solvd.computeranddb.dao.interfaces;

import com.solvd.computeranddb.models.Mouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IMouseDAO extends IBaseDAO<Mouse> {
    @Select("SELECT * FROM computer.mouse WHERE id = #{id}")
    @Results(value = {
            @Result(property="manufacturer", column = "manufacturer"),
            @Result(property="model", column = "model"),
            @Result(property="mouseType", column = "mouse_type"),
            @Result(property="computerId", column = "computer_id")
    })
    @Override
    Mouse getEntityById(int id);

    @Select("SELECT * FROM computer.mouse")
    @Results(value = {
            @Result(property="manufacturer", column = "manufacturer"),
            @Result(property="model", column = "model"),
            @Result(property="mouseType", column = "mouse_type"),
            @Result(property="computerId", column = "computer_id")
    })
    @Override
    List<Mouse> getEntities();

    @Insert("INSERT INTO computer.mouse (manufacturer, model, mouse_type, computer_id) " +
            "VALUES (#{manufacturer}, #{model}, #{mouseType}, null)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Override
    void insert(Mouse mouse);

    @Update("UPDATE computer.mouse SET manufacturer = #{manufacturer}, model = #{model}, " +
            "mouse_type = #{mouseType}, computer_id = null WHERE id = #{id}")
    @Override
    void update(int id, Mouse mouse);

    @Delete("DELETE FROM computer.mouse WHERE id = #{id}")
    @Override
    void delete(int id);
}
