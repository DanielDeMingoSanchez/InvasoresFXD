package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

import static com.aetxabao.invasoresfx.game.AppConsts.ebCOL;
import static com.aetxabao.invasoresfx.game.AppConsts.ebROW;

public class EnemyTow extends AEnemy implements IHaveShield{

    int impactMax;
    int impacts;

    public EnemyTow(Image img,int impactMax) {
        super(img, ebROW, ebCOL);
        this.impactMax = impactMax;
        this.impacts = 0;
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
        //contador de impactos
        impacts++;
        updateFrame();
        return impacts==impactMax;
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
