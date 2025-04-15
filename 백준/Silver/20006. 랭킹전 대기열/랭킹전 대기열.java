import java.io.*;
import java.util.*;

public class Main {
    static class Player {
        int level;
        String nickname;

        Player (int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    static class Room {
        List<Player> playerList = new ArrayList<>();
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int players = stoi(st.nextToken());
        int max = stoi(st.nextToken());
        List<Room> roomList = new ArrayList<>();

        for (int i = 0; i < players; i++) {
            st = new StringTokenizer(br.readLine());

            Player player = new Player(stoi(st.nextToken()), st.nextToken());
            boolean isJoined = false;

            for(Room room : roomList) {
                if(room.playerList.size() < max
                        && player.level >= room.playerList.get(0).level - 10
                        && player.level <= room.playerList.get(0).level + 10) {
                    room.playerList.add(player);
                    isJoined = true;
                    break;
                }
            }

            if(!isJoined) {
                Room room = new Room();
                room.playerList.add(player);
                roomList.add(room);
            }

        }

        for(Room room : roomList) {
            if(room.playerList.size() == max) System.out.println("Started!");
            else System.out.println("Waiting!");

            room.playerList.sort(new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return o1.nickname.compareTo(o2.nickname);
                }
            });

            for(Player player : room.playerList) {
                System.out.println(player.level + " " + player.nickname);
            }
        }

    }
}