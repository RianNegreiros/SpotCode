package com.github.riannegreiros.springcloud.springcloud.init;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.Artist;
import com.github.riannegreiros.springcloud.springcloud.entities.Category;
import com.github.riannegreiros.springcloud.springcloud.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Files;
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

    @Autowired
    private ResourceLoader resourceLoader;

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seedUsers();
        seedArtists();
        seedCategories();
        seedAlbums();
        seedSongs();
    }

    private void seedUsers() {
        userService.save("Freddie Mercury", "freddie@mercury.com", "123456");
        userService.save("Diana Ross", "diana@ross.com", "123456");
        userService.save("Michael Jackson", "michael@jackson.com", "123456");
        userService.save("Celine Dion", "celine@dion.com", "123456");
    }

    private void seedCategories() throws Exception {
        categoryService.save("Rock", createImage("rock.png"));
        categoryService.save("Blues", createImage("blues.png"));
        categoryService.save("Country", createImage("country.png"));
        categoryService.save("Jazz", createImage("jazz.png"));
    }

    private void seedArtists() throws Exception {
        artistService.save("Andrew Howes", createImage("andrew_howes.jpg"));
        artistService.save("Yellow Chair", createImage("yellow_chair.jpg"));
        artistService.save("Waylon Thornton", createImage("waylon_thornton.jpg"));
        artistService.save("Break the Bans", createImage("break_the_bans.jpg"));
        artistService.save("Cullah", createImage("cullah.jpg"));
        artistService.save("Handmade Moments", createImage("handmade_moments.jpg"));
        artistService.save("Dee Yan-Key", createImage("dee_yan_key.jpg"));
        artistService.save("King Imagine", createImage("king_imagine.jpg"));
    }

    private void seedAlbums() throws Exception {
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

        albumService.save("Gubernator", LocalDate.of(2015, 5, 18), rock, andrewHowes, createImage("gubernator.jpg"));
        albumService.save("The Great Bear", LocalDate.of(2015, 5, 19), rock, andrewHowes, createImage("the_great_bear.jpg"));
        albumService.save("Covers & B-sides", LocalDate.of(2013, 7, 29), blues, breakTheBans, createImage("covers_besides.jpg"));

        albumService.save("Barcelona", LocalDate.of(2014, 8, 22), rock, yellowChair, createImage("barcelona.jpg"));
        albumService.save("Everything Zen", LocalDate.of(2017, 10, 11), rock, yellowChair, createImage("everything_zen.jpg"));
        albumService.save("Mystery Club", LocalDate.of(2018, 3, 5), rock, waylonThornton, createImage("mystery_club.jpg"));
        albumService.save("Be Love Not Fear", LocalDate.of(2016, 2, 14), rock, cullah, createImage("be_love_not_fear.jpg"));
        albumService.save("Trinity", LocalDate.of(2017, 6, 21), rock, cullah, createImage("trinity.jpg"));
        albumService.save("Paw Paw Tree", LocalDate.of(2014, 4, 16), rock, handmadeMoments, createImage("paw_paw_tree.jpg"));
        albumService.save("Years and Years Ago", LocalDate.of(2017, 1, 9), rock, deeYanKey, createImage("years_and_years_ago.jpg"));
        albumService.save("A Man's Life", LocalDate.of(2017, 12, 18), rock, deeYanKey, createImage("mans_life.jpg"));
        albumService.save("Aldebaran", LocalDate.of(2016, 9, 30), rock, deeYanKey, createImage("aldebaran.jpg"));
        albumService.save("Inside", LocalDate.of(2019, 11, 5), rock, kingImagine, createImage("inside.jpg"));
    }

    private void seedSongs() throws Exception {
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
        songService.save(gubernator, "Dumb Luck", createAudio("dumb_luck.mp3"));
        // Seed songs for Yellow Chair - Everything Zen
        songService.save(everythingZen, "Everything Zen", createAudio("everything_zen.mp3"));

        // Seed songs for Yellow Chair - Meng Jia
        songService.save(mengJia, "Malvinas Go-Go", createAudio("malvinas_go_go.mp3"));
        songService.save(mengJia, "Coronation of Pope Francis", createAudio("coronation_pope_francis.mp3"));

        // Seed songs for Waylon Thornton - Mystery Club
        songService.save(mysteryClub, "Wobbly Way", createAudio("wobbly_way.mp3"));
        songService.save(mysteryClub, "Very Hazel", createAudio("very_hazel.mp3"));
        songService.save(mysteryClub, "Favorite Secrets", createAudio("favorite_secrets.mp3"));

        // Seed songs for Break the Bans - Covers & B-sides
        songService.save(coversBesides, "How can I love her", createAudio("how_can_i_love_her.mp3"));

        // Seed songs for Cullah - Be Love Not Fear
        songService.save(beLoveNotFear, "Save my Soul", createAudio("save_my_soul.mp3"));
        songService.save(beLoveNotFear, "Who am I?", createAudio("who_am_i.mp3"));
        songService.save(beLoveNotFear, "Jane the Ripper", createAudio("jane_the_ripper.mp3"));

        // Seed songs for Cullah - Trinity
        songService.save(trinity, "Freed from Greed", createAudio("freed_from_greed.mp3"));
        songService.save(trinity, "Aisling", createAudio("aisling.mp3"));

        // Seed songs for Handmade Moments - Paw Paw Tree
        songService.save(pawPawTree, "Junkie", createAudio("junkie.mp3"));
        songService.save(pawPawTree, "Fighting a Mountain", createAudio("fighting_a_mountain.mp3"));
        songService.save(pawPawTree, "Wanderin' Eyes", createAudio("wanderin_eyes.mp3"));
        songService.save(pawPawTree, "Human Hands", createAudio("human_hands.mp3"));
        songService.save(pawPawTree, "Coffee, Chocolate, Earth", createAudio("coffee_chocolate_earth.mp3"));

        // Seed songs for Dee Yan-Key - Years and Years Ago
        songService.save(yearsAndYearsAgo, "Lazy", createAudio("lazy.mp3"));
        songService.save(yearsAndYearsAgo, "Snow", createAudio("snow.mp3"));
        songService.save(yearsAndYearsAgo, "Grief", createAudio("grief.mp3"));
        songService.save(yearsAndYearsAgo, "Clowns", createAudio("clowns.mp3"));

        // Seed songs for Dee Yan-Key - A Man's Life
        songService.save(mansLife, "Life", createAudio("life.mp3"));
        songService.save(mansLife, "Death & Redemption", createAudio("death_redemption.mp3"));

        // Seed songs for Dee Yan-Key - Aldebaran
        songService.save(aldebaran, "Antares", createAudio("antares.mp3"));

        // Seed songs for King Imagine - Inside
        songService.save(inside, "Ivy", createAudio("ivy.mp3"));
        songService.save(inside, "Escape", createAudio("escape.mp3"));
    }

    private MultipartFile createImage(String filename) throws Exception {
        File file = ResourceUtils.getFile("classpath:images/" + filename);
        byte[] fileContent = Files.readAllBytes(file.toPath());

        String contentType = determineContentType(filename);

        return new MockMultipartFile(filename, filename, contentType, fileContent);
    }

    private MultipartFile createAudio(String filename) throws Exception {
        File file = ResourceUtils.getFile("classpath:musics/" + filename);
        byte[] bytes = Files.readAllBytes(file.toPath());
        return new MockMultipartFile(filename, filename, "audio/mpeg", bytes);
    }

    private String determineContentType(String filename) {
        if (filename.toLowerCase().endsWith(".jpg") || filename.toLowerCase().endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (filename.toLowerCase().endsWith(".png")) {
            return "image/png";
        } else {
            return "application/octet-stream";
        }
    }
}
