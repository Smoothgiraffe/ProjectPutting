package com.mygdx.CrazyPutting.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.CrazyPutting.managers.ScreenManager;

public class ChooseProjectScreen extends InputAdapter implements Screen {
  private ScreenManager game;
  private FitViewport viewport;
  private Stage stage;
  private TextureAtlas atlas;
  private Skin skin;
  private Table table;
  private TextButton playButton;
  private TextButton scoreButton;
  private TextButton exitButton;
  private BitmapFont font;
  private BitmapFont headingFont;
  private Label heading;
  private Texture background;


  public ChooseProjectScreen(ScreenManager game) {
    this.game = game;
  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(0, 1, 0, 0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    background = new Texture("core/assets/CrazyPutting/golfBack.jpg");


    this.stage.act(delta);
    stage.getBatch().begin();
    stage.getBatch().draw(background, 0, 0, LwjglApplicationConfiguration.getDesktopDisplayMode().width, LwjglApplicationConfiguration.getDesktopDisplayMode().height);
    stage.getBatch().end();
    this.stage.draw();
  }

  @Override
  public void show() {
    this.stage = new Stage();
    this.atlas = new TextureAtlas("core/assets/CrazyPutting/button.pack");
    this.skin = new Skin(atlas);
    this.table = new Table(skin);
    this.font = new BitmapFont();
    this.headingFont = new BitmapFont(Gdx.files.internal("core/assets/CrazyPutting/fonts/font.fnt"));
    table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
    textButtonStyle.up = skin.getDrawable("button_up");
    textButtonStyle.down = skin.getDrawable("button_down");
    textButtonStyle.pressedOffsetX = 1;
    textButtonStyle.pressedOffsetY = -1;
    textButtonStyle.font = this.font;
    textButtonStyle.fontColor = Color.BLACK;

    this.playButton = new TextButton("CRAZY PUTTING", textButtonStyle);
    this.playButton.pad(50);
    this.playButton.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        game.showModeScreen();

      }
    });

    this.scoreButton = new TextButton("MAZE", textButtonStyle);
    this.scoreButton.pad(50);
    this.scoreButton.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        game.showMazeLengthScreen();
      }
    });

    this.exitButton = new TextButton("EXIT", textButtonStyle);
    this.exitButton.pad(50);
    this.exitButton.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        game.showMenuScreen();
      }
    });


    Label.LabelStyle headingStyle = new Label.LabelStyle(this.headingFont, Color.BLACK);
    this.heading = new Label("CHOOSE PROJECT", headingStyle);
    this.heading.setFontScale(4);


    this.table.add(heading);
    this.table.getCell(this.heading).spaceBottom(100);
    this.table.row();
    this.table.add(this.playButton).width(800f);
    this.table.getCell(this.playButton).spaceBottom(50);
    this.table.row();
    this.table.add(this.scoreButton).width(800f);
    this.table.getCell(this.scoreButton).spaceBottom(50);
    this.table.row();
    this.table.add(this.exitButton).width(800f);
    this.stage.addActor(this.table);
    Gdx.input.setInputProcessor(stage);

  }


  @Override
  public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    return true;
  }

  @Override
  public void pause() {
  }

  @Override
  public void resume() {
  }

  @Override
  public void hide() {
  }

  @Override
  public void dispose() {
  }

  @Override
  public void resize(int width, int height) {
  }
}
