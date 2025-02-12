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
package com.solvd.computeranddb.dao.mybatis;

import com.solvd.computeranddb.dao.interfaces.IMouseDAO;
import com.solvd.computeranddb.models.Mouse;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MouseDAO implements IMouseDAO {
    private final SqlSessionFactory SQL_SESSION_FACTORY
            = MyBatisConfiguration.buildSqlSessionFactory();

    @Override
    public Mouse getEntityById(int id) {
        Mouse mouse;

        //Interface
        try(SqlSession session = SQL_SESSION_FACTORY.openSession()) {
            mouse = session.selectOne("com.solvd.computeranddb.dao.interfaces.IMouseDAO.getEntityById", id);

            return mouse;
        }
    }

    @Override
    public List<Mouse> getEntities() {
        List<Mouse> mice;

        //Interface
        try(SqlSession session = SQL_SESSION_FACTORY.openSession()) {
            mice = session.selectList("com.solvd.computeranddb.dao.interfaces.IMouseDAO.getEntities");

            return mice;
        }
    }

    @Override
    public void insert(Mouse mouse) {
        //Interface
        try(SqlSession session = SQL_SESSION_FACTORY.openSession()) {
            session.insert("com.solvd.computeranddb.dao.interfaces.IMouseDAO.insert", mouse);
            session.commit();
        }
    }

    @Override
    public void update(int id, Mouse mouse) {
        //Interface
        try(SqlSession session = SQL_SESSION_FACTORY.openSession()) {
            session.update("com.solvd.computeranddb.dao.interfaces.IMouseDAO.update", mouse);
            session.commit();
        }
    }

    @Override
    public void delete(int id) {
        //Interface
        try(SqlSession session = SQL_SESSION_FACTORY.openSession()) {
            session.delete("com.solvd.computeranddb.dao.interfaces.IMouseDAO.delete", id);
            session.commit();
        }
    }
}
