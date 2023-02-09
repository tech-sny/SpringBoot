package life.care.health.azure.About;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import life.care.health.fileUpload.FileService;

@RestController
@RequestMapping("/about")
public class AboutController {

    @Autowired
    AboutRepository aboutRepository;

    @Autowired
    FileService fileService;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping
    private List<About> findAllProject(){
        return aboutRepository.findProjects();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public About saveProject(@RequestPart("data") String data,@RequestPart("image") MultipartFile image,@RequestPart("resume") MultipartFile resume) throws JsonMappingException, JsonProcessingException{
        String res=fileService.upload(resume, "resume");
        String img = fileService.upload(image, "project");
        About payload = mapper.readValue(data, About.class);
        payload.setImage(img);
        payload.setResume(res);
        return aboutRepository.save(payload);
    }
    
}