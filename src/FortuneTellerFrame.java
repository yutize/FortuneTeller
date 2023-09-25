import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        super("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        fortunes = new ArrayList<>();
        fortunes.add("You will find money on the street today.");
        fortunes.add("You will meet your soulmate tomorrow.");
        fortunes.add("You will be famous someday.");
        fortunes.add("You will travel to an exotic location soon.");
        fortunes.add("You will live a long and happy life.");
        fortunes.add("You will be promoted at work next month.");
        fortunes.add("You will win the lottery someday.");
        fortunes.add("You will make a great discovery soon.");
        fortunes.add("You will find inner peace.");
        fortunes.add("You will have a successful career.");
        fortunes.add("You will find true happiness.");
        fortunes.add("You will make a positive impact on the world.");

        titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        ImageIcon icon = new ImageIcon("fortune-teller.png");
        titleLabel.setIcon(icon);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        fortuneArea = new JTextArea();
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Arial", Font.PLAIN, 24));

        JScrollPane scrollPane = new JScrollPane(fortuneArea);

        readButton = new JButton("Read My Fortune!");
        readButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
        readButton.addActionListener((ActionEvent e) -> {
            String fortune = getRandomFortune();
            fortuneArea.append(fortune + "\n");
        });

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        // Add the components to the JFrame
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private String getRandomFortune() {
        int index = lastFortuneIndex;
        while (index == lastFortuneIndex) {
            index = new Random().nextInt(fortunes.size());
        }
        lastFortuneIndex = index;
        return fortunes.get(index);
    }
}