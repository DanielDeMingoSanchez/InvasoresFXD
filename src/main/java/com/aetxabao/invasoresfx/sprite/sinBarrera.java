package com.aetxabao.invasoresfx.sprite;

import javafx.scene.image.Image;

public class sinBarrera extends EnemyTow {

    public sinBarrera(Image img, int impactMax, int ySpeed) {
        super(img, impactMax);
        this.ySpeed = ySpeed;
    }

    @Override
    public void update() {
        y = y + ySpeed;
        updateFrame();
    }


}
