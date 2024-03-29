package main;

import javafx.scene.control.Button;

public class LetterCell {

    private Button button;
    private Coordinate location;
    private boolean isToggleable;

    private boolean isToggled;


    public LetterCell(Button b, Coordinate loc)
    {
        this.button = b;
        this.location = loc;
        this.isToggleable = true;
        this.isToggled = false;
    }

    public Button getButton()
    {
        return this.button;
    }

    public void setIsToggled(boolean newValue)
    {
        this.isToggled = newValue;
    }
    public boolean getIsToggled()
    {
        return this.isToggled;
    }

    public void setIsToggleable(boolean newValue)
    {
        this.isToggleable = newValue;
    }

    public boolean getIsToggleable()
    {
        return this.isToggleable;
    }

    public void setFound()
    {
        this.setIsToggleable(false);
        this.getButton().setStyle("-fx-background-color: #1a6e35;");
    }

    public void toggleButton()
    {
        if (!this.isToggled && this.isToggleable)
        {
            this.button.setStyle("-fx-background-color: #421c7a;");
            String wordFound = GameManager.addSelectedCoordinate(this.location);
            this.setIsToggled(true);

        }
        else if (this.isToggled && this.isToggleable)
        {
            this.button.setStyle("-fx-background-color: #121212;");
            GameManager.removeSelectedCoordinate(this.location);
            this.setIsToggled(false);
        }
    }


}