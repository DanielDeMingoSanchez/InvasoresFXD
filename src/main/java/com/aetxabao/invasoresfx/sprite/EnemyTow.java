package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

public class EnemyTow extends AEnemy implements IHaveShield{

    int impactMax;
    int impacts;

    public EnemyTow(Image img, int rows, int cols, int impactMax) {
        super(img, rows, cols);
        this.impactMax = impactMax;
    }

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

    @Override
    public Rect getRect() {
        int sliceWidth = width / rows;
        int numSlices = rows - currentFrame;
        int ax = (width - sliceWidth * numSlices) / 2;
        int rectWidth = x + ax + numSlices * sliceWidth;
        return new Rect(x + ax, y, rectWidth, y + height);
    }



}
