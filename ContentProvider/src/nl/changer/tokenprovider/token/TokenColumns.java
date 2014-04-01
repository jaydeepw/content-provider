package nl.changer.tokenprovider.token;

import android.net.Uri;
import android.provider.BaseColumns;

import nl.changer.tokenprovider.TokenProvider;

/**
 * Columns for the {@code token} table.
 */
public interface TokenColumns extends BaseColumns {
    String TABLE_NAME = "token";
    Uri CONTENT_URI = Uri.parse(TokenProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    String _ID = BaseColumns._ID;
    String APPNAME = "appname";
    String TOKEN = "token";

    String DEFAULT_ORDER = _ID;

	// @formatter:off
    String[] FULL_PROJECTION = new String[] {
            _ID,
            APPNAME,
            TOKEN
    };
    // @formatter:on
}