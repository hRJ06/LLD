package FlyWeight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ParticleTypeFactory factory = new ParticleTypeFactory();
        List<Particle> particles = new ArrayList<>();
        ParticleType explosionType = factory.gParticleType("red", "explosion.png");
        for(int i = 0; i<10; i++) {
            particles.add(new Particle(explosionType, (float) Math.random() * 100, (float) Math.random() * 100, 1.0f));
        }
        for(Particle p : particles) {
            p.update();
        }
    }
}
