package com.plpgogogo.capsuleup.database;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.plpgogogo.capsuleup.database.User;
import com.plpgogogo.capsuleup.database.Data;

import com.plpgogogo.capsuleup.database.UserDao;
import com.plpgogogo.capsuleup.database.DataDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig dataDaoConfig;

    private final UserDao userDao;
    private final DataDao dataDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        dataDaoConfig = daoConfigMap.get(DataDao.class).clone();
        dataDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        dataDao = new DataDao(dataDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Data.class, dataDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        dataDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public DataDao getDataDao() {
        return dataDao;
    }

}
