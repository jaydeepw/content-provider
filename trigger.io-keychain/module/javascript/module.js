forge['keychain'] = {
	/**
	 * Get a preference stored by your application.
	 *
	 * @param {string} key The key of your preference.
	 * @param {function(string)=} success
	 * @param {function({message: string}=} error
	 */
	'getString': function (key, success, error) {
		forge.internal.call("keychain.getString", {
			key: key.toString()
		}, success && function (value) {
			if (value === "undefined") {
				value = undefined;
			} else {
				try {
					value = JSON.parse(value);
				} catch (e) {
					error({
						message: e.toString()
					});
					return;
				}
			}
			success(value);
		}, error);
	},
	/**
	 * Set a preference.
	 *
	 * @param {string} key The preference key.
	 * @param {string} value The preference value.
	 * @param {function()=} success
	 * @param {function({message: string}=} error
	 */
	'setString': function (key, value, success, error) {
		if (value === undefined) {
			value = "undefined";
		} else {
			value = JSON.stringify(value);
		}
		forge.internal.call("keychain.setString", {
			key: key.toString(),
			value: value
		}, success, error);
	},
	/**
	 * Get a preference stored by your application.
	 *
	 * @param {string} key The key of your preference.
	 * @param {function(string)=} success
	 * @param {function({message: string}=} error
	 */
	'getData': function (key, success, error) {
		forge.internal.call("keychain.getData", {
			key: key.toString()
		}, success && function (value) {
			if (value === "undefined") {
				value = undefined;
			} else {
				try {
					value = JSON.parse(value);
				} catch (e) {
					error({
						message: e.toString()
					});
					return;
				}
			}
			success(value);
		}, error);
	},
	/**
	 * Set a preference.
	 *
	 * @param {string} key The preference key.
	 * @param {string} value The preference value.
	 * @param {function()=} success
	 * @param {function({message: string}=} error
	 */
	'setData': function (key, value, success, error) {
		if (value === undefined) {
			value = "undefined";
		} else {
			value = JSON.stringify(value);
		}
		forge.internal.call("keychain.setData", {
			key: key.toString(),
			value: value
		}, success, error);
	},
	/**
	 * Expunge a single persisted setting, reverting it back to its default value (if available).
	 *
	 * @param {string} key Preference to forget.
	 * @param {function()=} success
	 * @param {function({message: string}=} error
	 */
	'clear': function(key, success, error) {
		forge.internal.call("keychain.clear", {
			key: key.toString()
		}, success, error);
	},
	/**
	 * Expunge all persisted settings, reverting back to defaults (if available).
	 *
	 * @param {function()=} success
	 * @param {function({message: string}=} error
	 */
	'clearAll': function(success, error) {
		forge.internal.call("keychain.clearAll", {}, success, error);
	}
};
