package online.speedwagon.catfishing;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;

public class CatFishing extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("CatFishing");
        settings.setVersion("0.1");
        settings.setAppIcon("icon.png");
    }

    private Entity player;

    @Override
    protected void initGame() {
        player = FXGL.entityBuilder()
                .at(300, 300)
                .scale(0.25f, 0.25f)
                .view("cat-left.png")
                .buildAndAttach();
    }

    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.D, () -> {
            player.getViewComponent().clearChildren();
            player.getViewComponent().addChild(FXGL.texture("cat-right.png"));
            player.translateX(3);

            if (player.getX() > FXGL.getAppWidth()) {
                player.setX(-player.getWidth());
            }
        });
        FXGL.onKey(KeyCode.A, () -> {
            player.getViewComponent().clearChildren();
            player.getViewComponent().addChild(FXGL.texture("cat-left.png"));
            player.translateX(-3);

            if (player.getX() + player.getWidth() < 0) {
                player.setX(FXGL.getAppWidth());
            }
        });
        FXGL.onKey(KeyCode.W, () -> {
            player.translateY(-3);

            if (player.getY() + player.getHeight() < 0) {
                player.setY(FXGL.getAppHeight());
            }
        });
        FXGL.onKey(KeyCode.S, () -> {
            player.translateY(3);

            if (player.getY() > FXGL.getAppHeight()) {
                player.setY(-player.getHeight());
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}