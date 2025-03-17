package com.interview.java.patterns.solid;



class NotificationService{
	
	private NotificationChannel channel;
	
	public NotificationService(NotificationChannel channel) {
		this.channel=channel;
	}
	
	public void notify(String msg)
	{
		channel.sendNotification(msg);
	}
}



interface NotificationChannel{
	
	void sendNotification(String msg);
}

class EmailService implements NotificationChannel{

	@Override
	public void sendNotification(String msg) {
		
		System.out.println("Sending email notification ... "+msg);
		
	}
	
}

class SMSService implements NotificationChannel{

	@Override
	public void sendNotification(String msg) {
		
		System.out.println("Sending SMS notification ..."+msg);
		
	}
	
}

public class DependencyInversion {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		NotificationService email= new NotificationService(new EmailService());
		email.notify("Email");
		NotificationService sms= new NotificationService(new SMSService());
		sms.notify("SMS");
		
		
		

	}

}
