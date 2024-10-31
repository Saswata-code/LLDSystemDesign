package com.example.isro.service;

import com.example.isro.model.CustomerSatellite;
import com.example.isro.model.FilterCustomerSatelliteDTO;
import com.example.isro.model.Rocket;
import com.example.isro.model.RocketType;
import com.example.isro.repository.CustomerSatelliteRepository;
import com.example.isro.repository.RocketRepository;
import com.example.isro.specification.CustomerSatelliteSpecification;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.*;

@Service
public class IsroService {

    public static final Logger LOG = LoggerFactory.getLogger(IsroService.class);

    @Autowired
    RocketRepository rocketRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerSatelliteRepository customerSatelliteRepository;

    public String dumpRocketData(URL jsonURL){

        try{
            LOG.info("Inside Rocket Service");
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode rocketArrayNode = (ArrayNode) objectMapper.readTree(jsonURL).get("launchers");
            LOG.info("The rocketArrayNode is: " + rocketArrayNode);
            List<Rocket> rockets = new ArrayList<>();
            if(rocketArrayNode.isArray()){
                for(JsonNode rocketItem : rocketArrayNode){
                    Rocket rocket = new Rocket();
                    rocket.setId(rocketItem.get("id").toString());
                    rocket.setRocketType(RocketType.NEW);
                    rocket.setRegisteredDate(new Date());
                    rockets.add(rocket);
                }
            }
            rocketRepository.saveAll(rockets);
            return "Rocket Data Dump Successfull";

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String dumpCustomerSatelliteData(URL CustomerSatelliteJSONURL) {

        try {
            ArrayNode customerSatelliteArrayNode = (ArrayNode) objectMapper.readTree(CustomerSatelliteJSONURL).get("customer_satellites");
            LOG.info("The CustomerSatellite ArrayNode is: " + customerSatelliteArrayNode);
            List<CustomerSatellite> customerSatellites = new ArrayList<>();
            if (customerSatelliteArrayNode.isArray()) {
                for (JsonNode customerSatelliteNode : customerSatelliteArrayNode) {
                    LOG.info("The Customer Satellite ID is: " + customerSatelliteNode.get("id"));
                    CustomerSatellite customerSatellite = new CustomerSatellite();
                    String satelliteID = customerSatelliteNode.get("id").toString().replaceAll("\"", "");
                    String country = customerSatelliteNode.get("country").toString().replaceAll("\"", "");
                    String launchDate = customerSatelliteNode.get("launch_date").toString().replaceAll("\"", "");
                    Double mass = customerSatelliteNode.get("mass").asDouble();
                    String launcher = customerSatelliteNode.get("launcher").toString().replaceAll("\"", "");
                    customerSatellite.setId(satelliteID);
                    customerSatellite.setCountry(country);
                    customerSatellite.setLaunchDate(launchDate);
                    customerSatellite.setMass(mass);
                    customerSatellite.setLauncher(launcher);
                    customerSatellites.add(customerSatellite);
                }
            }
            customerSatelliteRepository.saveAll(customerSatellites);
            return "Customer Satellite Dump Successfull";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String createSatellite(CustomerSatellite customerSatellite){
        customerSatelliteRepository.save(customerSatellite);
        return "Satellite Creation successfull";
    }

    public CustomerSatellite updateSatellite(String satelliteId,CustomerSatellite customerSatellite){
        Optional<CustomerSatellite> customerSatelliteOptional = customerSatelliteRepository.findById(satelliteId);

        if(customerSatelliteOptional.isPresent()){
            CustomerSatellite presentCustomerSatellite = customerSatelliteOptional.get();
            presentCustomerSatellite.setCountry(customerSatellite.getCountry());
            presentCustomerSatellite.setLauncher(customerSatellite.getLauncher());
            presentCustomerSatellite.setLaunchDate(customerSatellite.getLaunchDate());
            presentCustomerSatellite.setMass(customerSatellite.getMass());
            customerSatelliteRepository.save(presentCustomerSatellite);
            return presentCustomerSatellite;
        }

        return null;
    }

    public String deleteSatellite(String id){
        customerSatelliteRepository.deleteById(id);
        return "Satellite Deleted successfully";
    }

    public List<CustomerSatellite> getAllSatellites(){
        List<CustomerSatellite> customerSatelliteList = customerSatelliteRepository.findAll();
        return customerSatelliteList;
    }


    public List<CustomerSatellite> getSearchedCustomerSatellites(List<FilterCustomerSatelliteDTO> filterCustomerSatelliteDTOList){
        return customerSatelliteRepository.findAll(CustomerSatelliteSpecification.columnsEqual(filterCustomerSatelliteDTOList));
    }
}
