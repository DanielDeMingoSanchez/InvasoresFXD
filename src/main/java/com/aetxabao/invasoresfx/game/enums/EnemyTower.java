// Paquete que pertenece la clase.
package com.aetxabao.invasoresfx.game.enums;

import com.aetxabao.invasoresfx.sprite.AEnemy;
import com.aetxabao.invasoresfx.sprite.EnemyTow;
import com.aetxabao.invasoresfx.sprite.IHaveShield;
import com.aetxabao.invasoresfx.sprite.weaponry.Ametralladora;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;
import static com.aetxabao.invasoresfx.game.AppConsts.eROW;
import static com.aetxabao.invasoresfx.game.AppConsts.eCOL;

public class EnemyTower extends EnemyTow {

    public EnemyTower(Image img, int impactMax) {
        super(img, impactMax);
        rows = eROW; // número de filas basado en una constante.
        cols = eCOL; // número de columnas basado en una constante.
        if (img!=null) { // Si la imagen no es nula, calcula el ancho y alto de cada sprite basado en la imagen completa y el número de filas y columnas.
            this.width = (int) (img.getWidth() / cols);
            this.height = (int) (img.getHeight() / rows);
        }
        setWeapon(new Ametralladora());// Asigna una Ametralladora como arma del enemigo.
    }

    @Override
    public Rect getRect(){// devuelve un rectángulo ligeramente más pequeño que el tamaño total del sprite.
        return new Rect((int) (x + 0.2*width), (int) (y + 0.2*height), (int) (x + 0.8*width), (int) (y + 0.8*height));
    }

}
