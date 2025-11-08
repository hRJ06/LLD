package Proxy.Concrete_Video_Service;

import Proxy.VideoService;

public class RealVideoService implements VideoService{

    @Override
    public void playVideo(String userType, String videoName) {
        System.out.println("Streaming video - " + videoName + " for user type - " + userType);
    }

}
