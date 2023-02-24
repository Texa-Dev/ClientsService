package com.example.clientsservice;

import com.example.clientsservice.models.adress.Country;
import com.example.clientsservice.models.adress.District;
import com.example.clientsservice.models.adress.Region;
import com.example.clientsservice.services.data.ClientService;
import com.example.clientsservice.repositories.RegionRepository;
import com.example.clientsservice.services.data.CountryService;
import com.example.clientsservice.services.data.DistrictService;
import com.example.clientsservice.services.data.RegionService;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class ClientsServiceApplication {
    @Autowired
    private ClientService clientService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private DistrictService districtService;


    public static void main(String[] args) {
        SpringApplication.run(ClientsServiceApplication.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void onLoaded() {
//        Client client=new Client(0, "Surname", "Name", "Patronymic", LocalDate.now(),
//                "email@test.com", Client.Gender.MALE,
//                null, null ,null );
//       client= clientService.save(client);
        // System.out.println(client);
        Country country = new Country(0, "Ukraine", null);
        country = countryService.save(country);
        System.out.println(country);
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country(0, "Poland", null));
        countries.add(new Country(0, "Germany", null));
        countries.add(new Country(0, "USA", null));
        countries.add(new Country(0, "Switzerland", null));
        countries.add(new Country(0, "Italy", null));
        countries.add(new Country(0, "France", null));
        countries.add(new Country(0, "Austria", null));

        countryService.saveAll(countries);
        ArrayList<Region> regions = new ArrayList<>(Arrays.asList(
                (new Region(0, "Cherkasy", countryService.getReferenceById(1), null)),
                (new Region(0, "Chernihiv", countryService.getReferenceById(1), null)),
                (new Region(0, "Chernivtsi", countryService.getReferenceById(1), null)),
                (new Region(0, "Crimea", countryService.getReferenceById(1), null)),
                (new Region(0, "Dnipropetrovsk", countryService.getReferenceById(1), null)),
                (new Region(0, "Donetsk", countryService.getReferenceById(1), null)),
                (new Region(0, "Ivano-Frankivsk", countryService.getReferenceById(1), null)),
                (new Region(0, "Kharkiv", countryService.getReferenceById(1), null)),
                (new Region(0, "Kherson", countryService.getReferenceById(1), null)),
                (new Region(0, "Khmelnytskyi", countryService.getReferenceById(1), null)),
                (new Region(0, "Kirovohrad", countryService.getReferenceById(1), null)),
                (new Region(0, "Kyiv", countryService.getReferenceById(1), null)),
                (new Region(0, "Luhansk", countryService.getReferenceById(1), null)),
                (new Region(0, "Lviv", countryService.getReferenceById(1), null)),
                (new Region(0, "Mykolaiv", countryService.getReferenceById(1), null)),
                (new Region(0, "Odesa", countryService.getReferenceById(1), null)),
                (new Region(0, "Poltava", countryService.getReferenceById(1), null)),
                (new Region(0, "Rivne", countryService.getReferenceById(1), null)),
                (new Region(0, "Sumy", countryService.getReferenceById(1), null)),
                (new Region(0, "Ternopil", countryService.getReferenceById(1), null)),
                (new Region(0, "Vinnytsia", countryService.getReferenceById(1), null)),
                (new Region(0, "Volyn", countryService.getReferenceById(1), null)),
                (new Region(0, "Zakarpattia", countryService.getReferenceById(1), null)),
                (new Region(0, "Zaporizhzhia", countryService.getReferenceById(1), null)),
                (new Region(0, "Zhytomyr", countryService.getReferenceById(1), null))

        ));
        regionService.saveAll(regions);

        ArrayList<District> districts = new ArrayList<>();
        districts.add(new District(0,"Kremenchugsky", regionService.getReferenceById(17),null));
        districts.add(new District(0,"Lubensky", regionService.getReferenceById(17),null));
        districts.add(new District(0,"Mirgorodsky", regionService.getReferenceById(17),null));
        districts.add(new District(0,"Poltavsky", regionService.getReferenceById(17),null));
        districts.add(new District(0,"Akhtyrsky", regionService.getReferenceById(19),null));
        districts.add(new District(0,"Konotopsky", regionService.getReferenceById(19),null));
        districts.add(new District(0,"Romensky", regionService.getReferenceById(19),null));
        districts.add(new District(0,"Sumysky", regionService.getReferenceById(19),null));
        districts.add(new District(0,"Shostkinsky", regionService.getReferenceById(19),null));

        districtService.saveAll(districts);
    }


}
