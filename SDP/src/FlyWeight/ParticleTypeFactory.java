package FlyWeight;

import java.util.HashMap;
import java.util.Map;

public class ParticleTypeFactory {
    private Map<String, ParticleType> particleTypes = new HashMap<>();
    public ParticleType gParticleType(String color, String sprite) {
        String key = color + "_" + sprite;
        return particleTypes.computeIfAbsent(key, k -> new ParticleType(color, sprite));
    }
}