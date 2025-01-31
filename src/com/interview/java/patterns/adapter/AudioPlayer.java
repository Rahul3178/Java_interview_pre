package com.interview.java.patterns.adapter;

interface MediaPlayer{
	void play(String fileType,String fileName);
}

class VLCPlayer{
	
	public void playVLC(String fileName) {
		System.out.println("Palying VLC media type file"+ fileName);
	}
}


class MediaAdapter implements MediaPlayer{
	
	public VLCPlayer vlcPlayer;
	@Override
	public void play(String fileType, String fileName) {
		if(fileType.equalsIgnoreCase("vlc")) {
			vlcPlayer=new VLCPlayer();
			vlcPlayer.playVLC(fileName);
		}else {
			System.out.println("File Type not Supported");
		}
	}
}

public class AudioPlayer implements MediaPlayer{
	public MediaAdapter madapter;
	
	@Override 
	public void play(String fileType, String fileName) {
		if(fileType.equalsIgnoreCase("vuc")) {
			madapter = new MediaAdapter();
			madapter.play(fileType, fileName);
		}else {
			System.out.println("Invalid media type: "+fileType);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		AudioPlayer ap= new AudioPlayer();
		ap.play("vlc","example.vlc");
	}


}
