package BackendAssignment011;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.*;

public class Alarm {
	
	LocalDateTime alarmTime;
	
	static Map<Integer, ScheduledFuture<?>> alarmMap = new HashMap<>();
	
	static Map<Integer, LocalDateTime > alarmTimeMap = new HashMap<>();
	
	static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	static int alarmId = 1;

	public Alarm(LocalDateTime alarmTime) {
		
		this.alarmTime = alarmTime;
		
	}

	public LocalDateTime getAlarmTime() {
		
		return alarmTime;
	
	}

	public void setAlarmTime(LocalDateTime alarmTime) {
	
		this.alarmTime = alarmTime;
	
	}
	
	public void setAlarm(LocalDateTime alarmTime) {
		
		long timing = Duration.between(LocalTime.now(), alarmTime).toSeconds();
		
		Runnable alarmTask = () -> {
			
			String audioPath = "/home/thiru-zstk368/Downloads/alarm.wav";
			
			File audioFile = new File(audioPath);
			
			try {
				
				AudioInputStream audio =  AudioSystem.getAudioInputStream(audioFile);
				
				Clip clip = AudioSystem.getClip();
				
				clip.open(audio);
				
				clip.start();
			
			} 
			
			catch (Exception e) {

				System.out.println(e.getMessage());

			}
			
			
			System.out.println("\nAlarm Ringing!\nTime : " + LocalTime.now());
		
		};
		
		ScheduledFuture<?> future = scheduler.schedule(alarmTask, timing, TimeUnit.SECONDS);
		
		alarmMap.put(alarmId, future);

		alarmTimeMap.put(alarmId, alarmTime);
		
		alarmId++;
		
		System.out.println("Alarm set for : " + alarmTime);
		
	}
	
	
	public static void cancelAlarm(int alarmId) {
		
		ScheduledFuture<?> alarmToCancelFuture = alarmMap.get(alarmId);
		
		if(alarmToCancelFuture != null) {
			
			alarmToCancelFuture.cancel(true);
			
			alarmMap.remove(alarmId);
			
			alarmTimeMap.remove(alarmId);
			
			System.out.println("\nAlarm with Alarm Id : " + alarmId + " has been cancelled Successfully.");
			
		}
		
		else {
			
			System.out.println("\nNo alarms found with the given Alarm Id.");
			
		}
		
	}
	
	
	public static void listAlarms() {
		
		if(alarmMap.isEmpty()) {
			
			System.out.println("No alarms has been set yet.");
			
		}
		
		else {
			
			System.out.println("\n----- Active Alarms -----");
			
			for(Map.Entry<Integer, ScheduledFuture<?>> alarmEntry : alarmMap.entrySet()) {
				
				LocalDateTime alarmTime = alarmTimeMap.get(alarmEntry.getKey());
				
				if(alarmTime != null) {
				
					System.out.println("\n----- Alarm Details -----\nAlarm Id : " + alarmEntry.getKey() + "\nAlarm Date : " + alarmTime.toLocalDate() + "\nAlarm Time : " + alarmTime.toLocalTime() + "\n------------------------------");				
				
				}
				
			}
			
		}
		
	}
	
	public static void exitApplication() {
		
		System.out.println("Exitting.....");
		
		scheduler.shutdownNow();
		
	}
	

}
 