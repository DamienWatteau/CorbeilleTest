package jpu2016.dogfight.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import jpu2016.dogfight.model.Direction;
import jpu2016.dogfight.model.IDogfightModel;
import jpu2016.dogfight.model.IMobile;
import jpu2016.dogfight.model.Missile;
import jpu2016.dogfight.model.Position;
import jpu2016.dogfight.view.IViewSystem;

public class DogfightController implements IOrderPerformer {

    private static int TIME_SLEEP = 30;
    private final IDogfightModel dogfightModel;
    private boolean isGameOver = false;
    private IViewSystem viewSystem;

    public DogfightController(final IDogfightModel dogfightModel) {
        this.dogfightModel = dogfightModel;
    }

    @Override
    public void orderPerform(final IUserOrder userOrder) {
        if (userOrder != null) {
            final IMobile plane = this.dogfightModel.getMobileByPlayer(userOrder.getPlayer());
            if (plane != null) {
                Direction direction;
                switch (userOrder.getOrder()) {
                    case UP:
                        direction = Direction.UP;
                        break;
                    case RIGHT:
                        direction = Direction.RIGHT;
                        break;
                    case LEFT:
                        direction = Direction.LEFT;
                        break;
                    case DOWN:
                        direction = Direction.DOWN;
                        break;
                    case SHOOT: {
                        try {
                            lauchMissile(userOrder.getPlayer());
                        } catch (IOException ex) {
                            Logger.getLogger(DogfightController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    case NOP:
                    default:
                        direction = this.dogfightModel.getMobileByPlayer(userOrder.getPlayer()).getDirection();
                        break;
                }
                plane.setDirection(direction);
            }
        }
    }

    private void lauchMissile(final int player) throws IOException {
        final IMobile plane = this.dogfightModel.getMobileByPlayer(player);
        if (plane != null) {
            final Position position = new Position(plane.getPosition().getX() + ((plane.getWidth() - Missile.getWidthWithADirection(plane.getDirection())) / 2),
                    plane.getPosition().getY() + ((plane.getHeight() - Missile.getHeightWithADirection(plane.getDirection())) / 2));
            this.dogfightModel.addMobile(new Missile(plane.getDirection(), position));
            switch (plane.getDirection()) {
                case UP:
                    //TODO mise a jour de la position de l'avion
                    position.setY(position.getY() + 1);
                    break;
                case DOWN:
                    //TODO mise a jour de la position de l'avion
                    position.setY(position.getY() - 1);
                    break;
                case RIGHT:
                    //TODO mise a jour de la position de l'avion
                    position.setX(position.getX() + 1);
                    break;
                case LEFT:
                    //TODO mise a jour de la position de l'avion
                    position.setX(position.getX() - 1);
                    break;
                default:
                    break;
            }
        }
    }

    private boolean isWeaponOnMobile(final IMobile mobile, final IMobile weapon) {
        //TODO renvoie vrai si le missile touche l'élément mobile
        return false;
    }

    private void manageCollision(final IMobile weapon) {
        final ArrayList<IMobile> target = new ArrayList<IMobile>();
        boolean isTargetHit = false;

        for (final IMobile mobile : this.dogfightModel.getMobiles()) {
            if (this.isWeaponOnMobile(mobile, weapon)) {
                target.add(mobile);
            }
        }
        for (final IMobile mobile : target) {
            isTargetHit = isTargetHit || mobile.hit(); //les avions renvoient vrai, les nuages et missiles renvoient faux
        }
        if (isTargetHit) {
            this.dogfightModel.removeMobile(weapon);
            this.isGameOver = true;
        }
    }

    public void play() {
        this.gameLoop();
        this.viewSystem.displayMessage("Game Over !");
        this.viewSystem.closeAll();
    }

    private void gameLoop() {
        while (!this.isGameOver) {
            try {
                Thread.sleep(TIME_SLEEP);
            } catch (final InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            final ArrayList<IMobile> initialMobiles = new ArrayList<IMobile>();
            for (final IMobile mobile : this.dogfightModel.getMobiles()) {
                initialMobiles.add(mobile);
            }
            for (final IMobile mobile : initialMobiles) {
                mobile.move();
                if (mobile.isWeapon()) {
                    this.manageCollision(mobile);
                }
            }
            this.dogfightModel.setMobilesHavesMoved();
        }
    }

    public void setViewSystem(final IViewSystem viewSystem) {
        this.viewSystem = viewSystem;
    }
}
