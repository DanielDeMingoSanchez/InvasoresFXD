package com.aetxabao.invasoresfx.game;

import com.aetxabao.invasoresfx.game.enums.EEnemyShot;
import com.aetxabao.invasoresfx.game.enums.EEnemyType;
import com.aetxabao.invasoresfx.game.enums.EnemyTower;
import com.aetxabao.invasoresfx.sprite.*;
import com.aetxabao.invasoresfx.sprite.weaponry.Gun;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.aetxabao.invasoresfx.game.AppConsts.*;
import static com.aetxabao.invasoresfx.game.enums.EEnemyShot.*;
import static com.aetxabao.invasoresfx.game.enums.EEnemyType.*;

public class EnemySpawner {

    //region attributes
    public static int n = 8;
    public static int m = 16;
    public static int vx = 5;
    public static int vy = 3;
    public static int ticks = 100;
    //endregion

    /**
     * Transforma una coordenada en una posición
     * @param i coordenada de 0 a n eje horizontal
     * @return posicion x
     */
    private static int getX(Rect gameRect, int i){
        return gameRect.left + i*gameRect.width()/ n;
    }

    /**
     * Transforma una coordenada en una posición
     * @param j coordenada de 0 a m eje vertical
     * @return posicion y
     */
    private static int getY(Rect gameRect, int j){
        return gameRect.top + j*gameRect.height()/ m;
    }

    public static List<AEnemy> createEnemies(Rect gameRect, int level) {
        List<AEnemy> enemies = new ArrayList<>();
        level = level % LEVELS;

        switch (level) {   //Aquí se crean los niveles ( 1,2,3,4...)
            case 1:
                enemies = crearEnemigosNivelDonut(gameRect); //los enemigos que tendra el nivel
                break;
            case 2:
                enemies = crearEnemigosNivelPaquito(gameRect);
                break;
            case 3:
                enemies = crearEnemigosNivelPulpo(gameRect);
                break;
            default:
                enemies = crearEnemigosMios(gameRect);
        }

        // Comprueba si no hay enemigos o se han eliminado todos
        if (enemies.isEmpty()) {
            // Incrementamos level para que pase al siguiente nivel
            level = (level % LEVELS) + 1;
        }

        return enemies;
    }

    /**
     * Crea un enemigo en una coordenada (i,j) con una velocidad (vx,vy)
     * @param i coordenada horizontal
     * @param j coordenada vertical
     * @param vx velocidad eje x
     * @param vy velocidad eje y
     * @return una instancia del enemigo
     */
    public static EnemyShip createEnemyShip(EEnemyType type, Image enemyImage, Rect gameRect, int i, int j, int vx, int vy, EEnemyShot shot) {
        EnemyShip e;
        switch (type){
            case E_DIAGONAL:
                e = new EnemyShipDiagonal(gameRect, enemyImage, TICKSxFRAME);
                break;
            case E_TOWER:
                e = new EnemyTurret(gameRect, enemyImage, TICKSxFRAME);
                break;
            case E_NORMAL:
                e = new EnemyShip(gameRect, enemyImage, TICKSxFRAME);
                break;
            case E_ROCKET:
            default:
                e = new EnemyShipR(gameRect, enemyImage, TICKSxFRAME);
                break;
        }
        if (shot == E_SHOT_GUN){
            e.setWeapon(new Gun());
        }
        e.setPos(getX(gameRect, i), getY(gameRect, j));
        e.setXSpeed(vx);
        e.setYSpeed(vy);
        return e;
    }

    public static List<AEnemy> crearEnemigosNivelDonut(Rect gameRect) {
        List<AEnemy> enemies = new ArrayList<>();
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 0, 0, vx, 0, E_SHOT_GUN));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 7, 1, -vx, 0, E_SHOT_GUN));
        List<EnemyShip> el1 = new ArrayList<>();
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 2, 3, 0, 0, E_SHOT_NOTHING));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 3, 2, 0, 0, E_SHOT_NOTHING));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 4, 2, 0, 0, E_SHOT_NOTHING));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 5, 3, 0, 0, E_SHOT_NOTHING));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 2, 4, 0, 0, E_SHOT_NOTHING));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 3, 5, 0, 0, E_SHOT_NOTHING));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 4, 5, 0, 0, E_SHOT_NOTHING));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_3, gameRect, 5, 4, 0, 0, E_SHOT_NOTHING));
        EnemyShipGroup eg1 = new EnemyShipGroup(gameRect, el1);
        eg1.setXSpeed(vx);
        enemies.add(eg1);
        return enemies;
    }

    public static List<AEnemy> crearEnemigosNivelPaquito(Rect gameRect) {
        List<AEnemy> enemies = new ArrayList<>();
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 0, 0, vx, 0, E_SHOT_GUN));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 7, 1, -vx, 0, E_SHOT_GUN));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 3, 2, vx, 0, E_SHOT_GUN));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 4, 3, -vx, 0, E_SHOT_GUN));
        List<EnemyShip> el1 = new ArrayList<>();
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 2, 4, vx, 0, E_SHOT_NOTHING));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 3, 4, vx, 0, E_SHOT_NOTHING));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 4, 4, vx, 0, E_SHOT_NOTHING));
        el1.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_1, gameRect, 5, 4, vx, 0, E_SHOT_NOTHING));
        EnemyShipGroup eg1 = new EnemyShipGroup(gameRect, el1);
        eg1.setXSpeed(vx);
        enemies.add(eg1);
        return enemies;
    }

    public static List<AEnemy> crearEnemigosNivelPulpo(Rect gameRect) {
        List<AEnemy> enemies = new ArrayList<>();
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 0, 0, vx, 0, E_SHOT_GUN));
        enemies.add(createEnemyShip(E_NORMAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 7, 1, -vx, 0, E_SHOT_GUN));
        enemies.add(createEnemyShip(E_DIAGONAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 0, 0, vx, vy, E_SHOT_NOTHING));
        enemies.add(createEnemyShip(E_DIAGONAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 7, 0, -vx, vy, E_SHOT_NOTHING));
        enemies.add(createEnemyShip(E_DIAGONAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 3, 0, -vx, vy, E_SHOT_NOTHING));
        enemies.add(createEnemyShip(E_DIAGONAL, ENEMYSHIP_SPRITE_IMAGE_2, gameRect, 4, 0, vx, vy, E_SHOT_NOTHING));
        return enemies;
    }

    public static List<AEnemy> crearEnemigosMios(Rect gameRect) { //Metodo de nuestros bichos.
        List<AEnemy> enemies = new ArrayList<>(); //se almacena
        // Espacio entre enemigos
        int espacioHorizontal = 1;
        int espacioVertical = 1;
        ArrayList<ArrayList<Integer>> laberinto = new ArrayList<ArrayList<Integer>>();
        // laberinto
        laberinto.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0, 0, 0, 1, 1, 1)));
        laberinto.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1, 1, 0, 0, 0, 1)));
        laberinto.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 1, 0, 1, 1, 0, 1)));
        laberinto.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 1, 0, 1, 0, 0, 1)));
        laberinto.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 0, 1, 1)));
        laberinto.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 0, 0, 1, 0, 0, 1)));
        laberinto.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 0, 1)));
        laberinto.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 1, 0, 0, 0, 0, 1)));
        laberinto.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 1, 1)));
        laberinto.add(new ArrayList<>(Arrays.asList(0, 0, 1, 0, 0, 0, 1, 0, 0, 0)));


        // Velocidad del enemigo
        int velocidad = 1;
        // Generar enemigos según el diseño del laberinto
        for (int fila = 0; fila < laberinto.size(); fila++) {
            for (int columna = 0; columna < laberinto.get(fila).size(); columna++) {
                if (laberinto.get(fila).get(columna) == 1) {  //si es 1 se añade el enemigo.
                    // Calcular las coordenadas X e Y del enemigo
                    int posX = columna * espacioHorizontal;
                    int posY = fila * espacioVertical;
                    // Agregar el enemigo a la lista
                    enemies.add(eBarrera(E_BARRIERDOWN, ENEMYSHIP_SPRITE_IMAGE_2, 60, gameRect, posX, posY, velocidad));
                }
            }
        }
        return enemies;

    }



    public static EnemyTow eBarrera(EEnemyType type, Image enemyImage, int impactsMax, Rect gameRect, int i, int j, int vy) {
        EnemyTow e;
        switch (type){
            case    E_TOWER:
                e = new EnemyTower(enemyImage, impactsMax);
                break;
            case E_BARRIERDOWN:
                e = new sinBarrera(enemyImage, impactsMax, vy);
                break;
            case E_BARRIER:
            default:
                e = new EnemyTow(enemyImage, impactsMax);
                break;
        }
        e.setPos(getX(gameRect, i), getY(gameRect, j));
        return e;
    }


    }

