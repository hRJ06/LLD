package Facade.Media_Facade;

import Facade.Concrete_Device.ImageViewer;
import Facade.Concrete_Device.MusicPlayer;
import Facade.Concrete_Device.VideoPlayer;

public class MediaFacade {
    private ImageViewer imageViewer;
    private MusicPlayer musicPlayer;
    private VideoPlayer videoPlayer;

    public MediaFacade() {
        this.imageViewer = new ImageViewer();
        this.musicPlayer = new MusicPlayer();
        this.videoPlayer = new VideoPlayer();
    }

    public void performAction(String action) {
        switch (action) {
            case "PLAY_MUSIC" -> {
                musicPlayer.initializeAudioDrivers();
                musicPlayer.decodeAudio();
                musicPlayer.startPlayback();
            }
            case "PLAY_VIDEO" -> {
                videoPlayer.setupRenderingEngine();
                videoPlayer.loadVideoFile();
                videoPlayer.playVideo();
            }
            case "VIEW_IMAGE" -> {
                imageViewer.loadImageFile();
                imageViewer.applyScaling();
                imageViewer.displayImage();
            }
            default -> System.out.println("Invalid Action.");
        }
    }
}
