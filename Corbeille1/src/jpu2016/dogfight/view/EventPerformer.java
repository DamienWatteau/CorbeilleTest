package jpu2016.dogfight.view;

import java.awt.event.KeyEvent;

import jpu2016.dogfight.controller.IOrderPerformer;
import jpu2016.dogfight.controller.IUserOrder;
import jpu2016.dogfight.controller.Order;
import jpu2016.dogfight.controller.UserOrder;
import jpu2016.gameframe.IEventPerformer;

class EventPerformer implements IEventPerformer {

    private final IOrderPerformer orderPerformer;

    public EventPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }

    @Override
    public void eventPerform(final KeyEvent keyCode) {
        final IUserOrder userOrder = this.keyCodeToUserOrder(keyCode.getKeyCode());
        if (userOrder != null) {
            //TODO transmettre l'ordre au controleur (par son interface dédiée)
            orderPerformer.orderPerform(userOrder);

        }
    }

    private IUserOrder keyCodeToUserOrder(final int keyCode) {
        IUserOrder userOrder = null; //TESTTT
        switch (keyCode) {
            // ordres pour le joueur 1
            case KeyEvent.VK_UP:
                userOrder = new UserOrder(0, Order.UP);
                break;
            case KeyEvent.VK_RIGHT:
                userOrder = new UserOrder(0, Order.RIGHT);
                break;
            case KeyEvent.VK_DOWN:
                userOrder = new UserOrder(0, Order.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                userOrder = new UserOrder(0, Order.LEFT);
                break;
            case KeyEvent.VK_CONTROL: //touche control du clavier == shoot de l'avion
                userOrder = new UserOrder(0, Order.SHOOT);
                break;

            // ordres pour le joueur 2
            case KeyEvent.VK_Z:
                userOrder = new UserOrder(1, Order.UP);
                break;
            case KeyEvent.VK_D:
                userOrder = new UserOrder(1, Order.RIGHT);
                break;
            case KeyEvent.VK_S:
                userOrder = new UserOrder(1, Order.DOWN);
                break;
            case KeyEvent.VK_Q:
                userOrder = new UserOrder(1, Order.LEFT);
                break;
            case KeyEvent.VK_SPACE: //touche control du clavier == shoot de l'avion
                userOrder = new UserOrder(1, Order.SHOOT);
                break;
            default:
                userOrder = null;
        }
        return userOrder;
    }
}
