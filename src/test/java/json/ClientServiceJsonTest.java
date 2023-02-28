package json;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.AddressService;
import com.example.clientsservice.services.data.ClientService;
import com.example.clientsservice.services.data.db.AddressServiceDb;
import com.example.clientsservice.services.data.qualifiers.QualifierClientServiceJson;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceJsonTest {

/*    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    @QualifierClientServiceJson
    private ClientService clientService;

    @Test
    void saveAll(){
        ArrayList<Client> clients = new ArrayList<>();
        AddressService addressService=new AddressServiceDb();

        clients.add(new Client(0, "Surname", "Name", "Patronymic", LocalDate.now(),
                "email@test.com", Client.Gender.MALE, addressService.getById(2), null ,null ));
        clients.add(new Client(0, "Surname1", "Name1", "Patronymic1", LocalDate.now(),
                "email1@test.com", Client.Gender.MALE, addressService.getById(2), null ,null ));
        clientService.saveAll(clients);
    }*/
}
