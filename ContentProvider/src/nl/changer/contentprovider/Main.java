package nl.changer.contentprovider;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class Main extends Activity {
	
	String TAG = Main.class.getSimpleName();
	
	private Context mContext;
	
    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mContext = this;
    }
}