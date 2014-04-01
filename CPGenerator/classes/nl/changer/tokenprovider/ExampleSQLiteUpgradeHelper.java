package nl.changer.tokenprovider;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import nl.changer.tokenprovider.BuildConfig;

public class ExampleSQLiteUpgradeHelper {
    private static final String TAG = ExampleSQLiteUpgradeHelper.class.getSimpleName();

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (BuildConfig.DEBUG) Log.d(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion);
        // Insert your upgrading code here.
        // This file will not be overridden.
    }
}
