package Facade.Concrete_Device;

public class MusicPlayer {
    public void initializeAudioDrivers() {
        System.out.println("Initializing Audio drivers.");
    }

    public void decodeAudio() {
        System.out.println("Decoding Audio file.");
    }

    public void startPlayback() {
        System.out.println("Starting Audio playback.");
    }
}
