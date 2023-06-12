package com.example.uliral;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class AlbumController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private ListView<Song> listView;

    @FXML
    private Label txtCurrentPlayingSong;

    private SongDao db = SongDao.getInstance();

    @FXML
    void onAdd(ActionEvent event) {
        Dialog<Song> dialog = new Dialog<>();
        dialog.setTitle("Дуу нэмэх");

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setVgap(10);
        TextField txtTitle = new TextField();
        TextField txtArtist = new TextField();
        TextField txtStar = new TextField();
        TextField txtLength = new TextField();
        Button btnImage = new Button("Choose Image");
        ImageView imgView = new ImageView();
        imgView.setFitWidth(100);
        imgView.setFitHeight(100);

        grid.addRow(0, new Label("Title: "), txtTitle);
        grid.addRow(1, new Label("Artist: "), txtArtist);
        grid.addRow(2, new Label("Star: "), txtStar);
        grid.addRow(3, new Label("Length: "), txtLength);
        grid.addRow(4, new Label("Image: "), imgView, btnImage);

        dialogPane.setContent(grid);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        btnImage.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(dialogPane.getScene().getWindow());
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                imgView.setImage(image);
            }
        });

        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                return new Song(txtTitle.getText(), txtArtist.getText(), Double.parseDouble(txtStar.getText()), txtLength.getText(), imgView.getImage().getUrl());
            }
            return null;
        });

        Optional<Song> result = dialog.showAndWait();
        result.ifPresent(song -> {
            db.addSong(song);
            refreshSongList();
        });
    }

    @FXML
    void onDelete(ActionEvent event) {
        Song selectedSong = listView.getSelectionModel().getSelectedItem();
        if (selectedSong == null) {
            showAlert("Дуу сонгогдоогүй байна", "Устгах дуугаа сонгоно уу", Alert.AlertType.WARNING);
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Дуу устгах");
        alert.setHeaderText("Та устгахдаа итгэлтэй байна уу?");
        alert.setContentText("Дуу: " + selectedSong.getTitle() + ", Артист: " + selectedSong.getArtist());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            db.deleteSong(selectedSong.getId());
            refreshSongList();
        }
    }

    @FXML
    void onEdit(ActionEvent event) {
        Song selectedSong = listView.getSelectionModel().getSelectedItem();
        if (selectedSong == null) {
            showAlert("Дуу сонгогдоогүй байна", "Өөрчлөх дуугаа сонгоно уу", Alert.AlertType.WARNING);
            return;
        }

        Dialog<Song> dialog = new Dialog<>();
        dialog.setTitle("Edit a Song");

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setVgap(10);
        System.out.println(selectedSong.getId());
        TextField txtTitle = new TextField(selectedSong.getTitle());
        TextField txtArtist = new TextField(selectedSong.getArtist());
        TextField txtStar = new TextField(Double.toString(selectedSong.getStar()));
        TextField txtLength = new TextField(selectedSong.getLength());
        ImageView imgView = new ImageView();
        imgView.setFitWidth(100);
        imgView.setFitHeight(100);
        imgView.setImage(new Image(selectedSong.getImage()));

        Button btnImage = new Button("Зураг солих");

        grid.addRow(0, new Label("Title: "), txtTitle);
        grid.addRow(1, new Label("Artist: "), txtArtist);
        grid.addRow(2, new Label("Star: "), txtStar);
        grid.addRow(3, new Label("Length: "), txtLength);
        grid.addRow(4, new Label("Image: "), imgView, btnImage);

        dialogPane.setContent(grid);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        btnImage.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(dialogPane.getScene().getWindow());
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                imgView.setImage(image);
            }
        });

        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {

                return new Song(selectedSong.getId(), txtTitle.getText(), txtArtist.getText(), Double.parseDouble(txtStar.getText()), txtLength.getText(), imgView.getImage().getUrl());
            }
            return null;
        });

        Optional<Song> result = dialog.showAndWait();
        result.ifPresent(song -> {
            db.updateSong(song);
            refreshSongList();
        });
    }

    private void refreshSongList() {
        try {
            listView.getItems().setAll(db.getSongs());
        } catch (Exception e) {
            showAlert("Error loading songs", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    void initialize() {
        db = SongDao.getInstance();
        listView.setCellFactory(lv -> new ListCell<Song>() {
            @Override
            public void updateItem(Song song, boolean empty) {
                super.updateItem(song, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    BorderPane pane = new BorderPane();
                    pane.setPadding(new Insets(5));

                    ImageView img = new ImageView(new Image(song.getImage(), 50, 50, true, true));
                    pane.setLeft(img);

                    VBox vbox = new VBox();
                    vbox.setPadding(new Insets(0, 0, 0, 10));
                    Label title = new Label(song.getTitle());
                    title.setFont(new Font("System", 20));

                    Label artist = new Label(song.getArtist());
                    artist.setFont(new Font("System", 14));

                    vbox.getChildren().addAll(title, artist);
                    vbox.setAlignment(Pos.CENTER_LEFT);

                    pane.setCenter(vbox);

                    HBox starHbox = new HBox();

                    for (int i = 0; i < 5; i++) {
                        ImageView starImageView;
                        if (i < song.getStar()) {
                            starImageView = new ImageView(new Image(getClass().getResource("/images/filled_star.png").toString(), 20, 20, true, true));
                        } else {
                            starImageView = new ImageView(new Image(getClass().getResource("/images/empty_star.png").toString(), 20, 20, true, true));
                        }
                        starHbox.getChildren().add(starImageView);
                    }

                    VBox vbox2 = new VBox(
                            starHbox,
                            new Label(song.getLength())
                    );

                    vbox2.setAlignment(Pos.CENTER_RIGHT);

                    pane.setRight(vbox2);

                    setGraphic(pane);
                }
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtCurrentPlayingSong.setText(newSelection.getTitle());
            }
        });

        refreshSongList();
    }
}