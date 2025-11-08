package Proxy;

import Proxy.Concrete_Video_Service.RealVideoService;

public class Main {
    public static void main(String[] args) {
        RealVideoService realVideoService = new RealVideoService();
        ProxyVideoService proxyVideoService = new ProxyVideoService(realVideoService);
        proxyVideoService.playVideo("FREE", "FREE Video 1");
        proxyVideoService.playVideo("PREMIUM", "PREMIUM Video 1");
        proxyVideoService.playVideo("GUEST", "Video 1");
        for (int i = 0; i < 6; i++) {
            proxyVideoService.playVideo("FREE", "Free Video 2");
        }
    }
}
