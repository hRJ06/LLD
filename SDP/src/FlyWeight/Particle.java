package FlyWeight;

public class Particle {
    private ParticleType type; /* REFERENCE TO FLYWEIGHT */
    private float x;
    private float y;
    private float velocity;

    public Particle(ParticleType particleType, float x, float y, float velocity) {
        this.type = particleType;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
    }

    public void update() {
        y += velocity;
        type.render(x, y, velocity);
    }
}
