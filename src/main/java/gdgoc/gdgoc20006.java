package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc20006 {
    static int p;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int power = Integer.parseInt(st.nextToken());
            String target = st.nextToken();
            Player player = new Player(target, power);
            boolean isEntered = false;

            for (Room room: rooms) {
                if (room.power <= power + 10 && room.power >= power - 10 && room.hasSpace()) {
                    room.addPlayer(player);
                    isEntered = true;
                    break;
                }
            }

            if (!isEntered) {
                Room room = new Room(power);
                room.addPlayer(player);
                rooms.add(room);
            }
        }

        for (Room room: rooms) {
            if (room.players.size() == m) {
                System.out.println("Started!");
            }
            else {
                System.out.println("Waiting!");
            }
            List<Player> players = room.players;
            Collections.sort(players, (p1, p2) -> p1.name.compareTo(p2.name));
            for (Player player: players) {
                System.out.println(player.power + " " + player.name);
            }
        }
    }

    public static class Player {
        String name;
        int power;

        public Player(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }

    public static class Room {
        int power;
        List<Player> players = new ArrayList<>();

        public Room(int power) {
            this.power = power;
        }

        public void addPlayer(Player player) {
            this.players.add(player);
        }

        public boolean hasSpace() {
            if (players.size() >= m) {
                return false;
            }
            return true;
        }
    }
}
