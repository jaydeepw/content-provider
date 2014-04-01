package nl.changer.tokenprovider.token;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import nl.changer.tokenprovider.base.AbstractSelection;

/**
 * Selection for the {@code token} table.
 */
public class TokenSelection extends AbstractSelection<TokenSelection> {
    @Override
    public Uri uri() {
        return TokenColumns.CONTENT_URI;
    }
    
    /**
     * Query the given content resolver using this selection.
     * 
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code TokenCursor} object, which is positioned before the first entry, or null.
     */
    public TokenCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new TokenCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null}.
     */
    public TokenCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null}.
     */
    public TokenCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }
    
    
    public TokenSelection id(long... value) {
        addEquals(TokenColumns._ID, toObjectArray(value));
        return this;
    }

    public TokenSelection appname(String... value) {
        addEquals(TokenColumns.APPNAME, value);
        return this;
    }
    
    public TokenSelection appnameNot(String... value) {
        addNotEquals(TokenColumns.APPNAME, value);
        return this;
    }


    public TokenSelection token(String... value) {
        addEquals(TokenColumns.TOKEN, value);
        return this;
    }
    
    public TokenSelection tokenNot(String... value) {
        addNotEquals(TokenColumns.TOKEN, value);
        return this;
    }

}
