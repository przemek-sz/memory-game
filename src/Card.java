import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Card extends JButton {


    char top = ' ';
    char bottom;
    boolean exposed = false;


    Card() {
        super();
    }


    public static void showCard(Card card) {

        if (Checker.second == null && !card.getExposed()) {

            if (Checker.first == null) {
                card.setExposed(true);
                card.setTextToBottom();
                Checker.first = card;

            } else if (!Checker.first.equals(card)) {
                card.setExposed(true);
                card.setTextToBottom();
                Checker.second = card;
                new Thread(new Checker()).start();
            }
        }
    }


    public void setBottom(char bottom) {

        this.bottom = bottom;
    }

    public void setTextToBottom() {

        setText("" + bottom);
    }

    public void setTextToTop() {

        setText("" + top);
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public boolean getExposed() {
        return exposed;
    }


    public static List<Character> createDeck(int n) {

        List<Character> deck = new ArrayList<>();
        boolean e = false;

        for (int i = 0; i < (n * n) / 2; i++) {

            char c = randomChar();

            for (Character character : deck) {
                if (character == c) {
                    e = true;
                }
            }
            if (e) {
                i--;
                e = false;
                System.out.println(c);
            } else {
                deck.add(c);
                e = false;
            }

        }

        return duplicateCharakter(deck);
    }


    public static List<Character> duplicateCharakter(List<Character> deck) {

        List<Character> secondCard = new ArrayList<>(deck);

        for (Character card : deck) {
            secondCard.add(card);
        }

        Collections.shuffle(secondCard);
        return secondCard;
    }


    public static char randomChar() {

        char c=' ';

        while(c==' ') {
            c= (char) ((Math.random() * (887 - 176) + 176));
            //c= (char) ((Math.random() * (1423 - 176) + 176));
        }

        return c;
    }

}
