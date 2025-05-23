package LowLevelDesign.DesignPatterns.Structural.ProxyDesignPattern.SomeCoolMediaLibrary;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideos();
    Video getVideo(String videoId);
}