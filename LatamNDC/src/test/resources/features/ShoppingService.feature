#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @FlightAvailabilityIda
Funcionalidade: Validação de get em FlightAvailability
    Eu como usuário quero fazer pesquisa de passagens de Ida e validar retorno

  @CT01
  Cenário: Get com um adulto SAO/RIO
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=SAO,RIO,2023-10-10&packageGroup=GW-CERT&businessClass=ALSO&airCompanies="
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GRU"
    E válido em body response aeroporto chegada "GIG"
    E válido em body response se há passageiro "ADT"
  
   @CT02 
   Cenário: Get com um adulto e uma criança SAO/MAD
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,11&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=SAO,MAD,2023-11-20&packageGroup=GW-CERT&businessClass=ALSO&airCompanies="
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GRU"
    E válido em body response aeroporto chegada "MAD"
    E válido em body response se há passageiro "ADT"
    E válido em body response passageiro "CHD"
    
   @CT03 
   Cenário: Get com um adulto e uma criança SAO/MAD
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,0&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&routes=RIO,BPS,2023-11-20&packageGroup=GW-CERT&businessClass=ALSO&airCompanies="
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GIG"
    E válido em body response aeroporto chegada "BPS"
    E válido em body response se há passageiro "ADT"
    E válido em body response passageiro "CHD"