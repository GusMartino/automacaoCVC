
#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @FlightAvailability @Cenário01 @InformativePricing @BookingCreate @BookingIssue @CancellBNPL 
Funcionalidade: Validação de get em FlightAvailability Ida
    Eu como usuário quero fazer pesquisa de passagens de Ida e validar retorno

  @CT01
  Cenário: Get com um adulto SAO/RIO
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=SAO,RIO,2023-12-10&packageGroup=GW-CERT&economyClass=YES&economyPremiumClass=YES"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GRU"
    E válido em body response aeroporto chegada "GIG"
    E guardo o rateToken "CT01" da companhia aérea esperada "LATAM"

  
   @CT02 
   Cenário: Get com um adulto e uma criança BPS/GIG
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,7&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=BPS,GIG,2023-12-12&packageGroup=GW-CERT&economyPremiumClass=YES"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "BPS"
    E válido em body response aeroporto chegada "GIG"
    E válido em body response passageiro "CHD"
    E guardo o rateToken "CT02" da companhia aérea esperada "LATAM"

    
   @CT03 
   Cenário: Get com um adulto e um bebê GIG/BPS
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&ages=30,0&source=NLAT&routes=RIO,BPS,2023-12-20&packageGroup=GW-CERT"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GIG"
    E válido em body response aeroporto chegada "BPS"
    E válido em body response passageiro "INF"
    E guardo o rateToken "CT03" da companhia aérea esperada "LATAM"


   @CT04 @Test
   Cenário: Get com nove adultos NAT/FOR
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,30,30,30,30,30,30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyPremiumClass=YES&routes=NAT,FOR,2023-12-11&packageGroup=GW-CERT"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "NAT"
    E válido em body response aeroporto chegada "FOR"
    E válido em body response quantidade de passageiros 9 "ADTS"
    E guardo o rateToken "CT04" da companhia aérea esperada "LATAM"
    
   @CT05 @Test
   Cenário: Get com um adulto e oito crianças BPS/FLN
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,9,9,9,9,9,9,9,9&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=BPS,FLN,2023-12-20&economyClass=YES&packageGroup=GW-CERT"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "BPS"
    E válido em body response aeroporto chegada "FLN"
    E válido em body response passageiro "CHD"
    E válido em body response quantidade de passageiros 8 "CHDS"
    E guardo o rateToken "CT05" da companhia aérea esperada "LATAM"  
    
   @CT06
   Cenário: Get com três adultos, três crianças e três bebês FLN/GRU
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,9,9,9,0,0,0&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=FLN,GRU,2023-12-20&packageGroup=GW-CERT"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "FLN"
    E válido em body response aeroporto chegada "GRU"
    E válido em body response passageiro "CHD"      
    E válido em body response passageiro "INF"
    E válido em body response quantidade de passageiros 3 "De cada"   
    E guardo o rateToken "CT06" da companhia aérea esperada "LATAM"   
    
    @CT07 
    Cenário: Get com um adulto estrangeiro DXB/GRU
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&ages=30&source=NLAT&routes=RIO,SAO,2023-12-20&packageGroup=GW-CERT"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GIG"
    E válido em body response aeroporto chegada "GRU"
    E guardo o rateToken "CT07" da companhia aérea esperada "LATAM"