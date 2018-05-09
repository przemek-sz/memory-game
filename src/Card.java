import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class Card extends JButton {


    char top = ' ';
    char bottom;
    static boolean canClick = true;

    Card() {
        super();
    }


    public static void showCard(Card card) {

        if (canClick) {
            if (Checker.second != null) {

                Checker.first = null;
                Checker.second = null;
            }
            if (Checker.first == null) {
                System.out.println("pierwsza");
                Checker.first = card;
                Checker.first.setTextToBottom();
            } else if(!Checker.first.equals(card)) {
                System.out.println("druga");
                Checker.second = card;
                Checker.second.setTextToBottom();
                canClick = false;
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

        return (char) ((Math.random() * (887 - 176) + 176));
    }

}
