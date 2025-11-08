package Proxy;

import java.util.HashMap;
import java.util.Map;

import Proxy.Concrete_Video_Service.RealVideoService;

public class ProxyVideoService implements VideoService{
    private final RealVideoService realVideoService;
    private final Map<String, String> cachedVideos;
    private final Map<String, Integer> requestCount;

    public ProxyVideoService(RealVideoService realVideoService) {
        this.realVideoService = realVideoService;
        this.cachedVideos = new HashMap<>();
        this.requestCount = new HashMap<>();
    }

    @Override
    public void playVideo(String userType, String videoName) {
        if(!userType.equals("PREMIUM") && videoName.startsWith("PREMIUM")) {
            System.out.println("Access Denied. PREMIUM video is only available for PREMIUM user.");
        }
        requestCount.put(userType, requestCount.getOrDefault(userType, 0) + 1);
        if(requestCount.get(userType) > 5) {
            System.out.println("Too many request.");
            return;
        }
        if(cachedVideos.containsKey(videoName)) {
            System.out.println("Streaming cached video - " + videoName);
        } else {
            realVideoService.playVideo(userType, videoName);
            cachedVideos.put(videoName,videoName);
        }
    }

}
