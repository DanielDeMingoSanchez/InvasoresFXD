package com.aetxabao.invasoresfx.game.enums;

import com.aetxabao.invasoresfx.sprite.AEnemy;
import com.aetxabao.invasoresfx.sprite.EnemyTow;
import com.aetxabao.invasoresfx.sprite.IHaveShield;
import com.aetxabao.invasoresfx.sprite.weaponry.Ametralladora;
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

}
