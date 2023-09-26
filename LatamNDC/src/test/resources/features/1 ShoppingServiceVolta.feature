#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @FlightAvailability @Cenário02 @IdaEVolta
Funcionalidade: Validação de get em FlightAvailability Ida e Volta
    Eu como usuário quero fazer pesquisa de passagens de Ida e volta e validar informações importantes de retorno

  @CT01 
  Cenário: Get com um adulto SAO/RIO e RIO/SAO
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=GRU,GIG,2023-11-15, GIG,GRU,2023-12-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "GRU"
    E válido em body response aeroporto chegada e volta "GIG"
    E se houver passageiro "ADT" em response pego token de ida "GRU" "tokenIdaCT01" e volta "GIG" "tokenVoltaCT01"

  
   @CT02 
   Cenário: Get com um adulto e uma criança SAO/MAD e MAD/SAO
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,9&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=GRU,MAD,2023-11-15, MAD,SAO,2023-12-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "GRU"
    E válido em body response aeroporto chegada e volta "MAD"
    E se houver passageiro "ADT" em response pego token de ida "GRU" "tokenIdaCT02" e volta "MAD" "tokenVoltaCT02"
    E válido em body response passageiro alternativo "CHD"
    
   @CT03 
   Cenário: Get com um adulto e um bebê GIG/BPS e BPS/GIG
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,1&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=GIG,BPS,2023-11-15, BPS,GIG,2023-12-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "GIG"
    E válido em body response aeroporto chegada e volta "BPS"
    E se houver passageiro "ADT" em response pego token de ida "GIG" "tokenIdaCT03" e volta "BPS" "tokenVoltaCT03"
    E válido em body response passageiro alternativo "INF"

   @CT04
   Cenário: Get com nove adultos NAT/FOR e FOR/NAT
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,30,30,30,30,30,30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=FOR,NAT,2023-11-15, NAT,FOR,2023-12-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "NAT"
    E válido em body response aeroporto chegada e volta "FOR"
    E se houver passageiro "ADT" em response pego token de ida "NAT" "tokenIdaCT04" e volta "FOR" "tokenVoltaCT04"
    E válido em body response quantidade de passageiros no total 9 "ADTS"

    
   @CT05
   Cenário: Get com um adulto e oito crianças BPS/FLN e FLN/BPS
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,8,8,8,8,8,8,8,8&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=FLN,BPS,2023-11-15, BPS,FLN,2023-12-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "BPS"
    E válido em body response aeroporto chegada e volta "FLN"
    E se houver passageiro "ADT" em response pego token de ida "BPS" "tokenIdaCT05" e volta "FLN" "tokenVoltaCT05"
    E válido em body response quantidade de passageiros alternativos 8 "CHDS"

    
   @CT06
   Cenário: Get com três adultos, três crianças e três bebês FLN/GRU e GRU/FLN
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,1,1,1,9,9,9&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=FLN,GRU,2023-11-15, GRU,FLN,2023-12-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "FLN"
    E válido em body response aeroporto chegada e volta "GRU"
    E se houver passageiro "ADT" em response pego token de ida "FLN" "tokenIdaCT06" e volta "GRU" "tokenVoltaCT06"
    E válido em body response passageiro alternativo "CHD"      
    E válido em body response passageiro alternativo "INF"

    
  @CT07 
  Cenário: Get com um adulto estrangeiro GRU/DXB e DXB/GRU
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=GRU,DXB,2023-11-15, DXB,GRU,2023-12-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "GRU"
    E válido em body response aeroporto chegada e volta "DXB"
    E se houver passageiro "ADT" em response pego token de ida "GRU" "tokenIdaCT07" e volta "DXB" "tokenVoltaCT07"


