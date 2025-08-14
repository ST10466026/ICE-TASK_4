/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package showtracker;

public class Show {
    public String showId;
    public String showName;
    public int showAge;
    public int showEpisodes;

    public Show(String id, String name, int age, int episodes) {
        this.showId = id;
        this.showName = name;
        this.showAge = age;
        this.showEpisodes = episodes;
    }

    @Override
    public String toString() {
        return "Show ID: " + showId +
               "\nShow Name: " + showName +
               "\nAge Restriction: " + showAge +
               "\nNumber of Episodes: " + showEpisodes;
    }
}