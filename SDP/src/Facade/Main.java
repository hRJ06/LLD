package Facade;

import java.util.Scanner;

import Facade.Media_Facade.MediaFacade;

public class Main {
    public static void main(String[] args) {
        MediaFacade mediaFacade = new MediaFacade();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Action (PLAY_MUSIC, PLAY_VIDEO, VIEW_IMAGE) - ");
        String action = sc.nextLine();
        mediaFacade.performAction(action);
        sc.close();
    }
}
