package com.example.isro.controller;

import com.example.isro.model.CustomerSatellite;
import com.example.isro.model.FilterCustomerSatelliteDTO;
import com.example.isro.service.IsroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/isro")
public class IsroController {

    @Autowired
    IsroService isroService;

    public static final Logger LOG = LoggerFactory.getLogger(IsroController.class);

    @PostMapping("/rockets")
    public ResponseEntity<String> dumpRocketDetails(){
        String url = "https://isro.vercel.app/api/launchers";
        try{
            URL rocketJsonUrl = new URL(url);
            return new ResponseEntity<>(isroService.dumpRocketData(rocketJsonUrl),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/customer_satellites")
    public ResponseEntity<String> dumpSatelliteDetails(){
        String url = "https://isro.vercel.app/api/customer_satellites";
        try{
            URL customerSatelliteJsonUrl = new URL(url);
            String response = isroService.dumpCustomerSatelliteData(customerSatelliteJsonUrl);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/create-satellite")
    public ResponseEntity<String> postSatellite(@RequestBody CustomerSatellite customerSatellite){
        return new ResponseEntity<>(isroService.createSatellite(customerSatellite),HttpStatus.OK);
    }

    @PostMapping("/delete-satellite")
    public ResponseEntity<String> deleteSatellite(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(isroService.deleteSatellite(id),HttpStatus.OK);
    }

    @GetMapping("/satellites")
    public ResponseEntity<List<CustomerSatellite>> getAllSatellites(){
        return new ResponseEntity<List<CustomerSatellite>>(isroService.getAllSatellites(),HttpStatus.OK);
    }

    @PutMapping("/update-satellite/{id}")
    public ResponseEntity<CustomerSatellite> updateSatellite(@PathVariable(name = "id") String satelliteId, @RequestBody CustomerSatellite customerSatellite){
        return new ResponseEntity<>(isroService.updateSatellite(satelliteId,customerSatellite),HttpStatus.OK);
    }

    @GetMapping("/search-satellite")
    public ResponseEntity<List<CustomerSatellite>> getCustomerSatellites(@RequestBody List<FilterCustomerSatelliteDTO> filterCustomerSatelliteDTOList){
        return new ResponseEntity<>(isroService.getSearchedCustomerSatellites(filterCustomerSatelliteDTOList),HttpStatus.OK);
    }
}
