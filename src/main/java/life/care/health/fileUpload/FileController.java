package life.care.health.fileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {
    @Autowired
    FileService azureAdapter;



    @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String uploadFile(@RequestPart(value = "file", required = true) MultipartFile files)  {
        String name = azureAdapter.upload(files, "prefix");
        return "https://filestora.blob.core.windows.net/image/"+name;
        
    }

    // @GetMapping(path = "/download")
    // public ResponseEntity<ByteArrayResource> uploadFile(@RequestParam(value = "file") String file) throws IOException {
    //     byte[] data = azureAdapter.getFile(file);
    //     ByteArrayResource resource = new ByteArrayResource(data);

    //     return ResponseEntity
    //             .ok()
    //             .contentLength(data.length)
    //             .header("Content-type", "application/octet-stream")
    //             .header("Content-disposition", "attachment; filename=\"" + file + "\"")
    //             .body(resource);

    // }
}