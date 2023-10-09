package com.jonatan.crud_sql.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContacts extends DbHelper {
    Context context;
    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     */
    public DbContacts(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertContact(String name, String phone, String email){
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("phone", phone);
            values.put("email", email);
            return db.insert(TABLE_CONTACT, null, values);
        }catch (Exception e){
            e.toString();
        }
        return 0;
    }
}
