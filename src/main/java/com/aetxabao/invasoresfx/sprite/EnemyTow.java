package com.aetxabao.invasoresfx.sprite;

public class EnemyTow extends AEnemy implements IHaveShield{

    int impactMax;
    int impacts;
    @Override
    public void update() {
        updateFrame();
    }

    public void updateFrame(){
        int impactsPerFrame = impactMax / (rows - 1); //Nº de impactos en la imagen
        currentFrame = impacts / impactsPerFrame; //resultado del marco.
        if (currentFrame >= rows - 1) currentFrame = rows - 2;//comprueba si la imagen se excede o no.
    }

    @Override
    public boolean impact() {
        return false;
    }
}
