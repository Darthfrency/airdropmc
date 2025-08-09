package com.darth.airdropmc;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.level.ServerLevel;

public class CallBackScheduler {
	public static List<DelayableCallBack> Tasks= new ArrayList<DelayableCallBack>(); 
	public static void registerCallBack(ServerLevel level,DelayableCallBack callback, long delay) {
		callback.TimeToCall= level.getGameTime()+delay;
		System.out.println("Registered callback with delay:"+delay/20 +"s");
		
		Tasks.add(callback);
	}
	public static void run(ServerLevel level) {
		for (int i = 0; i<Tasks.size();i++) {
			DelayableCallBack delayableCallBack = Tasks.get(i);
			if (level.getGameTime()>= delayableCallBack.TimeToCall) {
				System.out.println("Called callback");
				delayableCallBack.call(level);
				Tasks.remove(delayableCallBack);
			}
		}
	}
}
