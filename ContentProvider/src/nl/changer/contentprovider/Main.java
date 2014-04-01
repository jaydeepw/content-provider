package nl.changer.contentprovider;

import java.util.Date;

import nl.changer.tokenprovider.ExampleProvider;
import nl.changer.tokenprovider.token.TokenColumns;
import nl.changer.tokenprovider.token.TokenContentValues;
import nl.changer.tokenprovider.token.TokenCursor;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {

	String TAG = Main.class.getSimpleName();

	private Context mContext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mContext = this;

		initOnStoreClicked();
		initOnListClicked();
	}

	private void initOnListClicked() {
		Button list = (Button) findViewById(R.id.list);
		list.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				listToken();
			}
		});
	}

	protected void listToken() {
		
		String[] projection = new String[] { TokenColumns.APPNAME, TokenColumns.TOKEN};
		Cursor c = getContentResolver().query(TokenColumns.CONTENT_URI, projection, null, null, null);
		TokenCursor cur = new TokenCursor(c);
		
		while (cur.moveToNext()) {
			if(BuildConfig.DEBUG)
				Log.v(TAG, "#listToken: " + cur.getAppname() + " token: " + cur.getToken() );
		}
	}

	private void initOnStoreClicked() {
		Button store = (Button) findViewById(R.id.store);
		store.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				saveToken();
			}
		});
	}

	private void saveToken() {
		TokenContentValues cv = new TokenContentValues();
		cv.putAppname("jaysApp" + (int)(10 * Math.random()) ).putToken("TokenMainHoonDON" + new Date().getTime()).insert(getContentResolver());
		// getContentResolver().insert(TokenColumns.CONTENT_URI, cv);
	}
}