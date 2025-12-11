package ui;


import model.Food;
import model.Position;
import model.Snake;

public class Renderer {

    public void render(int w, int h, Snake s, Food f, int score) {
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                Position p = new Position(r, c);

                if (r == 0 || c == 0 || r == h - 1 || c == w - 1) {
                    sb.append("X");
                } else if (f.getPosition().equals(p)) {
                    sb.append("*");
                } else if (s.contains(p)) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(sb);
        System.out.println("Score: " + score);
    }
}

