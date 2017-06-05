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
        }
    }

    private IUserOrder keyCodeToUserOrder(final int keyCode) {
        IUserOrder userOrder;
        switch (keyCode) {
            // ordres pour le joueur 1
            case KeyEvent.VK_UP:
                userOrder = new UserOrder(0, Order.UP);
                break;
            case KeyEvent.VK_RIGHT:
                //TODO
                break;
            case KeyEvent.VK_DOWN:
                //TODO
                break;
            case KeyEvent.VK_LEFT:
                //TODO
                break;
            case KeyEvent.VK_CONTROL: //touche control du clavier == shoot de l'avion
                //TODO
                break;

            // ordres pour le joueur 2
            //TODO idem
            default:
                userOrder = null;
        }
        return userOrder;
    }

}
