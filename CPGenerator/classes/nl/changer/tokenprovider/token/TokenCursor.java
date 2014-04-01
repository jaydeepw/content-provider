package nl.changer.tokenprovider.token;

import java.util.Date;

import android.database.Cursor;

import nl.changer.tokenprovider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code token} table.
 */
public class TokenCursor extends AbstractCursor {
    public TokenCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Get the {@code appname} value.
     * Cannot be {@code null}.
     */
    public String getAppname() {
        Integer index = getCachedColumnIndexOrThrow(TokenColumns.APPNAME);
        return getString(index);
    }

    /**
     * Get the {@code token} value.
     * Cannot be {@code null}.
     */
    public String getToken() {
        Integer index = getCachedColumnIndexOrThrow(TokenColumns.TOKEN);
        return getString(index);
    }
}
