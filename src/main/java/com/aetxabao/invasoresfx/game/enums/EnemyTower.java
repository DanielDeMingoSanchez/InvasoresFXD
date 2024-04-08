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
        rows = eROW;
        cols = eCOL;
        if (img!=null) {
            this.width = (int) (img.getWidth() / cols);
            this.height = (int) (img.getHeight() / rows);
        }
        setWeapon(new Ametralladora());
    }

    @Override
    public Rect getRect(){
        return new Rect((int) (x + 0.2*width), (int) (y + 0.2*height), (int) (x + 0.8*width), (int) (y + 0.8*height));
    }

}
