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

UICKeyChainStore *store;

__attribute__((constructor))
void __init() {
    store = [UICKeyChainStore keyChainStoreWithService:@"nl.changer"];
}

+ (void)getString:(ForgeTask*)task key:(NSString *)key {
	NSString *value = [store stringForKey:key];
    [task success:value];
}

+ (void)setString:(ForgeTask*)task key:(NSString *)key value:(NSString *)value {
    [store setString:value forKey:key];
    [store synchronize];
	[task success:nil];
}

+ (void)getData:(ForgeTask*)task key:(NSString *)key {
	NSData *data = [store dataForKey:key];
    NSDictionary *value = (NSDictionary*) [NSKeyedUnarchiver unarchiveObjectWithData:data];
	[task success:value];
}

+ (void)setData:(ForgeTask*)task key:(NSString *)key value:(NSDictionary *)value {
    NSData *data = [NSKeyedArchiver archivedDataWithRootObject:value];
    [store setData:data forKey:key];
    [store synchronize];
	[task success:nil];
}

+ (void)clear:(ForgeTask*)task key:(NSString *)key {
    [store removeItemForKey:key];
    [store synchronize];
	[task success:nil];
}

+ (void)clearAll:(ForgeTask*)task {
    [store removeAllItems];
    [store synchronize];
	[task success:nil];
}

@end
