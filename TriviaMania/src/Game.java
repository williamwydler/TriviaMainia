import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener {

    private JButton playButton;
    private JPanel triviaPanel;
    private JButton topicButton1;
    private JButton topicButton2;
   

    public Game() {
        setLayout(null);
        setFocusable(true);
        addKeyListener(this);

        
        JLabel titleLabel = new JLabel("Trivia Mania");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 128));
        titleLabel.setBounds(350, 200, 900, 150);
        add(titleLabel);

        
        playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.PLAIN, 60));
        playButton.setBackground(Color.BLACK);
        playButton.setForeground(Color.WHITE);
        playButton.setBounds(450, 500, 500, 100);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        add(playButton);

        
        triviaPanel = new JPanel(null);
        triviaPanel.setBounds(0, 0, 1800, 1600);
        triviaPanel.setBackground(Color.RED);
        triviaPanel.setVisible(false);
        add(triviaPanel);

        
        JLabel topicLabel = new JLabel("Pick A Topic!");
        topicLabel.setFont(new Font("Arial", Font.BOLD, 64));
        topicLabel.setBounds(500, 50, 600, 100);
        triviaPanel.add(topicLabel);

        
        topicButton1 = new JButton("Topic 1");
        topicButton1.setFont(new Font("Arial", Font.PLAIN, 40));
        topicButton1.setBackground(Color.WHITE);
        topicButton1.setForeground(Color.BLACK);
        topicButton1.setBounds(300, 400, 400, 100);
        triviaPanel.add(topicButton1);

        topicButton2 = new JButton("Topic 2");
        topicButton2.setFont(new Font("Arial", Font.PLAIN, 40));
        topicButton2.setBackground(Color.WHITE);
        topicButton2.setForeground(Color.BLACK);
        topicButton2.setBounds(700, 400, 400, 100);
        triviaPanel.add(topicButton2);

       
    }

    private void startGame() {
        playButton.setVisible(false);
        triviaPanel.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (!triviaPanel.isVisible() && key == KeyEvent.VK_SPACE) {
            startGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Trivia Mania");
        frame.setSize(1800, 1600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Game game = new Game();
        frame.add(game);

        frame.setVisible(true);
    }
}
