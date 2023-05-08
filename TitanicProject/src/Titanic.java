import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Titanic extends JFrame
 {

        public static void main(String[] args)
        {
            new Titanic();
        }

        public Titanic()
        {
            this.setTitle("Titanic Passengers Data");
            this.setLayout(null);
            //this.setVisible();
            //this.BackgroundImageExample();
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
            this.add(new ManageScreen(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
            this.setVisible(true);

        }


     public void BackgroundImageExample()
     {

         // Create the panel and set it as the content pane
         JPanel contentPane = new JPanel() {
             @Override
             protected void paintComponent(Graphics g) {
                 super.paintComponent(g);
                 try {
                     BufferedImage backgroundImage = ImageIO.read(new File("C:\\Users\\משתמש\\OneDrive\\Git Ripositories\\src\\data\\TITANIC3_i.jpg"));
                     g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         };
         setContentPane(contentPane);

         // Set the size and visibility of the window

     }


 }
    


