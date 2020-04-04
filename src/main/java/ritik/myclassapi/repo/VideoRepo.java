package ritik.myclassapi.repo;

import org.springframework.data.repository.CrudRepository;
import ritik.myclassapi.pojo.VideoItem;


// This will be AUTO IMPLEMENTED by Spring into a Bean called videoRepo
public interface VideoRepo extends CrudRepository<VideoItem, Integer> {
}