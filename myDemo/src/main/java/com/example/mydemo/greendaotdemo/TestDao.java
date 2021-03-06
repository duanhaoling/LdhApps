package com.example.mydemo.greendaotdemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEST".
*/
public class TestDao extends AbstractDao<Test, Long> {

    public static final String TABLENAME = "TEST";

    /**
     * Properties of entity Test.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Hello = new Property(1, String.class, "hello", false, "HELLO");
        public final static Property World = new Property(2, String.class, "world", false, "WORLD");
    }


    public TestDao(DaoConfig config) {
        super(config);
    }
    
    public TestDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEST\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"HELLO\" TEXT," + // 1: hello
                "\"WORLD\" TEXT);"); // 2: world
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEST\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Test entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String hello = entity.getHello();
        if (hello != null) {
            stmt.bindString(2, hello);
        }
 
        String world = entity.getWorld();
        if (world != null) {
            stmt.bindString(3, world);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Test entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String hello = entity.getHello();
        if (hello != null) {
            stmt.bindString(2, hello);
        }
 
        String world = entity.getWorld();
        if (world != null) {
            stmt.bindString(3, world);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Test readEntity(Cursor cursor, int offset) {
        Test entity = new Test( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // hello
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // world
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Test entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setHello(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setWorld(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Test entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Test entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Test entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
