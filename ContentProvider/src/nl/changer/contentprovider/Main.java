package nl.changer.contentprovider;

import nl.changer.tokenprovider.token.TokenColumns;
import nl.changer.tokenprovider.token.TokenContentValues;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
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
		cv.putAppname("jaysApp").putAppname("TokenMainHoonDONw80nasdkfnlinas98f092").insert(getContentResolver());
		// getContentResolver().insert(TokenColumns.CONTENT_URI, cv);
	}
}