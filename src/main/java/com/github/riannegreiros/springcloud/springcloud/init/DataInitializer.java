package com.github.riannegreiros.springcloud.springcloud.init;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.Artist;
import com.github.riannegreiros.springcloud.springcloud.entities.Category;
import com.github.riannegreiros.springcloud.springcloud.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private SongService songService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seedUsers();
        seedCategories();
        seedSongs();
        seedArtists();
    }

    private void seedUsers() {
        userService.save("Freddie Mercury", "freddie@mercury.com", "123456");
        userService.save("Diana Ross", "diana@ross.com", "123456");
        userService.save("Michael Jackson", "michael@jackson.com", "123456");
        userService.save("Celine Dion", "celine@dion.com", "123456");
    }

    private void seedCategories() {
        categoryService.save("Rock");
        categoryService.save("Blues");
        categoryService.save("Country");
        categoryService.save("Jazz");
    }

    private void seedAlbums() {
        Category rock = categoryService.findByName("Rock");
        Category blues = categoryService.findByName("Blues");

        Artist andrewHowes = artistService.findByName("Andrew Howes");
        Artist yellowChair = artistService.findByName("Yellow Chair");
        Artist waylonThornton = artistService.findByName("Waylon Thornton");
        Artist breakTheBans = artistService.findByName("Break the Bans");
        Artist cullah = artistService.findByName("Cullah");
        Artist handmadeMoments = artistService.findByName("Handmade Moments");
        Artist deeYanKey = artistService.findByName("Dee Yan-Key");
        Artist kingImagine = artistService.findByName("King Imagine");

        albumService.save("Gubernator", LocalDate.of(2015, 5, 18), rock, andrewHowes);
        albumService.save("The Great Bear", LocalDate.of(2015, 5, 19), rock, andrewHowes);
        albumService.save("Covers & B-sides", LocalDate.of(2013, 7, 29), blues, breakTheBans);

        albumService.save("Barcelona", LocalDate.of(2014, 8, 22), rock, yellowChair);
        albumService.save("Everything Zen", LocalDate.of(2017, 10, 11), rock, yellowChair);
        albumService.save("Mystery Club", LocalDate.of(2018, 3, 5), rock, waylonThornton);
        albumService.save("Be Love Not Fear", LocalDate.of(2016, 2, 14), rock, cullah);
        albumService.save("Trinity", LocalDate.of(2017, 6, 21), rock, cullah);
        albumService.save("Paw Paw Tree", LocalDate.of(2014, 4, 16), rock, handmadeMoments);
        albumService.save("Years and Years Ago", LocalDate.of(2017, 1, 9), rock, deeYanKey);
        albumService.save("A Man's Life", LocalDate.of(2017, 12, 18), rock, deeYanKey);
        albumService.save("Aldebaran", LocalDate.of(2016, 9, 30), rock, deeYanKey);
        albumService.save("Inside", LocalDate.of(2019, 11, 5), rock, kingImagine);
    }
    private void seedArtists() {
        artistService.save("Andrew Howes");
        artistService.save("Yellow Chair");
        artistService.save("Waylon Thornton");
        artistService.save("Break the Bans");
        artistService.save("Cullah");
        artistService.save("Handmade Moments");
        artistService.save("Dee Yan-Key");
        artistService.save("King Imagine");
    }

    private void seedSongs() {
        Album gubernator = albumService.findByTitle("Gubernator");
        Album theGreatBear = albumService.findByTitle("The Great Bear");
        Album barcelona = albumService.findByTitle("Barcelona");
        Album everythingZen = albumService.findByTitle("Everything Zen");
        Album mengJia = albumService.findByTitle("Meng Jia");
        Album mysteryClub = albumService.findByTitle("Mystery Club");
        Album coversBesides = albumService.findByTitle("Covers & B-sides");
        Album beLoveNotFear = albumService.findByTitle("Be Love Not Fear");
        Album trinity = albumService.findByTitle("Trinity");
        Album pawPawTree = albumService.findByTitle("Paw Paw Tree");
        Album yearsAndYearsAgo = albumService.findByTitle("Years and Years Ago");
        Album mansLife = albumService.findByTitle("A Man's Life");
        Album aldebaran = albumService.findByTitle("Aldebaran");
        Album inside = albumService.findByTitle("Inside");

        // Seed songs for Andrew Howes - Gubernator
        songService.save(gubernator, "Dumb Luck");
        songService.save(gubernator, "Helmsman");
        songService.save(gubernator, "Crimea");
        songService.save(gubernator, "Traitors Gate");

        // Seed songs for Andrew Howes - The Great Bear
        songService.save(theGreatBear, "Big Drop");
        songService.save(theGreatBear, "4am");
        songService.save(theGreatBear, "Waiting");

        // Seed songs for Yellow Chair - Barcelona
        songService.save(barcelona, "Via Laietana");
        songService.save(barcelona, "Passeig de Gràcia");
        songService.save(barcelona, "Itaca");

        // Seed songs for Yellow Chair - Everything Zen
        songService.save(everythingZen, "Everything Zen");

        // Seed songs for Yellow Chair - Meng Jia
        songService.save(mengJia, "Malvinas Go-Go");
        songService.save(mengJia, "Coronation of Pope Francis");

        // Seed songs for Waylon Thornton - Mystery Club
        songService.save(mysteryClub, "Wobbly Way");
        songService.save(mysteryClub, "Very Hazel");
        songService.save(mysteryClub, "Favorite Secrets");

        // Seed songs for Break the Bans - Covers & B-sides
        songService.save(coversBesides, "How can I love her");

        // Seed songs for Cullah - Be Love Not Fear
        songService.save(beLoveNotFear, "Save my Soul");
        songService.save(beLoveNotFear, "Who am I?");
        songService.save(beLoveNotFear, "Jane the Ripper");

        // Seed songs for Cullah - Trinity
        songService.save(trinity, "Freed from Greed");
        songService.save(trinity, "Aisling");

        // Seed songs for Handmade Moments - Paw Paw Tree
        songService.save(pawPawTree, "Junkie");
        songService.save(pawPawTree, "Fighting a Mountain");
        songService.save(pawPawTree, "Wanderin' Eyes");
        songService.save(pawPawTree, "Human Hands");
        songService.save(pawPawTree, "Coffee, Chocolate, Earth");

        // Seed songs for Dee Yan-Key - Years and Years Ago
        songService.save(yearsAndYearsAgo, "Lazy");
        songService.save(yearsAndYearsAgo, "Snow");
        songService.save(yearsAndYearsAgo, "Grief");
        songService.save(yearsAndYearsAgo, "Clowns");

        // Seed songs for Dee Yan-Key - A Man's Life
        songService.save(mansLife, "Life");
        songService.save(mansLife, "Death & Redemption");

        // Seed songs for Dee Yan-Key - Aldebaran
        songService.save(aldebaran, "Antares");

        // Seed songs for King Imagine - Inside
        songService.save(inside, "Ivy");
        songService.save(inside, "Escape");
    }
}
