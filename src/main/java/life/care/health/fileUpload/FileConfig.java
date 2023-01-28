package life.care.health.fileUpload;
import com.azure.storage.blob.BlobClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
@Configuration
public class FileConfig {

        
        @Bean
        public BlobClientBuilder getClient() {
            BlobClientBuilder client = new BlobClientBuilder();
            client.connectionString("DefaultEndpointsProtocol=https;AccountName=filestora;AccountKey=NX0ypcufDxntzrUyfROay4Gvqdv5uINhazClrXfuhsVXp2FT40ysjmfr+P/U5aouYPfl+9PpwRoA+AStvnAbrA==;EndpointSuffix=core.windows.net");
            client.containerName("image");
            return client;
        }
    }