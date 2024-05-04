package com.github.andylke.demo;

import com.github.andylke.demo_spring_ws.GetCountryRequest;
import com.github.andylke.demo_spring_ws.GetCountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@RequiredArgsConstructor
@Endpoint
public class CountryEndpoint {

  private final CountryRepository countryRepository;

  @PayloadRoot(namespace = CountryEndpointConfig.NAMESPACE_URI, localPart = "getCountryRequest")
  @ResponsePayload
  public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
    GetCountryResponse response = new GetCountryResponse();
    response.setCountry(countryRepository.findByName(request.getName()));
    return response;
  }
}
