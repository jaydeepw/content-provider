package nl.changer.tokenprovider.token;

import java.util.Date;

import android.content.ContentResolver;
import android.net.Uri;

import nl.changer.tokenprovider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code token} table.
 */
public class TokenContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return TokenColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     * 
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, TokenSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public TokenContentValues putAppname(String value) {
        if (value == null) throw new IllegalArgumentException("value for appname must not be null");
        mContentValues.put(TokenColumns.APPNAME, value);
        return this;
    }



    public TokenContentValues putToken(String value) {
        if (value == null) throw new IllegalArgumentException("value for token must not be null");
        mContentValues.put(TokenColumns.TOKEN, value);
        return this;
    }


}
