package io.trigger.forge.android.modules.keychain;

import io.trigger.forge.android.core.ForgeApp;
import io.trigger.forge.android.core.ForgeParam;
import io.trigger.forge.android.core.ForgeTask;

import java.util.Map.Entry;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class API {
	private static final String keychain_NAME = "PACKAGE_NAME_HERE";

	private static SharedPreferences getStorage(ForgeTask task) {
		return ForgeApp.getActivity().getSharedPreferences(keychain_NAME, 0);
	}

	public static void get(final ForgeTask task, @ForgeParam("key") final String key) {
		task.success(getStorage(task).getString(key, "null"));
	}

	public static void set(final ForgeTask task, @ForgeParam("key") final String key, @ForgeParam("value") final String value) {
		Editor ed = getStorage(task).edit();
		ed.putString(key, value);
		ed.commit();
		task.success();
	}

	public static void all(final ForgeTask task) {
		JsonObject keychain = new JsonObject();
		for (Entry<String, ?> pref : getStorage(task).getAll().entrySet()) {
			keychain.addProperty(pref.getKey(), (String)pref.getValue());
		}
		task.success(keychain);
	}

	public static void keys(final ForgeTask task) {
		JsonArray keys = new JsonArray();
		for (Entry<String, ?> pref : getStorage(task).getAll().entrySet()) {
			keys.add(new JsonPrimitive(pref.getKey()));
		}
		task.success(keys);
	}

	public static void clear(final ForgeTask task, @ForgeParam("key") final String key) {
		Editor ed = getStorage(task).edit();
		ed.remove(key);
		ed.commit();
		task.success();
	}

	public static void clearAll(final ForgeTask task) {
		Editor ed = getStorage(task).edit();
		ed.clear();
		ed.commit();
		task.success();
	}
}
