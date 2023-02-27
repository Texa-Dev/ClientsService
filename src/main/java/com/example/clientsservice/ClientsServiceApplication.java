package com.example.clientsservice;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.adress.*;
import com.example.clientsservice.services.data.*;
import com.example.clientsservice.services.data.address.*;
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
    @Autowired
    private CityTypeService cityTypeService;
    @Autowired
    private CityNameService cityNameService;
    @Autowired
    private CityService cityService;
    @Autowired
    private StreetTypeService streetTypeService;
    @Autowired
    private StreetNameService streetNameService;
    @Autowired
    private StreetService streetService;
    @Autowired
    private AddressService addressService;

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
        districts.add(new District(0, "Kremenchugsky", regionService.getReferenceById(17), null));
        districts.add(new District(0, "Lubensky", regionService.getReferenceById(17), null));
        districts.add(new District(0, "Mirgorodsky", regionService.getReferenceById(17), null));
        districts.add(new District(0, "Poltavsky", regionService.getReferenceById(17), null));
        districts.add(new District(0, "Akhtyrsky", regionService.getReferenceById(19), null));
        districts.add(new District(0, "Konotopsky", regionService.getReferenceById(19), null));
        districts.add(new District(0, "Romensky", regionService.getReferenceById(19), null));
        districts.add(new District(0, "Sumysky", regionService.getReferenceById(19), null));
        districts.add(new District(0, "Shostkinsky", regionService.getReferenceById(19), null));

        districtService.saveAll(districts);

        ArrayList<CityType> cityTypes = new ArrayList<>();

        cityTypes.add(new CityType(0, "Capital", null));
        cityTypes.add(new CityType(0, "City", null));
        cityTypes.add(new CityType(0, "Town", null));
        cityTypes.add(new CityType(0, "Village", null));

        cityTypeService.saveAll(cityTypes);

        ArrayList<CityName> cityNames = new ArrayList<>();

        cityNames.add(new CityName(0, "Gadyach", null));
        cityNames.add(new CityName(0, "Globino", null));
        cityNames.add(new CityName(0, "Horishni Plavni", null));
        cityNames.add(new CityName(0, "Grebyonka", null));
        cityNames.add(new CityName(0, "Zavodskoye", null));
        cityNames.add(new CityName(0, "Zenkov", null));
        cityNames.add(new CityName(0, "Karlovka", null));
        cityNames.add(new CityName(0, "Kobelyaki", null));
        cityNames.add(new CityName(0, "Kremenchuk", null));
        cityNames.add(new CityName(0, "Lokhvytsa", null));
        cityNames.add(new CityName(0, "Lubny", null));
        cityNames.add(new CityName(0, "Mirgorod", null));
        cityNames.add(new CityName(0, "Pyryatin", null));
        cityNames.add(new CityName(0, "Poltava", null));
        cityNames.add(new CityName(0, "Khorol", null));
        cityNames.add(new CityName(0, "Dikanka", null));
        cityNames.add(new CityName(0, "Kotelva", null));
        cityNames.add(new CityName(0, "New Sanzhary", null));
        cityNames.add(new CityName(0, "Opishna", null));
        cityNames.add(new CityName(0, "Konotop", null));
        cityNames.add(new CityName(0, "Shostka", null));
        cityNames.add(new CityName(0, "Akhtyrka", null));
        cityNames.add(new CityName(0, "Romny", null));
        cityNames.add(new CityName(0, "Glukhov", null));
        cityNames.add(new CityName(0, "Lebedin", null));
        cityNames.add(new CityName(0, "Krolevets", null));
        cityNames.add(new CityName(0, "Trostyanets", null));
        cityNames.add(new CityName(0, "Belopolye", null));
        cityNames.add(new CityName(0, "Krasnopole", null));
        cityNames.add(new CityName(0, "Seredina-Buda", null));
        cityNames.add(new CityName(0, "Voronezh", null));
        cityNames.add(new CityName(0, "Stepanovka", null));
        cityNames.add(new CityName(0, "Lipovaya Dolina", null));
        cityNames.add(new CityName(0, "Nedrigailov", null));
        cityNames.add(new CityName(0, "Sumy", null));

        cityNameService.saveAll(cityNames);

        ArrayList<City> cities = new ArrayList<>();
//towns
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(14), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(6), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(7), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(8), null));
        //cities
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(16), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(17), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(18), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(4), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(19), null));

        cities.add(new City(0, districtService.getReferenceById(3), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(12), null));
        cities.add(new City(0, districtService.getReferenceById(3), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(1), null));
        cities.add(new City(0, districtService.getReferenceById(3), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(5), null));
        cities.add(new City(0, districtService.getReferenceById(3), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(10), null));

        cities.add(new City(0, districtService.getReferenceById(2), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(11), null));
        cities.add(new City(0, districtService.getReferenceById(2), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(13), null));
        cities.add(new City(0, districtService.getReferenceById(2), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(15), null));

        cities.add(new City(0, districtService.getReferenceById(1), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(9), null));
        cities.add(new City(0, districtService.getReferenceById(1), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(2), null));
        cities.add(new City(0, districtService.getReferenceById(1), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(3), null));

        cities.add(new City(0, districtService.getReferenceById(5), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(22), null));
        cities.add(new City(0, districtService.getReferenceById(5), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(27), null));

        cities.add(new City(0, districtService.getReferenceById(6), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(20), null));
        cities.add(new City(0, districtService.getReferenceById(6), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(26), null));

        cities.add(new City(0, districtService.getReferenceById(7), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(23), null));
        cities.add(new City(0, districtService.getReferenceById(7), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(33), null));
        cities.add(new City(0, districtService.getReferenceById(7), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(34), null));

        cities.add(new City(0, districtService.getReferenceById(8), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(35), null));
        cities.add(new City(0, districtService.getReferenceById(8), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(28), null));
        cities.add(new City(0, districtService.getReferenceById(8), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(25), null));

        cities.add(new City(0, districtService.getReferenceById(9), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(21), null));
        cities.add(new City(0, districtService.getReferenceById(9), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(30), null));
        cities.add(new City(0, districtService.getReferenceById(9), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(24), null));

        cityService.saveAll(cities);
        System.out.println(cityService.findAll());

        ArrayList<StreetType> streetTypes = new ArrayList<>();
        streetTypes.add(new StreetType(0, "Street", null));
        streetTypes.add(new StreetType(0, "Avenue", null));
        streetTypes.add(new StreetType(0, "Boulevard", null));
        streetTypes.add(new StreetType(0, "Court", null));
        streetTypes.add(new StreetType(0, "Drive", null));
        streetTypes.add(new StreetType(0, "Lane", null));
        streetTypes.add(new StreetType(0, "Alley", null));

        streetTypeService.saveAll(streetTypes);

        ArrayList<StreetName> streetNames = new ArrayList<>();

        streetNames.add(new StreetName(0, "Floral", null));
        streetNames.add(new StreetName(0, "Spring", null));
        streetNames.add(new StreetName(0, "Sunny", null));
        streetNames.add(new StreetName(0, "Apricot", null));
        streetNames.add(new StreetName(0, "Garden", null));
        streetNames.add(new StreetName(0, "Meadow", null));
        streetNames.add(new StreetName(0, "Central", null));
        streetNames.add(new StreetName(0, "Harmony", null));
        streetNames.add(new StreetName(0, "Happiness", null));
        streetNames.add(new StreetName(0, "Lime", null));
        streetNames.add(new StreetName(0, "Rozhdestvenskaya", null));

        streetNameService.saveAll(streetNames);

        ArrayList<Street> streets = new ArrayList<>();

        streets.add(new Street(0,streetTypeService.getReferenceById(1),streetNameService.getReferenceById(1),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(2),streetNameService.getReferenceById(2),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(2),streetNameService.getReferenceById(4),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(3),streetNameService.getReferenceById(7),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(4),streetNameService.getReferenceById(4),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(5),streetNameService.getReferenceById(9),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(5),streetNameService.getReferenceById(8),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(6),streetNameService.getReferenceById(3),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(2),streetNameService.getReferenceById(1),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(6),streetNameService.getReferenceById(5),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(7),streetNameService.getReferenceById(6),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(4),streetNameService.getReferenceById(8),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(2),streetNameService.getReferenceById(1),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(4),streetNameService.getReferenceById(2),null));
        streets.add(new Street(0,streetTypeService.getReferenceById(3),streetNameService.getReferenceById(7),null));

        streetService.saveAll(streets);

        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(new Address(0,"10","4",null,cityService.getReferenceById(1),streetService.getReferenceById(1)));
        addresses.add(new Address(0,"1","5",null,cityService.getReferenceById(2),streetService.getReferenceById(2)));
        addresses.add(new Address(0,"2","6",null,cityService.getReferenceById(3),streetService.getReferenceById(3)));
        addresses.add(new Address(0,"3","7",null,cityService.getReferenceById(4),streetService.getReferenceById(4)));
        addresses.add(new Address(0,"5","54",null,cityService.getReferenceById(5),streetService.getReferenceById(5)));
        addresses.add(new Address(0,"1123","34",null,cityService.getReferenceById(6),streetService.getReferenceById(5)));
        addresses.add(new Address(0,"23","34",null,cityService.getReferenceById(7),streetService.getReferenceById(6)));
        addresses.add(new Address(0,"546","23",null,cityService.getReferenceById(8),streetService.getReferenceById(6)));
        addresses.add(new Address(0,"2","12",null,cityService.getReferenceById(9),streetService.getReferenceById(7)));
        addresses.add(new Address(0,"56","6",null,cityService.getReferenceById(10),streetService.getReferenceById(8)));
        addresses.add(new Address(0,"2","54",null,cityService.getReferenceById(11),streetService.getReferenceById(9)));
        addresses.add(new Address(0,"4","76",null,cityService.getReferenceById(2),streetService.getReferenceById(10)));
        addresses.add(new Address(0,"56","72",null,cityService.getReferenceById(12),streetService.getReferenceById(11)));
        addresses.add(new Address(0,"123","98",null,cityService.getReferenceById(11),streetService.getReferenceById(11)));
        addresses.add(new Address(0,"86","122",null,cityService.getReferenceById(11),streetService.getReferenceById(12)));
        addresses.add(new Address(0,"43","323",null,cityService.getReferenceById(14),streetService.getReferenceById(13)));
        addresses.add(new Address(0,"45","45",null,cityService.getReferenceById(32),streetService.getReferenceById(14)));
        addresses.add(new Address(0,"65","122",null,cityService.getReferenceById(12),streetService.getReferenceById(15)));
        addresses.add(new Address(0,"23","657",null,cityService.getReferenceById(3),streetService.getReferenceById(4)));
        addresses.add(new Address(0,"5","4",null,cityService.getReferenceById(4),streetService.getReferenceById(6)));

        addressService.saveAll(addresses);


        /**/
    }


}
