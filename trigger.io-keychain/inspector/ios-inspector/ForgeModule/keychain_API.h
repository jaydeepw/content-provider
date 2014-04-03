//
//  keychain_API.h
//  Forge
//
//  Created by Ruben Stolk on 5/03/2014.
//  Copyright (c) 2014 Changer All rights reserved.
//

#import <Foundation/Foundation.h>

@interface keychain_API : NSObject

+ (void)getString:(ForgeTask*)task key:(NSString *)key;
+ (void)setString:(ForgeTask*)task key:(NSString *)key value:(NSString *)value;
+ (void)getData:(ForgeTask*)task key:(NSString *)key;
+ (void)setData:(ForgeTask*)task key:(NSString *)key value:(NSData *)value;
+ (void)clear:(ForgeTask*)task key:(NSString *)key;
+ (void)clearAll:(ForgeTask*)task;

@end
