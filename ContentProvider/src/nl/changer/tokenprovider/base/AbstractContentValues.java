package nl.changer.tokenprovider.base;

import nl.changer.contentprovider.BuildConfig;
import nl.changer.tokenprovider.token.TokenColumns;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.util.Log;

public abstract class AbstractContentValues {
    protected ContentValues mContentValues = new ContentValues();

    /**
     * Returns the {@code uri} argument to pass to the {@code ContentResolver} methods.
     */
    public abstract Uri uri();

    /**
     * Returns the {@code ContentValues} wrapped by this object.
     */
    public ContentValues values() {
    	if(BuildConfig.DEBUG) Log.v("", "#values appName: " + mContentValues.getAsString(TokenColumns.APPNAME));
        return mContentValues;
    }

    /**
     * Inserts a row into a table using the values stored by this object.
     * 
     * @param contentResolver The content resolver to use.
     */
    public Uri insert(ContentResolver contentResolver) {
        return contentResolver.insert(uri(), values());
    }
}