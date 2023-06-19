package sk.tuke.gamestudio.game.lightsout.core;

public class Light {
    private LightState state;

    public Light(LightState state){
        this.state = state;
    }

    public LightState getState() {
        return state;
    }

    public void setState(LightState state) {
        this.state = state;
    }
}
