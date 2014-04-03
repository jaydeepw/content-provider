module("forge.keychain");

asyncTest("Set and get a pref", 1, function() {
	var pref = "test"+Math.random();
	var value = prompt("Enter a value");
	forge.keychain.set(pref, value, function () {
		forge.keychain.get(pref, function (newValue) {
			ok(confirm("Was '"+newValue+"' your value?"));
			start();
		});
	});
});
