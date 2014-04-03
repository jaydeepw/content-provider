module("forge.keychain");

var keychainBackup;

/*
asyncTest("Clear keychain", 1, function() {
	forge.keychain.clearAll(function () {
		forge.keychain.keys(function (keys) {
			deepEqual(keys, [], "No keychain set");
			start();
		});
	});
});
*/


asyncTest("Set and get a pref (Number)", 1, function() {
	var pref = "test"+Math.random();
	// Random value to make sure nothing is being persisted somehow
	var value = Math.random();
	forge.keychain.set(pref, value, function () {
		forge.keychain.get(pref, function (newValue) {
			equal(newValue, value, "Preference value which was set");
			start();
		});
	});
});

asyncTest("Set and get a pref (Object)", 2, function() {
	var pref = "test"+Math.random();
	// Random value to make sure nothing is being persisted somehow
	var value = {
		value: Math.random(),
		other: "s†®îñg"
	};
	forge.keychain.set(pref, value, function () {
		forge.keychain.get(pref, function (newValue) {
			equal(newValue.other, value.other, "Preference value which was set");
			equal(newValue.value, value.value, "Preference value which was set");
			start();
		});
	});
});

asyncTest("Set and get a pref (undefined)", 1, function() {
	var pref = "test"+Math.random();
	var value = undefined;
	forge.keychain.set(pref, value, function () {
		forge.keychain.get(pref, function (newValue) {
			equal(newValue, value, "Preference value which was set");
			start();
		});
	});
});


asyncTest("Set and get a pref (null)", 1, function() {
	var pref = "test"+Math.random();
	var value = null;
	forge.keychain.set(pref, value, function () {
		forge.keychain.get(pref, function (newValue) {
			equal(newValue, value, "Preference value which was set");
			start();
		});
	});
});

asyncTest("Set and clear a pref", 1, function() {
	var pref = "test"+Math.random();
	var value = "test"+Math.random();
	forge.keychain.set(pref, value, function () {
		forge.keychain.clear(pref, function () {
			forge.keychain.get(pref, function (newValue) {
				equal(newValue, null, "Preference which was cleared");
				start();
			});
		});
	});
});

asyncTest("Set and keys", 1, function() {
	var pref = Math.random().toString();
	var value = "test"+Math.random();
	forge.keychain.clearAll(function () {
		forge.keychain.set(pref, value, function () {
			forge.keychain.keys(function (keys) {
				ok(keys.indexOf(pref)!=-1, "Set keys");
				start();
			});
		});
	});
});

asyncTest("Set with non-string key", 1, function() {
	var pref = Math.random();
	var value = "test"+Math.random();
	forge.keychain.set(pref, value, function () {
		ok(true, "Didn't fail");
		start();
	});
});
