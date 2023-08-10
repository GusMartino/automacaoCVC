#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @FlightAvailabilityIda @Cenário01
Funcionalidade: Validação de get em FlightAvailability Ida
    Eu como usuário quero fazer pesquisa de passagens de Ida e validar retorno

  @CT01 @Teste
  Cenário: Get com um adulto SAO/RIO
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=SAO,RIO,2023-10-10&packageGroup=GW-CERT&economyClass=YES&economyPremiumClass=YES"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GRU"
    E válido em body response aeroporto chegada "GIG"
    E ao válidar em body response se há passageiro "ADT" guardo o rateToken "CT01"

  
   @CT02 
   Cenário: Get com um adulto e uma criança SAO/MAD
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,7&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=SAO,MAD,2023-10-10&packageGroup=GW-CERT&businessClass=YES"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GRU"
    E válido em body response aeroporto chegada "MAD"
    E válido em body response passageiro "CHD"
    E ao válidar em body response se há passageiro "ADT" guardo o rateToken "CT02"
    
   @CT03 
   Cenário: Get com um adulto e um bebê GIG/BPS
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&ages=30,0&source=NLAT&routes=RIO,BPS,2023-11-20&packageGroup=GW-CERT"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GIG"
    E válido em body response aeroporto chegada "BPS"
    E válido em body response passageiro "INF"
    E ao válidar em body response se há passageiro "ADT" guardo o rateToken "CT03"

   @CT04
   Cenário: Get com nove adultos MAD/SAO
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,30,30,30,30,30,30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyPremiumClass=YES&routes=MAD,SAO,2023-10-10&packageGroup=GW-CERT"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "MAD"
    E válido em body response aeroporto chegada "GRU"
    E válido em body response quantidade de passageiros 9 "ADTS"
    E ao válidar em body response se há passageiro "ADT" guardo o rateToken "CT04"
    
   @CT05
   Cenário: Get com um adulto e oito crianças BPS/FLN
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,9,9,9,9,9,9,9,9&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=BPS,FLN,2023-10-20&economyClass=YES&packageGroup=GW-CERT"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "BPS"
    E válido em body response aeroporto chegada "FLN"
    E válido em body response passageiro "CHD"
    E válido em body response quantidade de passageiros 8 "CHDS"
    E ao válidar em body response se há passageiro "ADT" guardo o rateToken "CT05"    
    
   @CT06
   Cenário: Get com três adultos, três crianças e três bebês FLN/GRU
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,9,9,9,0,0,0&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=FLN,GRU,2023-10-20&packageGroup=GW-CERT"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "FLN"
    E válido em body response aeroporto chegada "GRU"
    E válido em body response passageiro "CHD"      
    E válido em body response passageiro "INF"
    E válido em body response quantidade de passageiros 3 "De cada"   
    E ao válidar em body response se há passageiro "ADT" guardo o rateToken "CT06"   