import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener {

    private int key;

    private JButton playButton;

    private boolean gameStarted = false; 

    private JPanel triviaPanel;
    private JLabel topicLabel;

    public Game() {
        setLayout(null); 
        setFocusable(true); 
        addKeyListener(this);

        
        JLabel titleLabel = new JLabel("Trivia Mania");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 128));
        FontMetrics titleMetrics = titleLabel.getFontMetrics(titleLabel.getFont());
        int titleWidth = titleMetrics.stringWidth("Trivia Mania");
        titleLabel.setBounds((1800 - titleWidth) / 3, 200, titleWidth, 150);
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

        
        triviaPanel = new JPanel();
        triviaPanel.setLayout(null);
        triviaPanel.setBounds(0, 0, 1800, 1600);
        triviaPanel.setVisible(false);
        triviaPanel.setBackground(Color.RED);

        
       
        add(triviaPanel);
    }

    private void startGame() {
        gameStarted = true;
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
        key = e.getKeyCode();
        if (!gameStarted && key == KeyEvent.VK_SPACE) { 
            startGame();
        }
        System.out.println(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

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
