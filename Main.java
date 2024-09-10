package Actual;
import java.util.*;
public class Main {
          private static List<Album> albums = new ArrayList<>();
          private static ListIterator<Song> listIterator;
          private static boolean forward = true;
          private static LinkedList<Song> playList = new LinkedList<>();
      
          public static void main(String[] args) {
            // Code for creating albums and songs...
            Album album1 = new Album("Album1", "AC/DC");
            album1.addSong("TNT", 4.5);
            album1.addSong("Highway to Hell", 3.5);
            albums.add(album1);

            Album album2 = new Album("Album2", "Eminem");
            album2.addSong("Rap God", 4.5);
            album2.addSong("Lose Yourself", 5.0);
            albums.add(album2);
            listIterator = playList.listIterator();
      
      
              printMenu();
              Scanner scanner = new Scanner(System.in);
              boolean quit = false;
              while (!quit) {
                  System.out.println("Enter your choice:");
                  int choice = scanner.nextInt();
                  scanner.nextLine();
      
                  switch (choice) {
                      case 0:
                          System.out.println("Playlist complete.");
                          quit = true;
                          break;
                      case 1:
                          playNextSong();
                          break;
                      case 2:
                          playPreviousSong();
                          break;
                      case 3:
                          playCurrentSong();
                          break;
                      case 4:
                          printList();
                          break;
                      case 5:
                          printMenu();
                          break;
                      case 6:
                          removeCurrentSong();
                          break;
                      default:
                          System.out.println("Invalid choice. Please try again.");
                  }
              }
              scanner.close();
          }
      
          private static void playNextSong() {
              if (forward) {
                  if (listIterator.hasNext()) {
                      System.out.println("Now playing: " + listIterator.next().toString());
                  } else {
                      System.out.println("End of the playlist.");
                      forward = false;
                  }
              } else {
                  if (listIterator.hasPrevious()) {
                      listIterator.next();
                      forward = true;
                  } else {
                      System.out.println("Start of the playlist.");
                  }
              }
          }
      
          private static void playPreviousSong() {
              if (forward) {
                  if (listIterator.hasPrevious()) {
                      listIterator.previous();
                      forward = false;
                  } else {
                      System.out.println("Start of the playlist.");
                  }
              } else {
                  if (listIterator.hasNext()) {
                      System.out.println("Now playing: " + listIterator.next().toString());
                      forward = true;
                  } else {
                      System.out.println("End of the playlist.");
                  }
              }
          }
      
          private static void playCurrentSong() {
              if (listIterator.hasPrevious() && listIterator.hasNext()) {
                  if (forward) {
                      listIterator.previous();
                      System.out.println("Now playing: " + listIterator.next().toString());
                  } else {
                      listIterator.next();
                      System.out.println("Now playing: " + listIterator.previous().toString());
                  }
              } else if (listIterator.hasPrevious()) {
                  System.out.println("Start of the playlist.");
              } else if (listIterator.hasNext()) {
                  System.out.println("End of the playlist.");
              }
          }
      
          private static void printList() {
              System.out.println("Playlist songs:");
              for (Song song : playList) {
                  System.out.println(song.toString());
              }
          }
      
          private static void removeCurrentSong() {
              if (playList.size() > 0) {
                  listIterator.remove();
                  if (listIterator.hasNext()) {
                      System.out.println("Now playing: " + listIterator.next().toString());
                  } else if (listIterator.hasPrevious()) {
                      System.out.println("Now playing: " + listIterator.previous().toString());
                  }
              } else {
                  System.out.println("Playlist is empty.");
              }
          } 
          private static void printMenu() {
            System.out.println("\nAvailable Actions:");
            System.out.println("0 - Quit the Music Player");
            System.out.println("1 - Play the Next Song");
            System.out.println("2 - Play the Previous Song");
            System.out.println("3 - Replay the Current Song");
            System.out.println("4 - Print the Playlist");
            System.out.println("5 - Print Available Actions");
            System.out.println("6 - Remove the Current Song from Playlist");
            System.out.println("Please enter the corresponding number to perform the action.");
        }
        
}