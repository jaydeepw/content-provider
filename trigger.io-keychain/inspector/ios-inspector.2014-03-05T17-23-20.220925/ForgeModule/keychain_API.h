//
//  keychain_API.h
//  Forge
//
//  Created by Ruben Stolk on 5/03/2014.
//  Copyright (c) 2014 Changer All rights reserved.
//

#import <Foundation/Foundation.h>

@interface keychain_API : NSObject

+ (void)get:(ForgeTask*)task key:(NSString *)key;
+ (void)set:(ForgeTask*)task key:(NSString *)key value:(NSString *)value;
+ (void)clear:(ForgeTask*)task key:(NSString *)key;
+ (void)clearAll:(ForgeTask*)task;

@end
