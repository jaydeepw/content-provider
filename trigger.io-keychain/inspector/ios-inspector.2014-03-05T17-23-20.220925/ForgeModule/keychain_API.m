//
//  keychain_API.m
//  Forge
//
//  Created by Ruben Stolk on 5/03/2014.
//  Copyright (c) 2014 Changer All rights reserved.
//

#import "keychain_API.h"
#import "UICKeyChainStore.h"

@implementation keychain_API

+ (void)get:(ForgeTask*)task key:(NSString *)key {
    UICKeyChainStore *store = [UICKeyChainStore keyChainStore];
	NSString *pref = [store stringForKey:key];
	[task success:pref];
}

+ (void)set:(ForgeTask*)task key:(NSString *)key value:(NSString *)value {
    UICKeyChainStore *store = [UICKeyChainStore keyChainStore];
    [store setString:value forKey:key];
    [store synchronize];
	[task success:nil];
}

+ (void)clear:(ForgeTask*)task key:(NSString *)key {
    UICKeyChainStore *store = [UICKeyChainStore keyChainStore];
    [store removeItemForKey:key];
    [store synchronize];
	[task success:nil];
}

+ (void)clearAll:(ForgeTask*)task {
    UICKeyChainStore *store = [UICKeyChainStore keyChainStore];
    [store removeAllItems];
    [store synchronize];
	[task success:nil];
}

@end
