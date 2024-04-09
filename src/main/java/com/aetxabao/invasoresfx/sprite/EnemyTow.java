package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.sprite.weaponry.Ametralladora;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

import static com.aetxabao.invasoresfx.game.AppConsts.ebCOL;
import static com.aetxabao.invasoresfx.game.AppConsts.ebROW;

public class EnemyTow extends AEnemy implements IHaveShield{

    private Ametralladora Gun; // El arma del enemigo
    int impactMax; // El máximo de impactos que el enemigo puede recibir antes de ser destruido.
    int impacts; //contador impactos.

    public EnemyTow(Image img,int impactMax) {
        super(img, ebROW, ebCOL);
        this.impactMax = impactMax;
        this.impacts = 0;
        this.weapon = new Ametralladora();// Instancia una nueva ametralladora para el enemigo.
    }

    @Override //actualiza el etado del enemigo
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

    @Override  //metodo representa el área ocupada.
    public Rect getRect() {
        int sliceWidth = width / rows;
        int numSlices = rows - currentFrame;
        int ax = (width - sliceWidth * numSlices) / 2;
        int rectWidth = x + ax + numSlices * sliceWidth;
        return new Rect(x + ax, y, rectWidth, y + height);
    }




}
