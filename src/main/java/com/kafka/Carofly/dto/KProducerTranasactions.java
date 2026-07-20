//WID(20/7/2026)(Sarthak Mittal(DegamieISign(KProducerTransactions)))#Impl
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@EnableKafka
@Component
@Service
public class KProducerTranasactions{
    public Files files;final Properties fileprops;
    public Properties loadConfig(String configfile)throws IOException{

        if(!files.exists(Paths.get(configfile))){
            fileprops=new Properties();
        }
    
}
}