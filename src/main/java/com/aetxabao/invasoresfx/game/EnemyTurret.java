package com.aetxabao.invasoresfx.game;

import com.aetxabao.invasoresfx.sprite.EnemyShip;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

public class EnemyTurret extends EnemyShip {

    public EnemyTurret(Rect gameRect, Image img, int N) {
        super(gameRect, img, N);
    }

    @Override
    public Rect getRect() {
        //hace el objeto mas grande, usando la clase Rect.
        int rectLeft = (int) (x + 0.3 * width);// Calcula la coordenada x del borde izquierdo del rectángulo delimitador
        int rectTop = (int) (y + 0.3 * height);//    "  "   "           y   "       "       "
        int rectRight = (int) (x + 0.7 * width);//borde derecho
        int rectBottom = (int) (y + 0.7 * height);//borde abajo
        return new Rect(rectLeft, rectTop, rectRight, rectBottom);
    }
}
