package ritik.myclassapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ritik.myclassapi.pojo.VideoItem;
import ritik.myclassapi.repo.VideoRepo;


@RestController
public class Controller {

    @Autowired
    private VideoRepo videoRepo;

    @GetMapping("/video")
    public VideoItem video(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new VideoItem("ritik", "Some Video");
    }


    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewVideo(@RequestParam String title
            , @RequestParam String resourceID) {
        VideoItem n = new VideoItem(resourceID, title);
        videoRepo.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<VideoItem> getAllUsers() {
        // This returns a JSON or XML with the users
        return videoRepo.findAll();
    }
}
