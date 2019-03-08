package com.fedex.homeworkapp.exam;

import com.fedex.homeworkapp.exam.CountryCodesDTO;
import com.fedex.homeworkapp.exam.DefinitionsDTO;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class ExternalAPIController {

    @GetMapping("/countrycodes")
    @ResponseStatus(HttpStatus.OK)
    public CountryCodesDTO getCountryCodes() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("https://restcountries-v1.p.rapidapi.com/all")
                .header("X-RapidAPI-Key", System.getenv("RAPID_API_KEY"))
                .asJson();
        JSONArray jsonArray = response.getBody().getArray();
        CountryCodesDTO countryCodesDTO = new CountryCodesDTO();
        List<String> countryCodes = IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject)jsonArray.get(index)).optString("alpha3Code"))
                .collect(Collectors.toList());
        countryCodesDTO.setCountryCodes(countryCodes);
        return countryCodesDTO;
    }

    @GetMapping("/urbandictionary/define")
    public DefinitionsDTO externalAPI(@RequestParam(name = "term") String term) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=" + term)
                .header("X-RapidAPI-Key", System.getenv("RAPID_API_KEY"))
                .asJson();
        JSONArray jsonArray = response.getBody().getObject().getJSONArray("list");
        DefinitionsDTO definitionsDTO = new DefinitionsDTO();
        List<String> definitions = IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject)jsonArray.get(index)).optString("definition"))
                .collect(Collectors.toList());
        definitionsDTO.setDefinitions(definitions);
        return definitionsDTO;
    }
}
