``keychain``: Preferences
======================

The ``forge.keychain`` namespace allows you to save state in your app. State is persisted
between restarts and is consistent across different pages in your app.

##API

!method: forge.keychain.get(name, success, error)
!param: name `string` the name of the preference you want to query
!param: success `function(value)` will be invoked as the preference value as its only parameter
!description: If the preference has not been set (with [forge.keychain.set](index.html#forgekeychainsetname-value-success-error)), and there is no default value for this preference, ``null`` is returned.
!platforms: iOS, Android, Web
!param: error `function(content)` called with details of any error which may occur

!method: forge.keychain.set(name, value, success, error)
!param: name `string` the name of the preference you want to save
!param: name `value` the value to save
!param: success `function()` callback to be invoked when no errors occurs
!description: The preference value given here will override a default value (if one was given).
!platforms: iOS, Android, Web
!param: error `function(content)` called with details of any error which may occur

!method: forge.keychain.clear(name, success, error)
!param: name `string` the name of the preference you want to un-set
!param: success `function()` a callback to be invoked (with no arguments) when the operation is complete
!description: Un-sets the given preference name, so that future calls to [forge.keychain.get](index.html#forgekeychaingetname-success-error) will return ``undefined`` (or the default preference value, if given).
!platforms: iOS, Android, Web
!param: error `function(content)` called with details of any error which may occur

!method: forge.keychain.clearAll(success, error)
!param: success `function()` callback to be invoked when no errors occurs
!description: Un-sets all preference names, so that calls to [forge.keychain.get](index.html#forgekeychaingetname-success-error) will return ``undefined`` (or the default value for a preference, if given).
!platforms: iOS, Android, Web
!param: error `function(content)` called with details of any error which may occur

!method: forge.keychain.keys(success, error)
!param: success `function(keysArray)` invoked with an array of the set key names as its only argument
!description: Find which preferences have been set.
!platforms: iOS, Android, Web
!param: error `function(content)` called with details of any error which may occur
